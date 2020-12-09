package com.strixtechnology.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.rollDiceButton)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice() }
    }

    // Create new Dice object with 6 sides and roll it
    var dice = Dice(6)

    private fun rollDice() {
        dice.roll()

        // Update the screen with the dice roll
        var diceImageView: ImageView = findViewById(R.id.diceImage)
        var currentValueTextView: TextView = findViewById(R.id.numberRolled);
        var streakTextView: TextView = findViewById(R.id.numberAppearanceValue);

        diceImageView.setImageResource(dice.getDiceImageResource())
        currentValueTextView.text = "You have rolled a ${dice.currentDiceValue}"
        streakTextView.text = "You have rolled a ${dice.currentDiceValue} : ${dice.sameRollValueStreak} times"
    }

    /**
     * Dice with a fixed number of sides.
     */
    class Dice(private val numSides: Int) {
        //Declare and Initialize dice variables
        var currentDiceValue: Int = 0
        var previousDiceValue: Int = 0
        var rollCount: Int = 0
        //Initialize streak Value to 1, it counts for the first time it appears
        var sameRollValueStreak: Int = 1


        /**
         * Do a random dice roll and return the result.
         */
        fun roll() {
            rollCount++
            //current value will be stored in previous Value as you roll the dice
            previousDiceValue = currentDiceValue
            currentDiceValue =  (1..numSides).random()

            //if previous value is equal the current, samerollValue will increment by 1 else it will be reset to 1;
            if (previousDiceValue == currentDiceValue){
                sameRollValueStreak++
            }else{
                sameRollValueStreak = 1
            }
        }

        //Stores Image Resources
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
}
