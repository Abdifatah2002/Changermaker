/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Changermaker
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
 * This class simulate a cash register dispensing change to a customer, where the goal is to find
 * a combination of coins of different denominations that add up to a given amount, using the
 * minimal total amount of coins, and where we have a limited supply of each denomination.
 * It contains three public static methods: count(), miniCoins() and makeChange(). Each of
 * the three methods in this class will solve a variant of the change-making problem.
 */
public class Changemaker {
    // Method 1: count

    /**
     * This method determine the number of possible way to make change
     * @param denominations  - array describes the value of each of type of coin in your register
     * @param coinsRemaining - array describes the quantity of each type of coin
     * @param value -parameter describes the  total amount of change to be dispensed to the customer
     * @return- the number of ways to make change for the given value
     */
    public static int count(int[] denominations, int[] coinsRemaining, int value) {
        int totalCount = 0;

        // Base case: If targetValue is 0, there is one combination (using no coins)
        if (value == 0) {
            return 1;
        }

        // Base case: If targetValue is less than 0, there are no valid combinations
        if (value < 0) {
            return 0;
        }

        // Recursive case: Iterate through each denomination
        for (int i = 0; i < denominations.length; i++) {
            if (value >= denominations[i] && coinsRemaining[i] > 0) {
                int updatedValue = value- denominations[i];
                totalCount += count(denominations, useCoin(coinsRemaining, i), updatedValue);
            }
        }
        return totalCount;
    }

    private static int[] useCoin(int[] coinsRemaining, int index) {
        // Create a copy of the coinsRemaining array
        int[] updatedCoinsRemaining = Arrays.copyOf(coinsRemaining, coinsRemaining.length);

        // Decrement the count of the selected coin
        updatedCoinsRemaining[index]--;

        return updatedCoinsRemaining;
    }





//method 2

    /**
     * This method  get the minimum total number of coins needed to make change for the
     * given value using a limited number of coins of various denominations as described
     * @param denominations  - array describes the value of each of type of coin in your register
     * @param coinsRemaining - array describes the quantity of each type of coin
     * @param value-parameter describes the  total amount of change to be dispensed to the customer
     * @return -return the minimum total number of coins needed to make change for the given value
     * using a limited number of coins
     */

    public static int minCoins(int[] denominations, int[] coinsRemaining, int value) {
        // Call the recursive helper method
        int result = minCoinsHelper(denominations, coinsRemaining, value, 0);
        // If the result is equal to Integer.MAX_VALUE, it means there's no solution; return -1
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     *  This is a Recursive helper method
     * @param denominations
     * @param denominations  - array describes the value of each of type of coin in your register
     * @param coinsRemaining - array describes the quantity of each type of coin
     * @param value-parameter describes the  total amount of change to be dispensed to the customer
     * @param index- the index of array
     * @return -minCoins - number of coins found
     */
    private static int minCoinsHelper(int[] denominations,int[] coinsRemaining,int value,int index){
        if (value == 0) {
            return 0; // Return 0 for the base case
        }
        // If the value is negative return Integer.MAX_VALUE
        if (index >= denominations.length || value < 0) {
            return Integer.MAX_VALUE;
        }

        // Initialize minCoins to the maximum integer value
        int minCoins = Integer.MAX_VALUE;

        // Loop through the possible number we can use the current denomination
        for (int i = 0; i <= coinsRemaining[index]; i++) {

            // Create a copy of the coinsRemaining array and update it by subtracting the number
            //of coins used in the current iteration
            int[] updatedCoinsRemaining = Arrays.copyOf(coinsRemaining, coinsRemaining.length);
            updatedCoinsRemaining[index] -= i;

            // Recursively call the helper method for the remaining value (subtracting the value of
            //the used coins) and the next denomination
            int coins = minCoinsHelper(denominations, updatedCoinsRemaining,
                    value - i * denominations[index], index + 1);

            // If the result is not equal to Integer.MAX_VALUE, update minCoins with the
            //minimum value between minCoins and coins used so far
            if (coins != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, coins + i);
            }
        }
        // Return the min number of coins found
        return minCoins;
    }


    // method 3

    /**
     * This method computes an array representing the exact number of each type of coin needed
     * to make change optimally that dispense to customer
     * @param denominations  - array describes the value of each type of coin in your register
     * @param coinsRemaining -array describes the quantity of each type of coin in your register
     * @param value -  parameter describes the total amount of change to be dispensed to customer
     * @return - the array representing the exact number of each type
     */
    public static int[] makeChange(int[] denominations, int[] coinsRemaining, int value) {
        // Check for invalid inputs
        if (value < 0 || denominations == null || coinsRemaining == null
                || denominations.length != coinsRemaining.length) {
            return null;
        }

        // Initialize the result array
        int[] result = new int[denominations.length];

        // If the helper method returns true, then a solution exists, so return the result array
        if (makeChangeHelper(denominations, coinsRemaining, value, 0, result)) {
            return result;
        } else {
            // If the helper method returns false, there is no solution, so return null
            return null;
        }
    }

    /**
     *  This is a makeChange helper method
     * @param denominations  - array describes the value of each type of coin in your register
     * @param coinsRemaining -array describes the quantity of each type of coin in your register
     * @param value -  parameter describes the total amount of change to be dispensed to customer
     * @param index  - the index of array
     * @param result - array describes that the makeChange get
     * @return- if the value is 0 or it implements recursively, return true;
     * If the value is negative or we have reached the end of the denominations array, return false;
     */
    private static boolean makeChangeHelper(int[] denominations, int[] coinsRemaining,
                                            int value, int index, int[] result) {
        // If the value is 0, a solution has been found
        if (value == 0) {
            return true;
        }

        // If the value is negative or we have reached the end of the denominations array,
        //there is no solution
        if (value < 0 || index >= denominations.length) {
            return false;
        }

        // Iterate through the possible number of coins for the current denomination
        for (int i = 0; i <= coinsRemaining[index]; i++) {
            //  a copy of the coinsRemaining array to pass to the recursive call
            int[] updatedCoinsRemaining = Arrays.copyOf(coinsRemaining, coinsRemaining.length);
            // Decrease the number of remaining coins for the current denomination
            updatedCoinsRemaining[index] -= i;

            // Recursively call the helper method with the updated value
            //and updated coins remaining array
            if (makeChangeHelper(denominations, updatedCoinsRemaining,
                    value - (i * denominations[index]), index + 1, result)) {
                // If the recursive call returns true, we have found a solution,
                //so update the result array and return true
                result[index] = i;
                return true;
            }
        }

        // If no solution is found for any combination of coins, return false
        return false;
    }
}








