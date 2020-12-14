package com.strixtechnology.diceroller

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

class DiceTest : TestCase() {

    var dice = Dice(DICE_SIDE_COUNT)
    val NUM_DICE_ROLL = 10;

    @Test
    fun testDiceCounterIncrementing() {
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

        val expectedValue = R.drawable.dice_6
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
        Assert.assertEquals(expectedValue, actualValue)
    }
}