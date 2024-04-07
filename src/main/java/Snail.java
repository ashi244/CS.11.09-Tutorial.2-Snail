public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null){
            return new int[0];
        }
        int rowNum = array2d.length;
        int colNum = array2d[0].length;
        int[] snail = new int[rowNum * colNum];
        int index = 0;
        int rowStart = 0;
        int rowEnd = rowNum - 1;
        int colStart = 0;
        int colEnd = colNum - 1;

        if (!isPerfectSquare(array2d)) {
            return new int[0];
        }

        while (index < snail.length) {
            for (int i = colStart; i <= colEnd; i++) {
                snail[index++] = array2d[rowStart][i];
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                snail[index++] = array2d[i][colEnd];
            }
            colEnd--;

            if (index < snail.length && rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    snail[index++] = array2d[rowEnd][i];
                }
                rowEnd--;
            }

            if (index < snail.length && colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    snail[index++] = array2d[i][colStart];
                }
                colStart++;
            }
        }
        return snail;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null){
            return new int[0][0];
        }
        if (!isPerfectSquare(array1d)){
            return new int[0][0];
        }
        int size = (int)Math.sqrt(array1d.length);
        int[][] snailArray = new int[size][size];
        int rowStart = 0, rowEnd = size - 1;
        int colStart = 0, colEnd = size - 1;
        int value = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse from left to right
            for (int col = colStart; col <= colEnd; col++) {
                snailArray[rowStart][col] = array1d[value - 1];
                value++;
            }
            rowStart++;

            // Traverse from top to bottom
            for (int row = rowStart; row <= rowEnd; row++) {
                snailArray[row][colEnd] = array1d[value - 1];
                value++;
            }
            colEnd--;

            // Traverse from right to left
            for (int col = colEnd; col >= colStart; col--) {
                snailArray[rowEnd][col] = array1d[value - 1];
                value++;
            }
            rowEnd--;

            // Traverse from bottom to top
            for (int row = rowEnd; row >= rowStart; row--) {
                snailArray[row][colStart] = array1d[value - 1];
                value++;
            }
            colStart++;
        }

        return snailArray;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int i = 0; i < array1d.length; i++){
            System.out.println(array1d[i]);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int i = 0; i < array2d.length; i++){
            for (int j = 0; j < array2d[i].length; j++){
                System.out.println(array2d[i][j]);
            }
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int square = (int)Math.sqrt(array1d.length);
        if ((square * square) == array1d.length){
            return true;
        }
        return false;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        int rowLength = array2d.length;
        for (int i = 0; i < array2d.length; i++){
            int colLength = array2d[i].length;
            if (colLength != rowLength){
                return false;
            }
        }
        return true;
    }


}
