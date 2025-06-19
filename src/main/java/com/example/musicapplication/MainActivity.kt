package com.example.musicapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        val songTitles = ArrayList<String>()
        val artistNames = ArrayList<String>()
        val genres = ArrayList<String>()
        val ratings = ArrayList<Int>()
        val comments = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn = findViewById<Button>(R.id.addButton)
        val viewBtn = findViewById<Button>(R.id.viewButton)
        val exitBtn = findViewById<Button>(R.id.exitButton)

        addBtn.setOnClickListener {
            val intent = Intent(this, AddSongActivity::class.java) // your add song activity class
            startActivity(intent)
        }

        viewBtn.setOnClickListener {
            val intent = Intent(this, ViewPlaylistActivity::class.java) // your view playlist activity class
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Exit App")
            builder.setMessage("Are you sure you want to exit?")
            builder.setPositiveButton("Yes") { _, _ -> finishAffinity() }
            builder.setNegativeButton("No", null)
            builder.show()
        }
    }
}
