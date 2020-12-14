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

    @Test
    fun testDiceCounterIncrementing() {
        /**
         * Write code here to which rolls the dice a number of times
         * and then confirm that the value for dice.rollCount is correct
         *
         * Tip: Use assertEquals(expectedValue, actualValue) - Read up
         * on Kotlin Unit testing if needed
         */
    }

    @Test
    fun testImageResourceLoading() {
        /**
         * Write code here to which sets the dice value to known values
         * and then confirm that correct Image Resource is returned
         * by the function getDiceImageResource()
         *
         * Tip: Use assertEquals(expectedValue, actualValue) - Read up
         * on Kotlin Unit testing if needed
         */
    }
}