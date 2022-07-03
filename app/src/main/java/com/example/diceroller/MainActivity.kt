package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {/*val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT) toast.show()*/
            /*val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "6"*/
            rollDice()
        }
    }

    //Tira los dados y actualiza la pantalla con el resultado.
    private fun rollDice() {
        //Crea un nuevo objeto dado con 6 lados y tira los dados
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage:ImageView = findViewById(R.id.imageView)

        /*when (diceRoll){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }*/
        //Determina que ID de recurso(imagen) dibujable usa la funcion de tirados de dados
        val drawableResource = when (diceRoll){
            1 ->R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else ->R.drawable.dice_6
        }
        //Actualiza ImageWiev con el ID de recurso(Imagen) dibujable correcto
        diceImage.setImageResource(drawableResource)
        //Actualiza la descripcion de contenido
        diceImage.contentDescription = diceRoll.toString()
        /*val myFirstDice =Dice (6)
        val rollResult = myFirstDice.roll()
        val numero_suerte = 4

        when (rollResult){
             numero_suerte -> println("¡Ganaste!")
            1 -> println("¡lo siento mucho!, Sacaste un 1. ¡vuelve a intentarlo!")
            2 -> println("lamentablemente, Sacaste un 2. ¡intente de nuevo!")
            2 -> println("Desafortunadamente,  Sacaste un 3. ¡vuelve a intentarlo!")
            2 -> println("¡No llores!, Sacaste un 5. ¡intente de nuevo!")
            2 -> println("¡Disculpas!, Sacaste un 6. ¡vuelve a intentarlo!")
        }*/
    }
}
class Dice(private val numSides: Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}