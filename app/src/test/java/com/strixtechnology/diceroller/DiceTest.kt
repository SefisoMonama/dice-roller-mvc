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
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  DICE_SIDE_COUNT
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsFive() {
        val expectedValue = R.drawable.dice_6
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  DICE_SIDE_COUNT
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsFour() {
        val expectedValue = R.drawable.dice_6
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  DICE_SIDE_COUNT
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsThree() {
        val expectedValue = R.drawable.dice_6
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  DICE_SIDE_COUNT
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsTwo() {
        val expectedValue = R.drawable.dice_6
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  DICE_SIDE_COUNT
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsOne() {
        val expectedValue = R.drawable.dice_6
        //TODO: write code here which sets the dice value to 6
        dice.currentDiceValue =  DICE_SIDE_COUNT
        val actualValue = dice.getDiceImageResource()
        Assert.assertEquals(expectedValue, actualValue)
    }
}