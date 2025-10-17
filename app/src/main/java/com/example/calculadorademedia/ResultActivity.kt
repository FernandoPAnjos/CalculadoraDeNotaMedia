package com.example.calculadorademedia

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ResultActivity : AppCompatActivity() {
    private lateinit var btnNewCalc : Button
    private lateinit var textResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var nota1 : Double = 0.0
        var nota2 : Double = 0.0
        var nota3 : Double = 0.0

        fun caclulateResult() {
            if ( (nota1 + nota2 + nota3)/3 >= 6 ){
                textResult = findViewById(R.id.text_result)
                textResult.text = "Aprovado uma média de: ${(nota1 + nota2 + nota3) / 3}"
            } else {
                textResult = findViewById(R.id.text_result)
                textResult.text = "Reprovado com uma média de: ${(nota1 + nota2 + nota3) / 3}"
            }
        }

        var bundle = intent.extras

        if(bundle != null){
            nota1 = bundle.getDouble("nota1")
            nota2 = bundle.getDouble("nota2")
            nota3 = bundle.getDouble("nota3")

        caclulateResult()
        }

        btnNewCalc = findViewById<Button>(R.id.btn_new_calc)
        btnNewCalc.setOnClickListener {
            finish()
        }
    }
}