package com.strixtechnology.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        var diceImage: ImageView = findViewById(R.id.imageView)
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)


        }
        var count=0;
        var theTextView: TextView = findViewById(R.id.textView2);
        var textViewThree: TextView = findViewById(R.id.textView3);
        when(diceRoll)
        {
            1 -> theTextView.setText("You have rolled a 1")
            2 -> theTextView.setText("You have rolled a 2")
            3 -> theTextView.setText("You have rolled a 3")
            4 -> theTextView.setText("You have rolled a 4")
            5 -> theTextView.setText("You have rolled a 5")
            6 -> theTextView.setText("You have rolled a 6")
        }

            if (diceRoll==1){
                textViewThree.setText("you have displayed ${diceRoll}: ${count++} times")
            }
            else if(diceRoll==2){
                textViewThree.setText("you have displayed ${diceRoll}: ${count++} times")
            }
            else if(diceRoll==3){
                textViewThree.setText("you have displayed ${diceRoll}: ${count++} times")
            }
            else if(diceRoll==4){
                textViewThree.setText("you have displayed ${diceRoll}: ${count++} times")
            }
            else if(diceRoll==5){
                textViewThree.setText("you have displayed ${diceRoll}: ${count++} times")
            }
            else if(diceRoll==6){
                textViewThree.setText("you have displayed ${diceRoll}: ${count++} times")
            }
    }
}

/**
 * Dice with a fixed number of sides.
 */
class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}
