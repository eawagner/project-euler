package practice.project.euler.problem.p50_59;

import practice.project.euler.Problem;

import java.io.BufferedReader;
import java.util.*;

import static java.util.Map.Entry;
import static practice.project.euler.util.GeneralUtil.getResource;

/*
In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

    * High Card: Highest value card.
    * One Pair: Two cards of the same value.
    * Two Pairs: Two different pairs.
    * Three of a Kind: Three cards of the same value.
    * Straight: All cards are consecutive values.
    * Flush: All cards of the same suit.
    * Full House: Three of a kind and a pair.
    * Four of a Kind: Four cards of the same value.
    * Straight Flush: All cards are consecutive values of same suit.
    * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest value wins; for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, both players have a pair of queens, then highest cards in each hand are compared (see example 4 below); if the highest cards tie then the next highest cards are compared, and so on.

Consider the following five hands dealt to two players:
Hand	 	Player 1	 	Player 2	 	Winner
1	 	5H 5C 6S 7S KD
Pair of Fives
	 	2C 3S 8S 8D TD
Pair of Eights
	 	Player 2
2	 	5D 8C 9S JS AC
Highest card Ace
	 	2C 5C 7D 8S QH
Highest card Queen
	 	Player 1
3	 	2D 9C AS AH AC
Three Aces
	 	3D 6D 7D TD QD
Flush with Diamonds
	 	Player 2
4	 	4D 6S 9H QH QC
Pair of Queens
Highest card Nine
	 	3D 6D 7H QD QS
Pair of Queens
Highest card Seven
	 	Player 1
5	 	2H 2D 4C 4D 4S
Full House
With Three Fours
	 	3C 3D 3S 9S 9D
Full House
with Three Threes
	 	Player 1

The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.

How many hands does Player 1 win?

 */
public class Problem54 implements Problem{
    public String getAnswer() throws Exception {
        BufferedReader reader = getResource("problem54.txt");
        String line;
        int retVal = 0;
        while ((line = reader.readLine()) != null) {
            Hand hand1 = new Hand();
            Hand hand2 = new Hand();
            String play[] = line.split(" ");
            for (int i = 0;i<play.length/2;i++)
                hand1.addCard(play[i]);


            for (int i = play.length/2;i<play.length;i++)
                hand2.addCard(play[i]);


            if (hand1.compareTo(hand2) > 0)
                retVal ++;

        }


        return Integer.toString(retVal);
    }


    private class Hand implements Comparable<Hand> {

        List<Card> cards = new ArrayList<Card>(5);
        Map<Integer,Integer> cardMap = new HashMap<Integer, Integer>(5);

        public int compareTo(Hand o) {
            Collections.sort(this.cards);
            Collections.sort(o.cards);

            int result;

            result = compare(checkStraight(), checkFlush(), o.checkStraight(), o.checkFlush());
            if (result != 0)
                return result;

            result = compare(checkGroup(4, 1), o.checkGroup(4, 1));
            if (result != 0)
                return result;

            int h1_high3 = checkGroup(3,1);
            int h2_high3 = o.checkGroup(3,1);
            int h1_pair = checkGroup(2,1);
            int h2_pair = o.checkGroup(2,1);

            if ((h1_high3 > 0 && h1_pair > 0) || (h2_high3 > 0 && h2_pair > 0)) {
                result = compare(checkGroup(3,1), o.checkGroup(3,1));
                if (result != 0)
                    return result;
            }

            result = compare(checkFlush(), o.checkFlush());
            if (result != 0)
                return result;

            result = compare(checkStraight(), o.checkStraight());
            if (result != 0)
                return result;

            result = compare(h1_high3, h2_high3);
            if (result != 0)
                return result;

            //This is the only one that won't work if the top two pairs on the same, but produces the correct result anyway.
            result = compare(checkGroup(2,2), o.checkGroup(2,2));
            if (result != 0)
                return result;

            result = compare(h1_pair, h2_pair);
            if (result != 0)
                return result;

            return compare(cards.get(cards.size()-1).value, o.cards.get(o.cards.size()-1).value);

        }

        private int checkStraight() {
            if (cards.size() == 0)
                return 0;

            int firstCard = cards.get(0).value;
            for (int i = 1;i<cards.size();i++)
                if (cards.get(i).value != firstCard + i)
                    return 0;

            return cards.get(cards.size()-1).value;
        }

        private int checkFlush() {
            if (cards.size() == 0)
                return 0;

            int firstSuit = cards.get(0).suit;
            for (int i = 1;i<cards.size();i++)
                if (cards.get(i).suit != firstSuit)
                    return 0;

            return cards.get(cards.size()-1).value;
        }

        private int checkGroup(int size, int num) {
            int highest = 0;
            int numFound = 0;
            for (Entry<Integer,Integer> group : cardMap.entrySet()) {
                if (group.getValue() == size) {
                    numFound++;
                    if (group.getKey() > highest)
                        highest = group.getKey();
                }
            }

            if (numFound >= num)
                return highest;

            return 0;
        }


        private int compare(int h1, int h2) {
            return new Integer(h1).compareTo(h2);
        }

        private int compare(int h1_1, int h1_2, int h2_1, int h2_2) {
            if (compare(h1_1,h2_1) !=0)
                return compare(h1_1,h2_1);

            return compare(h1_2,h2_2);
        }

        public void addCard(String card) {
            Card cardObj = new Card(card);
            cards.add(cardObj);
            if (cardMap.containsKey(cardObj.value))
                cardMap.put(cardObj.value, cardMap.get(cardObj.value)+1);
            else
                cardMap.put(cardObj.value,1);

        }

        private class Card implements Comparable<Card>{
            int value;
            int suit;

            public Card(String card) {
                int tmpVal = (int)card.charAt(0);
                if (tmpVal >=50 && tmpVal<=58)
                    value = tmpVal-48;
                else if (tmpVal == 84) //ten
                    value = tmpVal - 84 + 10;
                else if (tmpVal == 74) //jack
                    value = tmpVal - 74 + 11;
                else if (tmpVal == 81) //queen
                    value = tmpVal - 81 + 12;
                else if (tmpVal == 75) //king
                    value = tmpVal - 75 + 13;
                else if (tmpVal == 65) //ace
                    value = tmpVal - 65 + 14;

                int tmpSuit = (int) card.charAt(1);
                if (tmpSuit==72) //hearts
                    suit = 0;
                else if(tmpSuit==83) //spades
                    suit = 1;
                else if(tmpSuit==67) //clubs
                    suit = 2;
                else if(tmpSuit==68) //diamonds
                    suit = 3;
            }

            public int compareTo(Card o) {
                return new Integer(value).compareTo(o.value);
            }
        }
    }

}
