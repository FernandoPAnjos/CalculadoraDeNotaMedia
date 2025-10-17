package com.example.calculadorademedia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalc: Button

    private lateinit var editNota1: TextInputEditText
    private lateinit var editNota2: TextInputEditText
    private lateinit var editNota3: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editNota1 = findViewById(R.id.input_nota1)
        editNota2 = findViewById(R.id.input_nota2)
        editNota3 = findViewById(R.id.input_nota3)


        btnCalc = findViewById<Button>(R.id.btn_calc)

        fun goToResultActivity() {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("nota1", editNota1.text.toString().toDouble())
            intent.putExtra("nota2", editNota2.text.toString().toDouble())
            intent.putExtra("nota3", editNota3.text.toString().toDouble())

            startActivity(intent)
        }

        btnCalc.setOnClickListener {
            if (editNota1.text.toString().isNotEmpty() && editNota2.text.toString().isNotEmpty() && editNota3.text.toString().isNotEmpty()) {
                goToResultActivity()
            } else {
                editNota1.error = "Informe a primeira nota."
                editNota2.error = "Informe a segunda nota."
                editNota3.error = "Informe a terceira nota."
            }
        }
    }
    override fun onResume() {
        super.onResume()
        editNota1.text?.clear()
        editNota2.text?.clear()
        editNota3.text?.clear()

        editNota1.clearFocus()
        editNota2.clearFocus()
        editNota3.clearFocus()
    }
}