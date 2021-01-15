package com.strixtechnology.diceroller



import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import com.strixtechnology.diceroller.databinding.ActivityMainBinding


//Declare constant Variables
const val CURRENT_DICE_VALUE_KEY = "current"
const val CURRENT_DICE2_VALUE_KEY = "current2"
const val COUNT_VALUE_KEY = "count"
//const val DICE_SIDE_COUNT_6 = 6
const val DICE_SIDE_COUNT_8 = 8

class MainActivity : AppCompatActivity() {

    /**
     * Create new Dice object with 6 and 8 sides and roll it
     */
    var dice = Dice(DICE_SIDE_COUNT_6)
    //var dice2 = Dice(DICE_SIDE_COUNT_6)
    var dice3 = Dice(DICE_SIDE_COUNT_8)
    var dice4 = Dice(DICE_SIDE_COUNT_8)

    private lateinit var binding: ActivityMainBinding

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        //binding.chooseNumberOfSides!!.text ="Choose number of Dice/s sides"
        //binding.numberOfDiceToRoll!!.text = "Number of dice/s to roll"
       //binding.rollDice!!.setOnClickListener{rollDice()}

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //val inflater = menuInflater
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id: Int = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.my_toolbar) {
            Toast.makeText(this, "Action clicked", Toast.LENGTH_LONG).show()
            return true
        }
        var settingsId: Int= item.itemId
        if(settingsId == R.id.action_favorite ) {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * when dice is rolled view will be populated with setViewContent content
     */
    private fun rollDoubleDicesWith6Sides() {
        dice.roll()
        //dice2.roll()
        //setViewContentsFor2DicesWith6Sides()
    }

    /**
     * display single dice with 6 sides

    private fun rollSingleDicesWith6Sides() {
        //dice2.roll()
        setViewContentsFor1DiceWith6Sides()
    }*/
    /**
     * display double dice with 6 sides
     */
    private fun rollDoubleDicesWith8Sides() {
        dice3.roll()
        dice4.roll()
        setViewContentsFor2DicesWith8Sides()
    }
    /**
     * display single dice with 8 sides
     */
    private fun rollSingleDicesWith8Sides() {
        dice4.roll()
        setViewContentsFor1DiceWith8Sides()
    }
     /**
     * add content to View, to display 2 dices with 8 sides
    */
    fun setViewContentsFor2DicesWith8Sides(){

         //find views in the layout
         binding.diceImage.setImageResource(dice3.getDiceImageResourceFor8Sides())
         binding.secondDiceImage.setImageResource(dice4.getDiceImageResourceFor8Sides())
         binding.sumValue.text = "sum of Dices: ${dice3.currentDiceValue + dice4.currentDiceValue}"
         binding.timesYouRolled.text = "You have rolled ${dice4.rollCount} time/s"

        //Compare both dices value to see if they displayed the same values
        if(dice3.currentDiceValue==dice4.currentDiceValue) {
            binding.sameNumber.text= "Woohoo! you've rolled double numbers"
        }else{
            binding.sameNumber.text= " "
        }
    }
    /**
     * add content to View, to display 1 dice with 8 sides
     */
    fun setViewContentsFor1DiceWith8Sides() {
        binding.secondDiceImage.setImageResource(dice4.getDiceImageResourceFor8Sides())
        binding.sumValue.text = "You have rolled: ${dice4.currentDiceValue}"
        binding.timesYouRolled.text = "You have rolled ${dice4.rollCount} time/s"
    }
    /**
     * add content to View, to display 2 dices with 6 sides

    fun setViewContentsFor2DicesWith6Sides(){
        //find views in the layout
        binding.diceImage.setImageResource(dice.getDiceImageResourceFor6Sides())
        binding.secondDiceImage.setImageResource(dice2.getDiceImageResourceFor6Sides())
        binding.sumValue.text = "sum of Dices: ${dice.currentDiceValue + dice2.currentDiceValue}"
        binding.timesYouRolled.text = "You have rolled ${dice2.rollCount} time/s"

        //Compare both dices value to see if they displayed the same values
        if(dice.currentDiceValue==dice2.currentDiceValue) {
            binding.sameNumber.text= "Woohoo! you've rolled double numbers"
        }else{
            binding.sameNumber.text= " "
        }
    }*/
    /**
     * add content to View, to display 1 dice with 6 sides
    fun setViewContentsFor1DiceWith6Sides() {
        //find views in the layout
        binding.secondDiceImage.setImageResource(dice2.getDiceImageResourceFor6Sides())
        binding.sumValue.text = "You have rolled: ${dice2.currentDiceValue}"
        binding.timesYouRolled.text = "You have rolled ${dice2.rollCount} time/s"
    }*/

    /**
    *Store/Restore values (dices and rollCount) when the app gets onStop() or onDestroy()
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CURRENT_DICE_VALUE_KEY, dice.currentDiceValue)
        outState.putInt(CURRENT_DICE2_VALUE_KEY, dice2.currentDiceValue)
        outState.putInt(COUNT_VALUE_KEY, dice.rollCount)
    }*/
    /**
     * Restore dice State(dice values and rollCount) and Updates UI after the screen rotation

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        dice.currentDiceValue= savedInstanceState.getInt(CURRENT_DICE_VALUE_KEY)
        dice2.currentDiceValue= savedInstanceState.getInt(CURRENT_DICE2_VALUE_KEY)
        dice.rollCount= savedInstanceState.getInt(COUNT_VALUE_KEY)
        //setViewContentsFor2Dices()
    }*/
}
