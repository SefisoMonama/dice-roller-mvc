package com.strixtechnology.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.strixtechnology.diceroller.databinding.ActivityMainBinding
import com.strixtechnology.diceroller.databinding.ActivitySettingsBinding

private lateinit var binding: ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setContentView(R.layout.activity_settings)
    }
}
