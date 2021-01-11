package com.strixtechnology.diceroller

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

class DiceTest : TestCase() {

    var dice = Dice(DICE_SIDE_COUNT_6)
    val NUM_DICE_ROLL = 10;


    /**
     * Test if rollCount is incremented when roll() fun is called
     */
    @Test
    fun testDiceCounterIncrementing() {
        val expectedValue = 10
        for (i in 1..NUM_DICE_ROLL) {
            dice.roll();
        }
        val actualValue = dice.rollCount
        Assert.assertEquals(expectedValue, actualValue)
    }

    /**
     * Test if image dice_1..8 will be displayed if current Value is 1..6
     */
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsSix() {
        val expectedValue = R.drawable.dice_6
        val side6: Int=6
        dice.currentDiceValue = side6
        val actualValue = dice.getDiceImageResourceFor6Sides()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsFive() {
        val expectedValue = R.drawable.dice_5
        val side5: Int=5
        dice.currentDiceValue = side5
        val actualValue = dice.getDiceImageResourceFor6Sides()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsFour() {
        val expectedValue = R.drawable.dice_4
        val side4: Int=4
        dice.currentDiceValue =  side4
        val actualValue = dice.getDiceImageResourceFor6Sides()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsThree() {
        val expectedValue = R.drawable.dice_3
        val side3: Int=3
        dice.currentDiceValue =  side3
        val actualValue = dice.getDiceImageResourceFor6Sides()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsTwo() {
        val expectedValue = R.drawable.dice_2
        val side2: Int=2
        dice.currentDiceValue =  side2
        val actualValue = dice.getDiceImageResourceFor6Sides()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testCorrectDrawableLoadsIfDiceRollsOne() {
        val expectedValue = R.drawable.dice_1
        val side1: Int=1
        dice.currentDiceValue =  side1
        val actualValue = dice.getDiceImageResourceFor6Sides()
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testForRoll2Dice(){
        val twoDice: Int= 2
        val expectedValue:Int = twoDice
        val actualValue = R.id.roll2Dices
        Assert.assertEquals(expectedValue, actualValue)
    }
    @Test
    fun testForRoll1Dice(){
        val oneDice: Int = 1
        val expectedValue:Int = oneDice
        val actualValue: Int = R.id.roll1Dice
        Assert.assertEquals(expectedValue, actualValue)
    }

}