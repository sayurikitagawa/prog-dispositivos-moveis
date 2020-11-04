package com.example.ataia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_pergunta.*
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.rowParser
import org.jetbrains.anko.db.select

class ListaPerguntasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pergunta)

        val perguntasAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        list_view_perguntas.adapter = perguntasAdapter

        database.use {
            select("pergunta").exec {
                val parser = rowParser() { id: Int,
                                           pergunta: String ->
                    Pergunta(id, pergunta)
                }
                var listaPerguntas = parseList(parser)

                perguntasAdapter.clear()
                val duvidasTexto = listaPerguntas.map { it.duvida }
                perguntasAdapter.addAll(duvidasTexto)
            }
        }

    }
}