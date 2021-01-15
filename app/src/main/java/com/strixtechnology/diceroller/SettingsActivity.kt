package com.strixtechnology.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.strixtechnology.diceroller.databinding.ActivityMainBinding
import com.strixtechnology.diceroller.databinding.ActivitySettingsBinding

private lateinit var binding: ActivitySettingsBinding
private lateinit var bindings: ActivityMainBinding

const val DICE_SIDE_COUNT_6 = 6

class SettingsActivity : AppCompatActivity() {

    var dice2 = Dice(DICE_SIDE_COUNT_6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        bindings = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(binding.root)
        //setContentView(R.layout.activity_settings)
        //bindings.rollDice!!.setOnClickListener{rollDice()}
    }


    private fun rollDice(){
        //conditional formatting to roll certain number of dice/s and sides as filtered by user
        if(binding.sixSides!!.isChecked()){
            if(binding.roll1Dice!!.isChecked()){
                rollSingleDicesWith6Sides()
                //set dice2View to be removed to only display 1 dice
                bindings.diceImage.setVisibility(View.GONE)
            }
        }
    }
        private fun rollSingleDicesWith6Sides() {
            dice2.roll()
            setViewContentsFor1DiceWith6Sides()
        }

        /**  //conditional formatting to roll certain number of dice/s and sides as filtered by user
        if(binding.eightSides!!.isChecked()){
            if(binding.roll1Dice!!.isChecked()){
                rollSingleDicesWith8Sides()
                //set dice2View to be removed to only display 1 dice
                binding.diceImage.setVisibility(View.GONE)
            }else if(binding.roll2Dices!!.isChecked()){
                rollDoubleDicesWith8Sides()
                binding.diceImage.setVisibility(View.VISIBLE)
            }
        }*/

      fun setViewContentsFor1DiceWith6Sides() {
          //find views in the lay
          bindings.secondDiceImage.setImageResource(dice2.getDiceImageResourceFor6Sides())
          bindings.sumValue.text = "You have rolled: ${dice2.currentDiceValue}"
          bindings.timesYouRolled.text = "You have rolled ${dice2.rollCount} time/s"
      }

    }




