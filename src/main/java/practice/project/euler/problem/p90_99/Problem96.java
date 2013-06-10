package practice.project.euler.problem.p90_99;


import practice.project.euler.Problem;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static practice.project.euler.util.GeneralUtil.getResource;
import static practice.project.euler.util.StringUtil.charToInt;

/*
Su Doku (Japanese meaning number place) is the name given to a popular puzzle concept. Its origin is unclear, but credit must be attributed to Leonhard Euler who invented a similar, and much more difficult, puzzle idea called Latin Squares. The objective of Su Doku puzzles, however, is to replace the blanks (or zeros) in a 9 by 9 grid in such that each row, column, and 3 by 3 box contains each of the digits 1 to 9. Below is an example of a typical starting puzzle grid and its solution grid.
0 0 3
9 0 0
0 0 1 	0 2 0
3 0 5
8 0 6 	6 0 0
0 0 1
4 0 0
0 0 8
7 0 0
0 0 6 	1 0 2
0 0 0
7 0 8 	9 0 0
0 0 8
2 0 0
0 0 2
8 0 0
0 0 5 	6 0 9
2 0 3
0 1 0 	5 0 0
0 0 9
3 0 0


4 8 3
9 6 7
2 5 1 	9 2 1
3 4 5
8 7 6 	6 5 7
8 2 1
4 9 3
5 4 8
7 2 9
1 3 6 	1 3 2
5 6 4
7 9 8 	9 7 6
1 3 8
2 4 5
3 7 2
8 1 4
6 9 5 	6 8 9
2 5 3
4 1 7 	5 1 4
7 6 9
3 8 2

A well constructed Su Doku puzzle has a unique solution and can be solved by logic, although it may be necessary to employ "guess and test" methods in order to eliminate options (there is much contested opinion over this). The complexity of the search determines the difficulty of the puzzle; the example above is considered easy because it can be solved by straight forward direct deduction.

The 6K text file, sudoku.txt (right click and 'Save Link/Target As...'), contains fifty different Su Doku puzzles ranging in difficulty, but all with unique solutions (the first puzzle in the file is the example above).

By solving all fifty puzzles find the sum of the 3-digit numbers found in the top left corner of each solution grid; for example, 483 is the 3-digit number found in the top left corner of the solution grid above.
 */
public class Problem96 implements Problem {
    private static final List<Integer> ALL_VALUES = asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    @Override
    public String getAnswer() throws Exception {
        BufferedReader reader = getResource("problem96.txt");
        long result = 0;

        while (reader.readLine() != null) {
            //ignore first line of each group.
            Puzzle puzzle = new Puzzle();
            for (int i = 0; i < 9; i++) {
                String line = reader.readLine();
                for (int j = 0; j < 9; j++) {
                    int value = charToInt(line.charAt(j));
                    if (value != 0)
                        puzzle.confirm(i, j, value);

                }
            }

            puzzle = solvePuzzle(puzzle);
            result += puzzle.getSolved()[0][0] * 100 + puzzle.getSolved()[0][1] * 10 + puzzle.getSolved()[0][2];
        }
        return Long.toString(result);
    }

    private static Puzzle solvePuzzle(Puzzle puzzle) {
        //First try and go through all the rows, cols, and regions to see if different numbers will work
        //If not then switch to a brute force technique that uses recursion.
        while (!puzzle.hasRequired()) {
            boolean changed = false;
            for (int n = 1; n < 10 && !puzzle.hasRequired(); n++) {
                for (int i = 0; i < 9 && !puzzle.hasRequired(); i++) {
                    changed |= checkRow(i, n, puzzle);
                    changed |= checkCol(i, n, puzzle);
                    changed |= checkRegion(i, n, puzzle);
                }
            }

            if (!changed)
                return bruteForce(puzzle);

        }

        return puzzle;
    }

