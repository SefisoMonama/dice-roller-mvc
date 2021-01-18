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

    private fun storeDiceCount(count: Int) {
        val prefs = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE)
        with(prefs.edit()) {
            putInt(KEY_DICE_COUNT, count)
            apply()
        }
    }

    //set dice sides to defaults values
    private fun getSideCountFromStorage(): Int {
        val pref = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE)
        return pref.getInt(KEY_DICE_SIDES, DEFAULT_DICE_SIDES)
    }

    //store number of dice side in sides variable
    private fun storeSidesCount(sides: Int) {
        val pref = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE)
        with(pref.edit()) {
            putInt(KEY_DICE_SIDES, sides)
            apply()
        }
    }

    private fun setInitialValues() {
        val diceCount = getDiceCountFromStorage()
        val sidesCount = getSideCountFromStorage()
        if (diceCount == 1) {
            binding.numberOfDice.check(R.id.roll1Dice)
        } else {
            binding.numberOfDice.check(R.id.roll2Dices)
        }

        if (sidesCount == 6) {
            binding.chooseDiceSides.check(R.id.sixSides)
        } else {
            binding.chooseDiceSides.check(R.id.eightSides)
        }
    }

    private fun setChipGroupListeners() {
        binding.numberOfDice.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.roll1Dice -> storeDiceCount(1)
                R.id.roll2Dices -> storeDiceCount(2)
            }
        }

        binding.chooseDiceSides.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.sixSides -> storeSidesCount(6)
                R.id.eightSides -> storeSidesCount(8)
            }
        }
        //TODO: Set the listener for the other chipGroup
    }

}
