package com.example.ataia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input_duvida = findViewById<EditText>(R.id.input_duvida)

        val button_duvida = findViewById<Button>(R.id.button_duvida)

        button_duvida.setOnClickListener {
            database.use{
                val idDuvida = insert("pergunta",
                    ("pergunta" to input_duvida.text.toString()))
                if (idDuvida != -1L) {
                    toast("Consultando...\n$idDuvida: ${input_duvida.text.toString()}")
                    input_duvida.text.clear()
                    listaPerguntas()
                } else {
                    toast("Erro ao inserir no banco de dados")
                }
            }
        }
    }
    private fun listaPerguntas() {
        val intent = Intent(this, ListaPerguntasActivity::class.java)
        startActivity(intent)
    }

    private fun toast(mensagem: String) {
        Toast.makeText(applicationContext,mensagem,Toast.LENGTH_LONG).show()
    }
}