package com.example.androidphotoninfotechtdd.businesslogic;


public class MatrixCreation {
    static int size_row, size_column;
    int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] m) {
        this.matrix = m;
    }

    public String[] result = new String[3];


    public void sizeOfMatrix(int m, int n) {
        size_row = m;
        size_column = n;
        matrix = new int[m][n];

    }
    //Setting elements in matrix and finding valid matrix or not
    public String setEelementsInMatrix(String[] x) {
        if (size_column * size_row == x.length && x.length != 0) {
            int in_posi = 0;
            for (int i = 0; i < size_row; i++) {
                for (int j = 0; j < size_column; j++) {
                    try {

                        matrix[i][j] = Integer.parseInt(x[in_posi]);
                        if (matrix[i][j] < 0) {
                            throw new Exception();
                        }

                    } catch (NumberFormatException e) {

                        return "Invalid Matrix";
                    } catch (Exception e) {
                        return "Invalid Matrix";
                    }

                    ++in_posi;

                }
            }
            setMatrix(matrix);
        } else {
            return "Invalid Matrix";

        }

        return "good";
    }


}
