package com.strixtechnology.diceroller



import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

//Declare constant Variables
const val CURRENT_DICE_VALUE_KEY = "current"
const val CURRENT_DICE2_VALUE_KEY = "current2"
const val COUNT_VALUE_KEY = "count"
const val DICE_SIDE_COUNT = 8
const val DOUBLE_DICES = 2
const val SINGLE_DICE =1


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
        var rollDoubleDiceButton: Button = findViewById(R.id.roll2Dices)
        var rollSingleDiceButton: Button = findViewById(R.id.roll1Dice)
        var sixSidesButton: Button = findViewById(R.id.sixSides)
        var eightSidesButton: Button = findViewById(R.id.eightSides)
        //find View in the layout
        var numberOfDiceToRollView: TextView=findViewById(R.id.numberOfDiceToRoll)

        //Prompt the user to choose number of dice/s to roll
        numberOfDiceToRollView.text = "Select the Number of dice/s to roll"

        // Set a click listener on the button to roll the dice when the user taps the button
        rollSingleDiceButton.setOnClickListener{rollSingleDices()}
        rollDoubleDiceButton.setOnClickListener{rollDoubleDices()}
    }
    /**
     * when dice is rolled view will be populated with setViewContent content
     */
    private fun rollDoubleDices() {
        dice.roll()
        dice2.roll()
        setViewContentsFor2Dices()
    }
    private fun rollSingleDices() {
        dice.roll()
        dice2.roll()
        setViewContentsFor1Dice()
    }
    /**
     * Add content to your Views
     *
     *
     */
    fun setViewContentsFor2Dices(){
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

    fun setViewContentsFor1Dice() {
        var diceImageView: ImageView = findViewById(R.id.diceImage)
        var secondDiceImageView: ImageView = findViewById(R.id.secondDiceImage)
        var numRolledView: TextView = findViewById(R.id.sumValue);
        var rollCountView: TextView = findViewById(R.id.numberAppearanceValue);
        //var doubleNumberView: TextView=findViewById(R.id.sameNumber)


        //diceImageView.setImageResource(dice.getDiceImageResource())
        secondDiceImageView.setImageResource(dice2.getDiceImageResource())
        numRolledView.text = "You have rolled: ${dice2.currentDiceValue}"
        rollCountView.text = "You have rolled ${dice.rollCount} time/s"

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
        setViewContentsFor2Dices()
    }
}
