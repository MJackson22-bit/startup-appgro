package com.example.startupappgro.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.startupappgro.R
import com.example.startupappgro.databinding.ActivityAnimalGamesBinding

class AnimalGamesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalGamesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivBackArrow.setOnClickListener {
            onBackPressed()
        }
    }
}