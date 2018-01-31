package com.example.androidphotoninfotechtdd;


import com.example.androidphotoninfotechtdd.businesslogic.ShortestPathCost;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTestTDD {
    ShortestPathCost cost;

    @Before
    public void initialization() {
        cost = new ShortestPathCost();
    }

    //1 -- Getting 3 values in the beside column to find the shortest path

    @Test
    public void getting3Values() {

        cost.sizeOfMatrix(5, 6);
        String[] x = {
                "3", "4", "1", "2", "8", "6",
                "6", "1", "8", "2", "7", "4",
                "5", "9", "3", "9", "9", "5",
                "8", "4", "1", "3", "2", "6",
                "3", "7", "2", "8", "6", "4"
        };

        try {

            cost.setEelementsInMatrix(x);

        } catch (Exception e) {


        }

        cost.findShortPath(0, 4, 6);

//Expected positions of elements: 0 4 1 with values, 6 4 4
    }

    //2 -- Finding minimum value among 3 values
    @Test
    public void findSmallElementTest() {
        cost.sizeOfMatrix(5, 6);
        String[] x = {
                "3", "4", "1", "2", "8", "6",
                "6", "1", "8", "2", "7", "4",
                "5", "9", "3", "9", "9", "5",
                "8", "4", "1", "3", "2", "6",
                "3", "7", "2", "8", "6", "4"
        };

        try {

            cost.setEelementsInMatrix(x);

        } catch (Exception e) {


        }

        int minimum = cost.findSmallElement(2, 1, 7);
        assertEquals(1, minimum);
    }

    //3 .. finding Lowest Cost Path

    @Test
    public void ShortestPathCostTest() {

        cost.sizeOfMatrix(5, 6);
        String[] x = {
                "3", "4", "1", "2", "8", "6",
                "6", "1", "8", "2", "7", "4",
                "5", "9", "3", "9", "9", "5",
                "8", "4", "1", "3", "2", "6",
                "3", "7", "2", "8", "6", "4"
        };

        try {
            cost.setEelementsInMatrix(x);

        } catch (Exception e) {

        }
        cost.path_weight();
        assertEquals("Yes", cost.havingFullpath());
        assertEquals("16", cost.getCost());


    }

    //4. Change in Requirement -- Testing for Alphabets in place of numbers

    @Test
    public void alphabetsTest() {

        cost.sizeOfMatrix(3, 3);
        String[] x = {"5", "4", "H",
                "8", "M", "7",
                "5", "7", "5"};

        try {
            assertEquals("Invalid Matrix", cost.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }
    }

    @Test
    public void testForCheckingTotalCostLessThan50InCompletePath() {

        cost.sizeOfMatrix(3, 5);
        String[] x = {"19", "10", "19", "10", "19",
                "21", "23", "20", "19", "12",
                "20", "12", "20", "11", "10"};

        try {
            assertEquals("good", cost.setEelementsInMatrix(x));
            // fail("Should throw an exception if one or more of given numbers are negative");
        } catch (Exception e) {


        }
        cost.path_weight();
        // having full path
        assertEquals("No", cost.havingFullpath());
        // cost
        assertEquals("49", cost.getCost());

    }


}
