package com.example.androidphotoninfotechtdd;


import com.example.androidphotoninfotechtdd.businesslogic.MatrixCreation;
import com.example.androidphotoninfotechtdd.businesslogic.ShortestPathCost;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTestTDD {
    ShortestPathCost cost;
    MatrixCreation matrixCreation;

    @Before
    public void initialization() {
        cost = new ShortestPathCost();
        matrixCreation = new MatrixCreation();
    }

    //1 -- Getting 3 values in the beside column to find the shortest path

    @Test
    public void getting3Values() {

        matrixCreation.sizeOfMatrix(5, 6);
        String[] x = {
                "3", "4", "1", "2", "8", "6",
                "6", "1", "8", "2", "7", "4",
                "5", "9", "3", "9", "9", "5",
                "8", "4", "1", "3", "2", "6",
                "3", "7", "2", "8", "6", "4"
        };

        int[][] m;
        try {


            cost.path_weight(matrixCreation.getMatrix());
            cost.findShortPath(matrixCreation.getMatrix(),0, 4, 6);
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {
        }

        //Expected positions of elements: 0 4 1 with values, 6 4 4
    }

    //2 -- Finding minimum value among 3 values
    @Test
    public void findSmallElementTest() {
        matrixCreation.sizeOfMatrix(5, 6);
        String[] x = {
                "3", "4", "1", "2", "8", "6",
                "6", "1", "8", "2", "7", "4",
                "5", "9", "3", "9", "9", "5",
                "8", "4", "1", "3", "2", "6",
                "3", "7", "2", "8", "6", "4"
        };

        try {
            matrixCreation.setEelementsInMatrix(x);

        } catch (Exception e) {
        }
        int minimum = cost.findSmallElement(2, 1, 7);
        assertEquals(1, minimum);
    }

    //3 .. finding Lowest Cost Path

    @Test
    public void ShortestPathCostTest() {

        matrixCreation.sizeOfMatrix(5, 6);
        String[] x = {
                "3", "4", "1", "2", "8", "6",
                "6", "1", "8", "2", "7", "4",
                "5", "9", "3", "9", "9", "5",
                "8", "4", "1", "3", "2", "6",
                "3", "7", "2", "8", "6", "4"
        };

        try {
            matrixCreation.setEelementsInMatrix(x);
            cost.path_weight(matrixCreation.getMatrix());

        } catch (Exception e) {
        }
        assertEquals("Yes", cost.havingFullpath());
        assertEquals("16", cost.getCost());
    }

    //4. Change in Requirement -- Testcase for avoiding Alphabets

    @Test
    public void alphabetsTest() {

        matrixCreation.sizeOfMatrix(3, 3);
        String[] x = {"5", "4", "H",
                "8", "M", "7",
                "5", "7", "5"};

        try {
            assertEquals("Invalid Matrix", matrixCreation.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {
        }
    }

    //4. Change in Requirement -- Testcase for avoiding Negative elements

    @Test
    public void negativeElementsTest() {

        matrixCreation.sizeOfMatrix(3, 3);
        String[] x = {"5", "4", "-2",
                "8", "-13", "7",
                "5", "7", "5"};

        try {
            assertEquals("Invalid Matrix", matrixCreation.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {

        }
    }

    //testing for requirements of Short path cost must be less than 50
    @Test
    public void testForCheckingTotalCostLessThan50InCompletePath() {

        matrixCreation.sizeOfMatrix(3, 5);
        String[] x = {"19", "10", "19", "10", "19",
                "21", "23", "20", "19", "12",
                "20", "12", "20", "11", "10"};

        try {
            assertEquals("good", matrixCreation.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {
        }
        cost.path_weight(matrixCreation.getMatrix());
        // having full path
        assertEquals("No", cost.havingFullpath());
        // cost
        assertEquals("49", cost.getCost());

    }

    //test case to find shortest cost path in the matrix
    @Test
    public void shortestPathTest() {
        matrixCreation.sizeOfMatrix(5, 6);
        String[] x = {"3", "4", "1", "2", "8", "6",
                "6", "1", "8", "2", "7", "4",
                "5", "9", "3", "9", "9", "5",
                "8", "4", "1", "3", "2", "6",
                "3", "7", "2", "1", "2", "3"};

        try {
            matrixCreation.setEelementsInMatrix(x);
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }
        cost.path_weight(matrixCreation.getMatrix());
        // having full path
        assertEquals("Yes", cost.havingFullpath());
        // cost
        assertEquals("11", cost.getCost());
        // path
        assertEquals("121545", cost.getpath());

    }


}
