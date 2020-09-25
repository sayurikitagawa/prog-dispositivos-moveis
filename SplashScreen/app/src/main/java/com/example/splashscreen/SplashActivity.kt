package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mudarParaActivityDuvida()
    }

    private fun mudarParaActivityDuvida() {
        val intent = Intent(this, InicialActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 5000)
    }

    fun Intent.change() {
        startActivity(this)
        finish()
    }

}