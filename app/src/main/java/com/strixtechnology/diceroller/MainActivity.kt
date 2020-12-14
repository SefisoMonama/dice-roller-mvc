package com.strixtechnology.diceroller



import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//Declare constant Variables
const val CURRENT_DICE_VALUE_KEY = "current";
const val CURRENT_DICE2_VALUE_KEY = "current2";
const val COUNT_VALUE_KEY = "count";
const val DICE_SIDE_COUNT = 6;
const val NUM_DICE_ROLL = 10;

class MainActivity : AppCompatActivity() {

    /**
     * Create new Dice object with 6 sides and roll it
     */
    var dice = Dice(DICE_SIDE_COUNT)
    var dice2 = Dice(DICE_SIDE_COUNT)

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.rollDiceButton)


        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {rollDice()}
    }



    /**
     * when dice is rolled view will be populated with setViewContent content
     */
    private fun rollDice() {
        dice.roll()
        dice2.roll()
        setViewContents()
    }
    /**
     * Add content to your Views
     */
    fun setViewContents(){
        var diceImageView: ImageView = findViewById(R.id.diceImage)
        var secondDiceImageView: ImageView = findViewById(R.id.secondDiceImage)
        var sumValueView: TextView = findViewById(R.id.sumValue);
        var rollCountView: TextView = findViewById(R.id.numberAppearanceValue);
        var doubleNumberView: TextView=findViewById(R.id.sameNumber)

        diceImageView.setImageResource(dice.getDiceImageResource())
        secondDiceImageView.setImageResource(dice2.getDiceImageResource())
        sumValueView.text = "sum of Dices: ${dice.currentDiceValue + dice2.currentDiceValue}"
        rollCountView.text = "You have rolled ${dice.rollCount} time/s"

        //Compare both dices value to see if they displayed the same values
        if(dice.currentDiceValue==dice2.currentDiceValue) {
            doubleNumberView.text= "Woohoo! you've rolled double numbers"
        }
        else{
            doubleNumberView.text= " "
        }
    }

    /**
    *Store/Restore values (dices and rollCount) when the app gets onStop() or onDestroy()
    */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CURRENT_DICE_VALUE_KEY, dice.currentDiceValue)
        outState.putInt(CURRENT_DICE2_VALUE_KEY, dice2.currentDiceValue)
        outState.putInt(COUNT_VALUE_KEY, dice.rollCount)
    }
    /**
     * Restore dice State(dice values and rollCount) and Updates UI after the screen rotation
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        dice.currentDiceValue= savedInstanceState.getInt(CURRENT_DICE_VALUE_KEY)
        dice2.currentDiceValue= savedInstanceState.getInt(CURRENT_DICE2_VALUE_KEY)
        dice.rollCount= savedInstanceState.getInt(COUNT_VALUE_KEY)
        setViewContents()
    }
}
