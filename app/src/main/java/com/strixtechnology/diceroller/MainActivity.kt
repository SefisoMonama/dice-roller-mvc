package com.strixtechnology.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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
        var currentDiceValue: Int = 0
        var rollCount: Int = 0


        /**
         * Do a random dice roll and return the result.
         */
        fun roll() {
            currentDiceValue =  (1..numSides).random()
            rollCount++;
        }

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.rollDiceButton)


        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {rollDice()}





    }

    // Create new Dice object with 6 sides and roll it
    var dice = Dice(6)
    var dice2 = Dice(6)

    private fun rollDice() {
        dice.roll()
        dice2.roll()
        setViewContents()
    }

    fun setViewContents(){

        // Update the screen with the dice roll
        var diceImageView: ImageView = findViewById(R.id.diceImage)
        var secondDiceImageView: ImageView = findViewById(R.id.secondDiceImage)
        var sumValueView: TextView = findViewById(R.id.sumValue);
        var rollCountView: TextView = findViewById(R.id.numberAppearanceValue);
        var doubleNumberView: TextView=findViewById(R.id.sameNumber)

        diceImageView.setImageResource(dice.getDiceImageResource())
        secondDiceImageView.setImageResource(dice2.getDiceImageResource())
        sumValueView.text = "sum of Dices: ${dice.currentDiceValue + dice2.currentDiceValue}"
        rollCountView.text = "You have rolled ${dice.rollCount} time/s"

        //Compare 2 Values on the dices to see if their the same
        if(dice.currentDiceValue==dice2.currentDiceValue)
        {
            doubleNumberView.text= "Woohoo! you've rolled double numbers"
        }
        else{
            doubleNumberView.text= " "
        }


    }

    /**
     * Dice with a fixed number of sides.
     */
    class Dice(private val numSides: Int) {
        //Declare and Initialize dice variables
        var currentDiceValue: Int = 0
        var rollCount: Int = 0


        /**
         * Do a random dice roll and return the result.
         */
        fun roll() {
            currentDiceValue =  (1..numSides).random()
            rollCount++;
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



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("current", dice.currentDiceValue)
        outState.putInt("current2", dice2.currentDiceValue)
       outState.putInt("count", dice.rollCount)



    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getInt("current")
        savedInstanceState.getInt("current2")
        savedInstanceState.getInt("count")
    }
}
