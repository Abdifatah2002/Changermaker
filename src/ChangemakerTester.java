
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ChangermakerTester
// Course:   CS 300 Spring 2023
//
// Author:   ABDIFATAH ABDI
// Email:    aaabdi2@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Bonnie Wang
// Partner Email:   wang2974@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;

/**
 * A class to test the functionality of the Changemaker class.
 * The ChangemakerTester class provides methods to test the three
 * main methods of the Changemaker class: count(), minCoins(), and makeChange().
 * Each method is tested using both base cases and recursive cases.
 */
public class ChangemakerTester {

    /**
     * Tests the base cases of the count() method in the Changemaker class. This test should
     * implement at least the following three scenarios for determining whether the count() method
     * behaves correctly on a base case of the problem.
     * @return true if the count() method passes the base case tests, false otherwise
     */
    public static boolean testCountBase() {
        int[] denominations = {1, 5, 10, 25};
        int[] coinsRemaining = {1, 1, 1, 1};

        int value1 = -5;// value is negative
        int expected1 = 0; // returns 0
        boolean test1 = Changemaker.count(denominations, coinsRemaining, value1) == expected1; //  the test

        int value2 = 50; // value is positive
        int expected2 = 0;//returns 0
        boolean test2 = Changemaker.count(denominations, coinsRemaining, value2) == expected2;// the test

        int value3 = 0; // when the value is 0
        int expected3 = 1;// returns 1
        boolean test3 = Changemaker.count(denominations, coinsRemaining, value3) == expected3;// the test



        return test1 && test2 && test3 ;//return true if all tests passed, otherwise return false
    }

    /**
     * Tests implement at least the following three scenarios for determining whether the count()
     * method behaves correctly on a recursive case of the problem.
     * @return true if the count() method passes all the recursive case tests, false otherwise
     */
    public static boolean testCountRecursive() {
        int[] denominations1 = {1, 5, 10, 25};//in a scenario at least three different coins
        int[] coinsRemaining1 = {1, 1, 1, 1};
        int value1 = 36;
        int expected1 = 6;//return 6
        boolean test1 = Changemaker.count(denominations1, coinsRemaining1, value1) == expected1;//the test

        int[] denominations2 = {2, 5, 7, 10};// in a scenario at least two different optimal ways to make change
        int[] coinsRemaining2 = {1, 1, 1, 1};
        int value2 = 12;
        int expected2 = 4;//return 4
        boolean test2 = Changemaker.count(denominations2, coinsRemaining2, value2) == expected2;//the test

        int[] denominations3 = {1, 5, 6, 9};//in a scenario at greedily choosing the largest coin
        int[] coinsRemaining3 = {2, 1, 1, 1};
        int value3 = 11;
        int expected3 = 5;//return 5
        boolean test3 = Changemaker.count(denominations3, coinsRemaining3, value3) == expected3;//the test

        int[] denominations4 = {1, 10, 14, 23};//in a scenario h always choosing the largest coin
        //first does not produce a result with the minimum number of coins used.
        int[] coinsRemaining4 = {24, 3, 2, 2};
        int value4 = 24;
        int expected4 = 46;//return 46
        boolean test4 = Changemaker.count(denominations4, coinsRemaining4, value4) == expected4;

        return test1 && test2 && test3 && test4;//return true if all tests passed, otherwise return false
    }




    /**
     * The test is  dedicated to testing the base case of minCoins() method
     *
     * @return true if the minCoins() method passes all the tests, false otherwise
     */
    public static boolean testMinCoinsBase() {
        int[] denominations = {1, 5, 10, 25};
        int[] coinsRemaining = {10, 10, 10, 10};

        int value1 = -5; // the value is negative
        int expected1 = -1; // expected value is -1
        boolean test1 = Changemaker.minCoins(denominations, coinsRemaining, value1) == expected1;

        int value2 = 50; // the value is positive
        int expected2 = 2; // expected value is 2 (Two 25-cent coins make 50 cents)
        boolean test2 = Changemaker.minCoins(denominations, coinsRemaining, value2) == expected2;

        int value3 = 0; // the value is 0
        int expected3 = 0; // expected value is 0 (No coins are needed for 0 cents)
        boolean test3 = Changemaker.minCoins(denominations, coinsRemaining, value3) == expected3;

        int value4 = 3; // the value is positive
        int expected4 = -1; // expected value is -1 (Two 25-cent coins make 50 cents)
        boolean test4 = Changemaker.minCoins(denominations, coinsRemaining, value2) == expected2;

        return test1 && test2 && test3 && test4;//return true if all tests passed, otherwise return false
    }


