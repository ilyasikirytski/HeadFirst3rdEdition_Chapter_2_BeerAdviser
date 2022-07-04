package com.example.beeradviser

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val color = findViewById<Spinner>(R.id.beer_color)
        val brands = findViewById<TextView>(R.id.brands)
        val findBeer = findViewById<Button>(R.id.find_beer)

        findBeer.setOnClickListener {
            val beerList = getBeers(color.selectedItem.toString())
            val beers = beerList.reduce { str, item -> str + "\n" + item }
            brands.text = beers
        }
    }

    private fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}