package practice.project.euler.problem;


import practice.project.euler.Problem;

import java.util.TreeMap;

import static java.lang.String.format;
import static java.util.Collections.reverseOrder;

/*

In the game, Monopoly, the standard board is set up in the following way:
GO 	A1 	CC1 	A2 	T1 	R1 	B1 	CH1 	B2 	B3 	JAIL
H2 	  	C1
T2 	  	U1
H1 	  	C2
CH3 	  	C3
R4 	  	R2
G3 	  	D1
CC3 	  	CC2
G2 	  	D2
G1 	  	D3
G2J 	F3 	U2 	F2 	F1 	R3 	E3 	E2 	CH2 	E1 	FP

A player starts on the GO square and adds the scores on two 6-sided dice to determine the number of squares they advance in a clockwise direction. Without any further rules we would expect to visit each square with equal probability: 2.5%. However, landing on G2J (Go To Jail), CC (community chest), and CH (chance) changes this distribution.

In addition to G2J, and one card from each of CC and CH, that orders the player to go directly to jail, if a player rolls three consecutive doubles, they do not advance the result of their 3rd roll. Instead they proceed directly to jail.

At the beginning of the game, the CC and CH cards are shuffled. When a player lands on CC or CH they take a card from the top of the respective pile and, after following the instructions, it is returned to the bottom of the pile. There are sixteen cards in each pile, but for the purpose of this problem we are only concerned with cards that order a movement; any instruction not concerned with movement will be ignored and the player will remain on the CC/CH square.

    Community Chest (2/16 cards):
        Advance to GO
        Go to JAIL
    Chance (10/16 cards):
        Advance to GO
        Go to JAIL
        Go to C1
        Go to E3
        Go to H2
        Go to R1
        Go to next R (railway company)
        Go to next R
        Go to next U (utility company)
        Go back 3 squares.

The heart of this problem concerns the likelihood of visiting a particular square. That is, the probability of finishing at that square after a roll. For this reason it should be clear that, with the exception of G2J for which the probability of finishing on it is zero, the CH squares will have the lowest probabilities, as 5/8 request a movement to another square, and it is the final square that the player finishes at on each roll that we are interested in. We shall make no distinction between "Just Visiting" and being sent to JAIL, and we shall also ignore the rule about requiring a double to "get out of jail", assuming that they pay to get out on their next turn.

By starting at GO and numbering the squares sequentially from 00 to 39 we can concatenate these two-digit numbers to produce strings that correspond with sets of squares.

Statistically it can be shown that the three most popular squares, in order, are JAIL (6.24%) = Square 10, E3 (3.18%) = Square 24, and GO (3.09%) = Square 00. So these three most popular squares can be listed with the six-digit modal string: 102400.

If, instead of using two 6-sided dice, two 4-sided dice are used, find the six-digit modal string.

 */
public class Problem84 implements Problem {
    private static final int BOARD_SIZE = 40;
    private static final int GO = 0;
    private static final int JAIL = 10;
    private static final int GOTO_JAIL = 30;
    private static int[] COMM_CHEST = new int[]{2, 17, 33};
    private static int[] CHANCE = new int[]{7, 22, 36};
    private static int[] RAIL_ROAD = new int[]{5, 15, 25, 35};
    private static int[] UTILITY = new int[]{12,28};

    @Override
    public String getAnswer() throws Exception {

        /**
         * http://en.wikipedia.org/wiki/Examples_of_Markov_chains#A_very_simple_weather_model
         * Used this as an example and extrapolated out for all possible moves on a monopoly board.
         *
         * Also ignored order to cards to simplify possible values.
         */

        //Lowered to 100 after finding answer
        TreeMap<Double, Integer> results = genBoardProbs(4, 100);

        StringBuilder retval = new StringBuilder();
        int i = 0;
        for (int square : results.values()) {
            retval.append(format("%02d", square));
            i++;
            if (i == 3)
                break;
        }

        return retval.toString();
    }

