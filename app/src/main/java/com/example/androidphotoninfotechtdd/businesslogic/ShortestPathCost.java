package com.example.androidphotoninfotechtdd.businesslogic;


public class ShortestPathCost {

    public String[] result = new String[3];

    //method to find shortest path cost and full path or not?
    public String path_weight(int[][] matrix) {
        int size_row = matrix.length;
        int size_column = matrix[0].length;
        int count = 0;
        if (findSmallestOneColumn(matrix, 0) > 50) {
            result[0] = "No";
            result[1] = 0 + "";
            path1 = "[]";
        } else {
            if (size_column > 1) {
                findSmallestOneColumnPath(matrix, size_column - 1);
                for (int colN = size_column - 2; colN >= 0; colN--) {
                    count++;
                    for (int rowN = 0; rowN < size_row; rowN++) {
                        findShortPath(matrix, rowN, colN, matrix[rowN][colN]);
                    }
                    int shortCostUptoThatColn = findSmallestOneColumn(matrix, colN);
                    System.out.println("cost minimum upto that coln " + shortCostUptoThatColn);
                    if (shortCostUptoThatColn < 50) {
                        findSmallestOneColumnPath(matrix, colN);//to find path
                        result[1] = shortCostUptoThatColn + "";
                        result[0] = "Yes";
                    } else {
                        result[1] = findSmallestOneColumn(matrix, colN + 1) + "";
                        System.out.println("result[1] " + result[1]);
                        result[0] = "No";
                        break;
                    }
                }
            } else {
                findSmallestOneColumnPath(matrix, 0);
                result[1] = findSmallestOneColumn(matrix, 0) + "";
                result[0] = "Yes";
            }
        }

        return "" + result[1];
    }

    //method to find small value in each column
    private int findSmallestOneColumn(int[][] matrix, int colum) {
        int size_row = matrix.length;
        int small_val = matrix[0][colum];
        int smallest_row = 0;
        int smallest_column = colum;

        //finding small value in array (here column)
        for (int i = 0; i < size_row; i++) {
            if (small_val > matrix[i][colum]) {
                small_val = matrix[i][colum];
                smallest_row = i;
                smallest_column = colum;
            }
        }
        return small_val;
    }

    //method to find position of element which belongs to small path in each column
    String path1 = "";
    private int findSmallestOneColumnPath(int[][] matrix, int colum) {
        int size_row = matrix.length;
        int small_val = matrix[0][colum];
        int smallest_row = 1;
        int smallest_column = colum;

        for (int i = 0; i < size_row; i++) {
            if (small_val > matrix[i][colum]) {
                small_val = matrix[i][colum];
                smallest_row = i + 1;
                smallest_column = colum;
            }

        }
        path1 = smallest_row + path1;
        return small_val;
    }

    // to find next columns 3 values which are near to the current column value in path.
    int value = 0;
    public void findShortPath(int[][] matrix, int row, int colu, int prev) {
        int size_row = matrix.length;
        int size_column = matrix[0].length;
        int rowToChange = row;
        int colToChange = colu;
        value = +prev;

        int x, y, z;
        if (colu < size_column - 1) {
            colu = colu + 1;
            int row_top = row - 1;
            int row_dow = row + 1;

            x = matrix[row][colu]; // middle_element

            if (row_top < 0)
                row_top = size_row - 1;
            y = matrix[row_top][colu];// top element

            if (row_dow > size_row - 1)
                row_dow = 0;

            z = matrix[row_dow][colu];// bottom element

            int a = row;
            int b = row_top;
            int c = row_dow;

            System.out.println("row " + row + " " + x);
            System.out.println("row-top " + row_top + " " + y);
            System.out.println("row-down " + row_dow + " " + z + "\n------------");

            int smallAmongThree = findSmallElement(x, y, z);

            matrix[rowToChange][colToChange] += smallAmongThree;

            System.out.println("small " + smallAmongThree);

        }
    }

    //find small element in 3 values x,y,z
    public int findSmallElement(int x, int y, int z) {
        if (x < y && x < z) {
            return x;
        } else {
            if (y < z) {
                return y;
            } else {
                return z;
            }
        }


    }

    String path = "";

    public String havingFullpath() {
        return result[0];
    }

    public String getCost() {
        System.out.print("------->" + result[1]);
        return result[1];
    }

    public String getpath() {


        return path1;
    }

    public void setPath(String p) {
        this.path1 = p;
    }


}