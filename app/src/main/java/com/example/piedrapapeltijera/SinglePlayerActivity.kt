package com.example.piedrapapeltijera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import android.widget.PopupMenu

class SinglePlayerActivity : AppCompatActivity() {
    private val rng = Random()
    private var puntajeJugador = 0
    private var puntajeComputadora = 0

    private lateinit var jugadorPiedra: Button
    private lateinit var jugadorPapel: Button
    private lateinit var jugadorTijeras: Button
    private lateinit var imagenSeleccionComputadora: ImageView
    private lateinit var textoPuntajeJugador: TextView
    private lateinit var textoPuntajeComputadora: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_player)

        jugadorPiedra = findViewById(R.id.jugador_piedra)
        jugadorPapel = findViewById(R.id.jugador_papel)
        jugadorTijeras = findViewById(R.id.jugador_tijeras)
        imagenSeleccionComputadora = findViewById(R.id.imagen_seleccion_computadora)
        textoPuntajeJugador = findViewById(R.id.texto_puntaje_jugador)
        textoPuntajeComputadora = findViewById(R.id.texto_puntaje_computadora)
        jugadorPiedra.setOnClickListener { jugarTurno(1) }
        jugadorPapel.setOnClickListener { jugarTurno(2) }
        jugadorTijeras.setOnClickListener { jugarTurno(3) }

        val button: Button = findViewById(R.id.menuboton)
        button.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view)
            popupMenu.menuInflater.inflate(R.menu.single_player_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.action_reset -> {
                        puntajeJugador = 0
                        puntajeComputadora = 0
                        textoPuntajeJugador.text = "Jugador: $puntajeJugador"
                        textoPuntajeComputadora.text = "Computadora: $puntajeComputadora"
                        true
                    }
                    R.id.action_quit -> {
                        val intent = Intent(this, GameModeActivity::class.java)
                        startActivity(intent)
                        finish()
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }
    }
    private fun jugarTurno(seleccionJugador: Int) {
        val seleccionComputadora = rng.nextInt(3) + 1

        when (seleccionComputadora) {
            1 -> imagenSeleccionComputadora.setImageResource(R.drawable.piedra)
            2 -> imagenSeleccionComputadora.setImageResource(R.drawable.papel)
            3 -> imagenSeleccionComputadora.setImageResource(R.drawable.tijeras)
        }

        when {
            seleccionJugador == seleccionComputadora -> {
            }
            (seleccionJugador == 1 && seleccionComputadora == 3) ||
                    (seleccionJugador == 2 && seleccionComputadora == 1) ||
                    (seleccionJugador == 3 && seleccionComputadora == 2) -> {
                puntajeJugador++
            }
            else -> {
                puntajeComputadora++
            }
        }

        textoPuntajeJugador.text = "Puntaje Jugador: $puntajeJugador"
        textoPuntajeComputadora.text = "Puntaje Computadora: $puntajeComputadora"
    }

}