    private static double[] getRoleProb(int diceSides) {

        double[] probabilities = new double[diceSides + diceSides];
        for (int i = 0; i < diceSides; i ++)
            for (int j = 0; j< diceSides; j++)
                probabilities[i + j + 1] = probabilities[i + j + 1] + (1.0 / (diceSides * diceSides));

        return probabilities;
    }

    private static int nextRR(int curr) {
        for (int rr : RAIL_ROAD)
            if (curr < rr)
                return rr;

        return RAIL_ROAD[0];
    }

    private static int nextUtil(int curr) {
        for (int util : UTILITY)
            if (curr < util)
                return util;

        return UTILITY[0];
    }

    private static double[][] mult(double[][] a, double[][] b) {
        if (a.length < 1 || a[0].length != b.length)
            throw new IllegalArgumentException("Invalid matrices");

        double[][] result = new double[a.length][b[0].length];

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < a[i].length; k++)
                    result[i][j] += (a[i][k] * b[k][j]);

        return result;
    }

    private static double[][] genMatrix(int diceSides) {
        double[][] matrix = new double[BOARD_SIZE][BOARD_SIZE];

        double[] roleProb = getRoleProb(diceSides);
        for (int i = 0;i< BOARD_SIZE;i++) {
            for (int j = 0;j< roleProb.length;j++)
                matrix[i][(i + j + 1) % BOARD_SIZE] = roleProb[j];

            //Fix 3 doubles
            matrix[i][JAIL] += (1.0/diceSides)*(1.0/diceSides)*(1.0/diceSides);
            for (int j = 1;j< roleProb.length;j+=2) {
                // 1 - (1/ (#sides^2 * prob(j)) * (1/ #sides)^2
                matrix[i][(i + j + 1) % BOARD_SIZE] *= 1.0 - (1.0/ (diceSides * diceSides * roleProb[j]) * (1.0/diceSides) * (1.0/diceSides));
            }


            //Fix Goto Jail
            matrix[i][JAIL] += matrix[i][GOTO_JAIL];
            matrix[i][GOTO_JAIL] = 0;

            //Fix Community Chest
            for (int cc : COMM_CHEST) {
                if (matrix[i][cc] > 0) {
                    matrix[i][GO] += matrix[i][cc] * 1.0/16;
                    matrix[i][JAIL] += matrix[i][cc] * 1.0/16;
                    matrix[i][cc] = matrix[i][cc] * 14.0/16; //Stay where we are.
                }
            }

            for (int ch : CHANCE) {
                if (matrix[i][ch] > 0) {
                    matrix[i][GO] += matrix[i][ch] * 1.0/16;
                    matrix[i][JAIL] += matrix[i][ch] * 1.0/16;
                    matrix[i][11] += matrix[i][ch] * 1.0/16;
                    matrix[i][24] += matrix[i][ch] * 1.0/16;
                    matrix[i][39] += matrix[i][ch] * 1.0/16;
                    matrix[i][5] += matrix[i][ch] * 1.0/16;
                    matrix[i][nextRR(ch)] += matrix[i][ch] * 2.0/16;
                    matrix[i][nextUtil(ch)] += matrix[i][ch] * 1.0/16;
                    matrix[i][ch-3] += matrix[i][ch] * 1.0/16;
                    matrix[i][ch] = matrix[i][ch] * 6.0/16; //Stay where we are.
                }
            }
        }

        return matrix;
    }

    private static TreeMap<Double, Integer> genBoardProbs(int diceSides, int numTurns) {

        double[][] matrix = genMatrix(diceSides);
        double[][] turnProb = new double[1][matrix.length];
        turnProb[0][0] = 1;
        for (int i = 0; i < numTurns - 1;i++)
            turnProb = mult(turnProb, matrix);

        //Reverse the ordering so that highest comes first
        TreeMap<Double, Integer> results = new TreeMap<Double, Integer>(reverseOrder());
        for (int i = 0;i< turnProb[0].length;i++)
            results.put(turnProb[0][i], i);

        return results;
    }

}
