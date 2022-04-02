package com.example.orwma_lv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unesiBtn.setOnClickListener {
            val imePrezime = editIme.text.toString()
            val opis = editOpis.text.toString()
            imePrezimeView.setText(imePrezime)
            opisView.setText(opis)
            editIme.text.clear()
            editOpis.text.clear()
        }

        izracunajBtn.setOnClickListener {
            val visina = visinaEdit.text.toString().toFloat()
            val masa = masaEdit.text.toString().toFloat()
            val ibm = masa / (visina/100).pow(2)
            //val ibm = masa / ((visina/100) * (visina/100))
            Toast.makeText(getApplicationContext(),
                "$ibm",
                Toast.LENGTH_LONG).show()
            visinaEdit.text.clear()
            masaEdit.text.clear()
        }

    }
}