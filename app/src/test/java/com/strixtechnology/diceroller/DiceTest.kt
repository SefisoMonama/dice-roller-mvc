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
        val expectedValue = R.drawable.dice_6
        val side_6: Int=6
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue = side_6
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsFive() {
        val expectedValue = R.drawable.dice_5
        val side_5: Int=5
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue = side_5
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsFour() {
        val expectedValue = R.drawable.dice_4
        val side_4: Int=4
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  side_4
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsThree() {
        val expectedValue = R.drawable.dice_3
        val side_3: Int=3
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  side_3
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsTwo() {
        val expectedValue = R.drawable.dice_2
        val side_2: Int=2
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  side_2
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsOne() {
        val expectedValue = R.drawable.dice_1
        val side_1: Int=1
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  side_1
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
}