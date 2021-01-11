package com.strixtechnology.diceroller



import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup

//Declare constant Variables
const val CURRENT_DICE_VALUE_KEY = "current"
const val CURRENT_DICE2_VALUE_KEY = "current2"
const val COUNT_VALUE_KEY = "count"
const val DICE_SIDE_COUNT_6 = 6
const val DICE_SIDE_COUNT_8 = 8

class MainActivity : AppCompatActivity() {

    /**
     * Create new Dice object with 6 and 8 sides and roll it
     */
    var dice = Dice(DICE_SIDE_COUNT_6)
    var dice2 = Dice(DICE_SIDE_COUNT_6)
    var dice3 = Dice(DICE_SIDE_COUNT_8)
    var dice4 = Dice(DICE_SIDE_COUNT_8)

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find View in the layout
        var numberOfDiceToRollView: TextView=findViewById(R.id.numberOfDiceToRoll)

        //find Button in the layout
        var rollDiceButton: Button = findViewById(R.id.rollDice)

        //Prompt the user to choose number of dice/s to roll
        numberOfDiceToRollView.text = "Select the Number of dice/s to roll"

        //Find chip in the layout
        var sixSidesChip: Chip = findViewById(R.id.sixSides)
        var eightSidesChip: Chip = findViewById(R.id.eightSides)
        var roll1DiceChip: Chip = findViewById(R.id.roll1Dice)
        var roll2DiceChip: Chip = findViewById(R.id.roll2Dices)
        var chooseDiceSidesChip: ChipGroup  =findViewById(R.id.chooseDiceSides)
        var numberOfDiceToRollChip: ChipGroup = findViewById(R.id.numberOfDice)


        if(sixSidesChip.isChecked()){
            if(roll1DiceChip.isChecked()){
                rollDiceButton.setOnClickListener{rollSingleDicesWith6Sides()}
            }else if(roll2DiceChip.isChecked()){
                rollDiceButton.setOnClickListener{rollDoubleDicesWith6Sides()}
            }
        }

        if(eightSidesChip.isChecked()){
            if(roll1DiceChip.isChecked()){
                rollDiceButton.setOnClickListener{rollSingleDicesWith8Sides()}
            }else if(roll2DiceChip.isChecked()){
                rollDiceButton.setOnClickListener{rollDoubleDicesWith8Sides()}
            }
        }
    }
    /**
     * when dice is rolled view will be populated with setViewContent content
     */
    private fun rollDoubleDicesWith6Sides() {
        dice.roll()
        dice2.roll()
        setViewContentsFor2DicesWith6Sides()
    }
    private fun rollSingleDicesWith6Sides() {
        dice2.roll()
        setViewContentsFor1DiceWith6Sides()
    }

    private fun rollDoubleDicesWith8Sides() {
        dice3.roll()
        dice4.roll()
        setViewContentsFor2DicesWith8Sides()
    }
    private fun rollSingleDicesWith8Sides() {
        dice4.roll()
        setViewContentsFor1DiceWith8Sides()
    }
     /**
     * add content to View, to display 2 dices with 8 sides
    */
    fun setViewContentsFor2DicesWith8Sides(){
        var diceImageView: ImageView = findViewById(R.id.diceImage)
        var secondDiceImageView: ImageView = findViewById(R.id.secondDiceImage)
        var sumValueView: TextView = findViewById(R.id.sumValue);
        var rollCountView: TextView = findViewById(R.id.timesYouRolled);
        var doubleNumberView: TextView=findViewById(R.id.sameNumber)


        diceImageView.setImageResource(dice3.getDiceImageResourceFor8Sides())
        secondDiceImageView.setImageResource(dice4.getDiceImageResourceFor8Sides())
        sumValueView.text = "sum of Dices: ${dice3.currentDiceValue + dice4.currentDiceValue}"
        rollCountView.text = "You have rolled ${dice3.rollCount} time/s"


        //Compare both dices value to see if they displayed the same values
        if(dice3.currentDiceValue==dice4.currentDiceValue) {
            doubleNumberView.text= "Woohoo! you've rolled double numbers"
        }
        else{
            doubleNumberView.text= " "
        }
    }
    /**
     * add content to View, to display 1 dice with 8 sides
     */
    fun setViewContentsFor1DiceWith8Sides() {
        var diceImageView: ImageView = findViewById(R.id.diceImage)
        var secondDiceImageView: ImageView = findViewById(R.id.secondDiceImage)
        var numRolledView: TextView = findViewById(R.id.sumValue);
        var rollCountView: TextView = findViewById(R.id.timesYouRolled);

        secondDiceImageView.setImageResource(dice4.getDiceImageResourceFor8Sides())
        numRolledView.text = "You have rolled: ${dice4.currentDiceValue}"
        rollCountView.text = "You have rolled ${dice3.rollCount} time/s"

    }
    /**
     * add content to View, to display 2 dices with 6 sides
     */
    fun setViewContentsFor2DicesWith6Sides(){
        var diceImageView: ImageView = findViewById(R.id.diceImage)
        var secondDiceImageView: ImageView = findViewById(R.id.secondDiceImage)
        var sumValueView: TextView = findViewById(R.id.sumValue);
        var rollCountView: TextView = findViewById(R.id.timesYouRolled);
        var doubleNumberView: TextView=findViewById(R.id.sameNumber)

        diceImageView.setImageResource(dice.getDiceImageResourceFor6Sides())
        secondDiceImageView.setImageResource(dice2.getDiceImageResourceFor6Sides())
        sumValueView.text = "sum of Dices: ${dice.currentDiceValue + dice2.currentDiceValue}"
        rollCountView.text = "You have rolled ${dice2.rollCount} time/s"


        //Compare both dices value to see if they displayed the same values
        if(dice.currentDiceValue==dice2.currentDiceValue) {
            doubleNumberView.text= "Woohoo! you've rolled double numbers"
        }
        else{
            doubleNumberView.text= " "
        }
    }
    /**
     * add content to View, to display 1 dice with 6 sides
     */
    fun setViewContentsFor1DiceWith6Sides() {
        var diceImageView: ImageView = findViewById(R.id.diceImage)
        var secondDiceImageView: ImageView = findViewById(R.id.secondDiceImage)
        var numRolledView: TextView = findViewById(R.id.sumValue);
        var rollCountView: TextView = findViewById(R.id.timesYouRolled);

        secondDiceImageView.setImageResource(dice2.getDiceImageResourceFor6Sides())
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
        //setViewContentsFor2Dices()
    }
}
