package com.example.piedrapapeltijera

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.content.Intent

class GameModeActivity : AppCompatActivity() {
    private lateinit var singlePlayerButton: MaterialButton
    private lateinit var twoPlayerButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)

        singlePlayerButton = findViewById(R.id.singlePlayerButton)
        twoPlayerButton = findViewById(R.id.twoPlayerButton)

        singlePlayerButton.setOnClickListener {
            Toast.makeText(this, "Juego contra la maquina", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SinglePlayerActivity::class.java)
            startActivity(intent)
        }
        twoPlayerButton.setOnClickListener {
            Toast.makeText(this, "Juego contra otra persona", Toast.LENGTH_SHORT).show()
        }
    }
}
