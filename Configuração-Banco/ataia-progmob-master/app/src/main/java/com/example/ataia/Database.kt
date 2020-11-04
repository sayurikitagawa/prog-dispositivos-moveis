package com.example.ataia

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class Database(contex: Context) :
    ManagedSQLiteOpenHelper(ctx = contex, name = "monitora.db", version = 1) {

    companion object {
        private var instance: Database? = null

        @Synchronized
        fun getInstance(ctx: Context): Database {
            if (instance == null) {
                instance = Database(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("pergunta", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "pergunta" to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}

val Context.database: Database
    get() = Database.getInstance(getApplicationContext())