    /**
     * Tests the recursive case of the minCoins() method
     *
     * @return true if the minCoins() method passes the recursive case tests, false otherwise
     */
    public static boolean testMinCoinsRecursive() {
        int[] denominations1 = {1, 5, 10, 25};//at least three different coins must be used to make change
        int[] coinsRemaining1 = {1, 1, 1, 1};
        int value1 = 36;
        int expected1 = 3;
        boolean test1 = Changemaker.minCoins(denominations1, coinsRemaining1, value1) == expected1;

        int[] denominations2 = {2, 5, 7, 10};// in a scenario at least two different optimal ways to make change
        int[] coinsRemaining2 = {1, 1, 1, 1};
        int value2 = 12;
        int expected2 = 2;
        boolean test2 = Changemaker.minCoins(denominations2, coinsRemaining2, value2) == expected2;

        int[] denominations3 = {1, 5, 6, 9};//in a scenario h always choosing the largest coin
        //first does not produce a result with the minimum number of coins used.
        int[] coinsRemaining3 = {2, 1, 1, 1};
        int value3 = 11;
        int expected3 = 2;
        boolean test3 = Changemaker.minCoins(denominations3, coinsRemaining3, value3) == expected3;


        return test1 && test2 && test3;//return true if all tests passed, otherwise return false
    }

    /**
     *The test method is dedicated to testing the base case of the makeChange method
     * @return true if the makeChange() method passes the base case tests, false otherwise
     */
    public static boolean testMakeChangeBase() {
        int[] denominations = {1, 5, 10, 25};
        int[] coinsRemaining = {1, 1, 1, 1};

        int value1 = -5; // value is negative
        int[] expected1 = null; // returns null
        boolean test1 =
                Arrays.equals(Changemaker.makeChange(denominations, coinsRemaining, value1), expected1);

        int value2 = 50; // value is positive but there is no way to make change
        int[] expected2 = null;// returns 0
        boolean test2 =
                Arrays.equals(Changemaker.makeChange(denominations, coinsRemaining, value2), expected2);

        int value3 = 0; // value is 0
        int[] expected3 = new int[]{0, 0, 0, 0};// returns an array of all 0
        boolean test3 =
                Arrays.equals(Changemaker.makeChange(denominations, coinsRemaining, value3), expected3);

        return test1 && test2 && test3;//return true if all tests passed, otherwise return false
    }


    /**
     * The test method is dedicated to testing the recursive case of  makeChange method
     *
     * @return true if the makeChange() method passes the recursive case tests, false otherwise
     */
    public static boolean testMakeChangeRecursive() {
        int[] denominations1 = {1, 5, 10, 25};//at least three different coins must be used to make change
        int[] coinsRemaining1 = {1, 1, 1, 1};
        int value1 = 36;//return 36
        int[] result1 = Changemaker.makeChange(denominations1, coinsRemaining1, value1);
        // return an arbitrary solution among result
        boolean test1 = Arrays.equals(result1, new int[]{1, 0, 1, 1})
                || Arrays.equals(result1, new int[]{0, 1, 1, 1});

        int[] denominations2 = {2, 5, 7, 10};//at least two different ways to make change using the
        //same optimal number of coins
        int[] coinsRemaining2 = {1, 1, 1, 1};
        int value2 = 12;//return 12
        int[] result2 = Changemaker.makeChange(denominations2, coinsRemaining2, value2);
        // return an arbitrary solution among result
        boolean test2 = Arrays.equals(result2, new int[]{1, 0, 0, 1})
                || Arrays.equals(result2, new int[]{0, 1, 1, 0});

        int[] denominations3 = {1, 5, 6, 9};//always choosing the largest coin first does not
        //produce a result with the minimum number of coins used
        int[] coinsRemaining3 = {2, 1, 1, 1};
        int value3 = 11;//return 11
        int[] result3 = Changemaker.makeChange(denominations3, coinsRemaining3, value3);
        // return an arbitrary solution among result
        boolean test3 = Arrays.equals(result3, new int[]{0, 1, 1, 0});

        return test1 && test2 && test3;//return true if all tests passed, otherwise return false
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        boolean countBaseResult = testCountBase();
        boolean countRecursiveResult = testCountRecursive();
        boolean minCoinsBaseResult = testMinCoinsBase();
        boolean minCoinsRecursiveResult = testMinCoinsRecursive();
        boolean makeChangeBaseResult = testMakeChangeBase();
        boolean makeChangeRecursiveResult = testMakeChangeRecursive();

        System.out.println("Test count base cases: " + countBaseResult);
        System.out.println("Test count recursive cases: " + countRecursiveResult);
        System.out.println("Test minCoins base cases: " + minCoinsBaseResult);
        System.out.println("Test minCoins recursive cases: " + minCoinsRecursiveResult);
        System.out.println("Test makeChange base cases: " + makeChangeBaseResult);
        System.out.println("Test makeChange recursive cases: " + makeChangeRecursiveResult);
    }
}





