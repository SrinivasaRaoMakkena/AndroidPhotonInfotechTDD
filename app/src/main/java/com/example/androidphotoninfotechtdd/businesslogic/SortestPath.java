package com.example.androidphotoninfotechtdd.businesslogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;



public class SortestPath {

        static int  size_row,size_column;
        int[][] matrix;
        ArrayList<Node_info> rwo_travelsal;
       // ArrayList<Result_info> final_list;

        public String[] result=new String[3];



        public void sizeOfMatrix(int m,int n)
        {
            size_row=m;
            size_column=n;
            matrix=new int[m][n];
            //final_list=new ArrayList<Result_info>();
        }

        public String setEelementsInMatrix(String[] x)
        {if(size_column*size_row==x.length && x.length != 0)
        {
            int in_posi=0;
            for(int i=0;i<size_row;i++)
            {
                for (int j=0;j<size_column;j++)
                {
                    try
                    {

                        matrix[i][j]=Integer.parseInt(x[in_posi]);

                    }catch (NumberFormatException e)
                    {

                        return "Invalid Matrix";
                    }

                    ++in_posi;

                }
            }

        }else
        {
            return "Invalid Matrix";

        }

            return "good";
        }

        public void display_matrix()
        {
            for (int i=0; i<size_row; i++){
                for (int j =0; j<size_column; j++){
                    System.out.print(matrix[i][j]+"\t");
                }
                System.out.println("\n");
            }
        }


        public String path_weight() {
            int count = 0;
            if (size_column>1) {
                for (int colN = size_column - 2; colN >= 0; colN--) {
                    count++;
                    for (int rowN = 0; rowN < size_row; rowN++) {
                        findShortPath(rowN, colN, matrix[rowN][colN]);

                    }
                    int shortCostUptoThatColn = findSmallestOneColumn(colN);
                    System.out.println("cost minimum upto that coln " + shortCostUptoThatColn);

                    if (shortCostUptoThatColn < 50) {
                        result[1] = shortCostUptoThatColn + "";
                        result[0] = "Yes";


                    } else {
                        result[1] = findSmallestOneColumn(colN + 1) + "";
                        System.out.println("result[1] " + result[1]);
                        result[0] = "No";
                        break;
                    }
                }
            }else{
                result[1] = findSmallestOneColumn(0)+"";
                result[0] = "Yes";
            }
//            if (count == size_column-1) {
//                result[1] = findSmallestOneColumn(0);
//            }
//            result[1] = ""+ShortestPathCost;
//            System.out.println("cost minimum "+ShortestPathCost);
            return ""+result[1];
        }

    private int findSmallestOneColumn(int colum) {
        int small_val = matrix[0][colum];
        int smallest_row = 0;
        int smallest_column = colum;

        //small value in first column
        for (int i = 0; i < size_row; i++) {
            if (small_val > matrix[i][colum]) {
                small_val = matrix[i][colum];
                smallest_row = i;
                smallest_column = colum;
            }

        }
        return small_val;
    }
//
        int value=0;
        private void findShortPath(int row,int colu,int prev)
        {

            int rowToChange = row;
            int colToChange = colu;
            value=+prev;

            int x,y,z;
            if(colu<size_column-1)
            {
                colu=colu+1;
                int row_top =row-1;
                int row_dow=row+1;


                x=matrix[row][colu]; // middle_element

                if(row_top<0)
                    row_top=size_row-1;
                y=matrix[row_top][colu];// top element

                if(row_dow>size_row-1)
                    row_dow=0;


                z=matrix[row_dow][colu];// bottom element


               // String[] test=ChooseSmallestElement(row ,row_top,row_dow,colu);



                int a = row;
                int b = row_top;
                int c = row_dow;

                System.out.println("row "+row+" "+x);
                System.out.println("row-top "+row_top+" "+y);
                System.out.println("row-down "+row_dow+" "+z+"\n------------");

                int smallAmongThree = findSmallElement(x,y,z,row,row_top,row-row_dow);

                matrix[rowToChange][colToChange] +=  smallAmongThree;

                display_matrix();

                System.out.println("small "+smallAmongThree);

            }
        }

    private int findSmallElement(int x, int y, int z,int row,int rowT,int rowD) {
        if (x<y && x<z){
            return x;
        }else{
            if (y<z){
                return y;
            }else{
                return z;
            }
        }


    }


    public String havingFullpath()
	{
		return result[0];
	}
	public String getCost()
	{
		System.out.print("------->"+result[1]);
		return result[1];
	}
	public String getpath()
	{
		System.out.print("kznknzvkvzkk.s"+result[2]);
		return result[2];
	}


    }


