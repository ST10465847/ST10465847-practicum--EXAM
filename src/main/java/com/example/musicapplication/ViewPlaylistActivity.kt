package com.example.musicapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ViewPlaylistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_playlist)

        val listView = findViewById<ListView>(R.id.listView)
        val averageBtn = findViewById<Button>(R.id.averageButton)
        val backBtn = findViewById<Button>(R.id.backButton)

        val items = MainActivity.songTitles.indices.map {
            "Title: ${MainActivity.songTitles[it]}, Artist: ${MainActivity.artistNames[it]}, Rating: ${MainActivity.ratings[it]}, Comment: ${MainActivity.comments[it]}"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        averageBtn.setOnClickListener {
            val avg = if (MainActivity.ratings.isNotEmpty()) {
                MainActivity.ratings.sum().toDouble() / MainActivity.ratings.size
            } else {
                0.0
            }
            Toast.makeText(this, "Average Rating: %.2f".format(avg), Toast.LENGTH_LONG).show()
        }

        backBtn.setOnClickListener {
            finish()
        }
    }
}
