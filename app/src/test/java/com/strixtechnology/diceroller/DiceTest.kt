package com.strixtechnology.diceroller

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

class DiceTest : TestCase() {

    /**
     * Use this variable to test that the Dice
     * functions as you expect it to.
     */
    var dice = Dice(DICE_SIDE_COUNT)
    var rolls = Dice(NUM_DICE_ROLL)

    @Test
    fun testDiceCounterIncrementing() {
        /**
         * Write code here which rolls the dice a number of times
         * and then confirm that the value for dice.rollCount is correct
         *
         * AssertEquals compares two values to see if they are the same
         */
        val excpectedValue = 10

        //TODO: write code here which rolls the dice 10 times
        for (i in 1..NUM_DICE_ROLL) {
            dice.roll();
        }

        val actualValue = dice.rollCount

        Assert.assertEquals(excpectedValue, actualValue)
    }

    @Test
    fun testCorrectDrawableLoadsIfDiceRollsSix() {
        /**
         * Write code here which sets the dice to a known value
         * and then confirm that correct Image Resource is returned
         * by the function getDiceImageResource()
         *
         * AssertEquals compares two values to see if they are the same
         */

        val excpectedValue = R.drawable.dice_6

        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  DICE_SIDE_COUNT

        val actualValue = dice.getDiceImageResource()

        Assert.assertEquals(excpectedValue, actualValue)
    }
}