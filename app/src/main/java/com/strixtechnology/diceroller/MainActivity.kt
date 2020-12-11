package com.strixtechnology.diceroller



import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//Declare constant Variables
const val CURRENT_DICE_VALUE_KEY = "current";
const val COUNT_VALUE_KEY = "count";

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
        rollButton.setOnClickListener {rollDice()}
    }

    // Create new Dice object with 6 sides and roll it
    var dice = Dice(6)
    var dice2 = Dice(6)
    //when dice is rolled view will be populated with setViewContent content
    private fun rollDice() {
        dice.roll()
        dice2.roll()
        setViewContents()
    }
    // Add contect to View
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
    //restore any view state that has been frozen or killed
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CURRENT_DICE_VALUE_KEY, dice.currentDiceValue)
        outState.putInt(CURRENT_DICE_VALUE_KEY, dice2.currentDiceValue)
        outState.putInt(COUNT_VALUE_KEY, dice.rollCount)
    }
    //state of the data will be restored
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        dice.currentDiceValue= savedInstanceState.getInt(CURRENT_DICE_VALUE_KEY)
        dice2.currentDiceValue= savedInstanceState.getInt(CURRENT_DICE_VALUE_KEY)
        dice.rollCount= savedInstanceState.getInt(COUNT_VALUE_KEY)
        setViewContents()
    }
}
