package com.example.musicapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddSongActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songscreen)

        val titleInput = findViewById<EditText>(R.id.songTitleInput)
        val artistInput = findViewById<EditText>(R.id.artistNameInput)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val genreSpinner = findViewById<Spinner>(R.id.genreSpinner)
        val commentInput = findViewById<EditText>(R.id.commentInput)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val goToPlaylistButton = findViewById<Button>(R.id.goToPlaylistButton)

        val genresList = arrayOf("Pop", "Hip-Hop", "Jazz", "Rock", "Afrobeat", "Other")
        genreSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genresList)

        saveButton.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val artist = artistInput.text.toString().trim()
            val genre = genreSpinner.selectedItem.toString()
            val rating = ratingBar.rating.toInt()
            val comment = commentInput.text.toString().trim()

            if (title.isEmpty() || artist.isEmpty()) {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            MainActivity.songTitles.add(title)
            MainActivity.artistNames.add(artist)
            MainActivity.genres.add(genre)
            MainActivity.ratings.add(rating)
            MainActivity.comments.add(comment)

            Toast.makeText(this, "Song added successfully!", Toast.LENGTH_SHORT).show()

            titleInput.text.clear()
            artistInput.text.clear()
            commentInput.text.clear()
            ratingBar.rating = 0f
            genreSpinner.setSelection(0)
        }

        // 🆕 Go to Playlist screen
        goToPlaylistButton.setOnClickListener {
            val intent = Intent(this, ViewPlaylistActivity::class.java)
            startActivity(intent)
        }
    }
}
