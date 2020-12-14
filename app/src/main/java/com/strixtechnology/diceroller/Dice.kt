package com.strixtechnology.diceroller
/**
 * Dice with a fixed number of sides.
 */

class Dice(private val numSides: Int) {
    //Declare and Initialize dice variables
    var currentDiceValue: Int = 0
    private set

    var rollCount: Int = 0
    private set
    
    /**
     * Do a random dice roll and return the result.
     */
    fun roll() {
        currentDiceValue =  (1..numSides).random()
        rollCount++;
    }
    /**
     * Store Image Resources
     */
    fun getDiceImageResource(): Int {
        return when (currentDiceValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else ->  R.drawable.dice_1
        }
    }
}