    private static Puzzle bruteForce(Puzzle puzzle) {
        if (puzzle.isInvalid())
            return null;
        if (puzzle.isComplete())
            return puzzle;

        //Find cell with smallest available then start there.
        int row = 0;
        int col = 0;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j< 9; j++) {
                if (!puzzle.getAvailable().get(i).get(j).isEmpty() && puzzle.getAvailable().get(i).get(j).size() < smallest) {
                    smallest = puzzle.getAvailable().get(i).get(j).size();
                    row = i;
                    col = j;
                }
            }
        }

        for (int avail : puzzle.getAvailable().get(row).get(col)) {
            Puzzle copy = new Puzzle(puzzle);
            copy.confirm(row, col, avail, false);
            Puzzle result = bruteForce(copy);
            if (result != null)
                return result;

        }

        return null;
    }

    private static boolean checkRow(int row, int num, Puzzle puzzle) {
        int numFound = 0;
        for (int col = 0; col < 9; col++) {
            if (puzzle.getSolved()[row][col] == num)
                return false;

            if (puzzle.getAvailable().get(row).get(col).contains(num))
                numFound++;
        }

        if (numFound == 1) {
            for (int col = 0; col < 9; col++) {
                if (puzzle.getAvailable().get(row).get(col).contains(num)) {
                    puzzle.confirm(row, col, num);
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkCol(int col, int num, Puzzle puzzle) {
        int numFound = 0;
        for (int row = 0; row < 9; row++) {
            if (puzzle.getSolved()[row][col] == num)
                return false;

            if (puzzle.getAvailable().get(row).get(col).contains(num))
                numFound++;
        }

        if (numFound == 1) {
            for (int row = 0; row < 9; row++) {
                if (puzzle.getAvailable().get(row).get(col).contains(num)) {
                    puzzle.confirm(row, col, num);
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkRegion(int region, int num, Puzzle puzzle) {
        int numFound = 0;

        int rowStart = region/3 * 3;
        int colStart = region % 3 * 3;

        for (int row = rowStart ; row < rowStart + 3; row ++) {
            for (int col = colStart; col < colStart + 3; col++) {
                if (puzzle.getSolved()[row][col] == num)
                    return false;

                if (puzzle.getAvailable().get(row).get(col).contains(num))
                    numFound++;
            }
        }

        if (numFound == 1) {
            for (int row = rowStart ; row < rowStart + 3; row ++) {
                for (int col = colStart; col < colStart + 3; col++) {
                    if (puzzle.getAvailable().get(row).get(col).contains(num)) {
                        puzzle.confirm(row, col, num);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static class Puzzle {

        int required = 0;
        int[][] solved = new int[9][9];
        List<List<List<Integer>>> available;

        public Puzzle() {
            available = new ArrayList<List<List<Integer>>>(9);

            for (int i = 0; i< 9;i++) {
                available.add(new ArrayList<List<Integer>>(9));
                for (int j = 0; j< 9; j++)
                    available.get(i).add(new ArrayList<Integer>(ALL_VALUES));
            }
        }

        public Puzzle(Puzzle puzzle) {
            available = new ArrayList<List<List<Integer>>>(9);

            for (int i = 0; i< 9;i++) {
                available.add(new ArrayList<List<Integer>>(9));
                for (int j = 0; j< 9; j++) {
                    solved[i][j] = puzzle.getSolved()[i][j];
                    available.get(i).add(new ArrayList<Integer>(puzzle.getAvailable().get(i).get(j)));
                }
            }
        }

        public void confirm(int x, int y, int value) {
            confirm(x, y, value, true);
        }

        public void confirm(int x, int y, int value, boolean unsafe) {
            Object removeable = value;

            if (solved[x][y] == value)
                return;

            if (x == 0 && y < 3)
                required++;

            solved[x][y] = value;
            available.get(x).get(y).clear();

            //clear availability from horizontal rows.
            for (int j = 0; j < 9; j++) {
                if (available.get(x).get(j).size() == 0)
                    continue;

                available.get(x).get(j).remove(removeable);
                if (available.get(x).get(j).size() == 1 && unsafe)
                    confirm(x, j, available.get(x).get(j).get(0));
            }

            //clear availability from vertical rows.
            for (int i = 0; i < 9; i++) {
                if (available.get(i).get(y).size() == 0)
                    continue;

                available.get(i).get(y).remove(removeable);
                if (available.get(i).get(y).size() == 1 && unsafe)
                    confirm(i, y, available.get(i).get(y).get(0));
            }

            //clear availability from region.
            for (int i = 0 ; i<3; i++) {
                for (int j = 0; j<3; j++ ) {
                    int row = 3*(x/3) + i;
                    int col = 3*(y/3) + j;

                    if (available.get(row).get(col).size() == 0)
                        continue;

                    available.get(row).get(col).remove(removeable);
                    if (available.get(row).get(col).size() == 1 && unsafe)
                        confirm(row, col, available.get(row).get(col).get(0));
                }
            }
        }

        public boolean hasRequired() {
            return required == 3;
        }

        public boolean isInvalid() {
            for (int i = 0;i < 9;i++)
                for (int j = 0; j< 9; j++)
                    if (solved[i][j] == 0 && available.get(i).get(j).isEmpty())
                        return true;

            return false;
        }

        public boolean isComplete() {
            for (int i = 0;i < 9;i++)
                for (int j = 0; j< 9; j++)
                    if (available.get(i).get(j).size() != 0)
                        return false;

            return true;
        }

        public int[][] getSolved() {
            return solved;
        }

        public List<List<List<Integer>>> getAvailable() {
            return available;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < solved.length;i++) {
                for (int j = 0; j< solved[i].length; j++) {
                    sb.append(solved[i][j]);
                }
                sb.append("\n");
            }
            return sb.toString();
        };
    }
}
