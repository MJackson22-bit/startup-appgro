package com.example.startupappgro.ui

import android.annotation.SuppressLint
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.contains
import androidx.viewpager2.widget.ViewPager2
import com.example.startupappgro.R
import com.example.startupappgro.adapter.ViewPaperAdapter
import com.example.startupappgro.databinding.ActivityPresentationBinding
import com.example.startupappgro.transformer.DepthPageTransformer
import com.example.startupappgro.view.ShadowContainer
import com.example.startupappgro.view.ShadowContainerPurple

class PresentationActivity : AppCompatActivity() {
    private var imageList = mutableListOf<Int>()
    private var titleList = mutableListOf<String>()
    private var detailsList = mutableListOf<String>()
    private lateinit var binding: ActivityPresentationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPresentationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postToList()
        binding.viewPaper2.adapter =
            ViewPaperAdapter(image = imageList, title = titleList, details = detailsList)
        binding.viewPaper2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val indicator = binding.indicator
        binding.viewPaper2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.shadow.elevationShadowColor = getColorStateList(R.color.animal)
                    }
                    1 -> {
                        binding.shadow.elevationShadowColor = getColorStateList(R.color.plant)
                    }
                    else -> Toast.makeText(this@PresentationActivity, "Error", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
        indicator.setViewPager(binding.viewPaper2)
    }

    private fun addToList(image: Int, title: String, details: String) {
        titleList.add(title)
        detailsList.add(details)
        imageList.add(image)
    }

    private fun postToList() {
        addToList(
            R.drawable.animal_icon,
            "Animales",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        )
        addToList(
            R.drawable.plant_icon,
            "Plantas",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        )
    }

}