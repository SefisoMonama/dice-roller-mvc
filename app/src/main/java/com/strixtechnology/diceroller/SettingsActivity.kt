package com.strixtechnology.diceroller
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.strixtechnology.diceroller.databinding.ActivitySettingsBinding

private lateinit var binding: ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setInitialValues()
        setChipGroupListeners()
    }

    private fun getDiceCountFromStorage(): Int {
        val prefs = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE)
        return prefs.getInt(KEY_DICE_COUNT, DEFAULT_DICE_COUNT)
    }

    private fun storeDiceCount(count : Int) {
        val prefs = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE)
        with (prefs.edit()) {
            putInt(KEY_DICE_COUNT, count)
            apply()
        }
    }

    private fun getSideCountFromStorage() : Int {
        //TODO: IMPLEMENT THIS METHOD
        return 6
    }

    private fun setInitialValues(){
        val diceCount = getDiceCountFromStorage()
        if (diceCount == 1){
            binding.numberOfDice.check(R.id.roll1Dice)
        }else {
            binding.numberOfDice.check(R.id.roll2Dices)
        }
        //TODO: Set the initial values for the other ChipGroup
    }

    private fun setChipGroupListeners() {
        binding.numberOfDice.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.roll1Dice -> storeDiceCount(1)
                R.id.roll2Dices -> storeDiceCount(2)
            }
        }
        //TODO: Set the listener for the other chipGroup
    }

}
