package com.example.vaialipramim.telas

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import androidx.appcompat.app.AppCompatActivity

import com.example.vaialipramim.R


@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        val handlerThread = HandlerThread("background-thread")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)
        handler.postDelayed({
            val intent = Intent(this@SplashActivity, TelaInicial::class.java)
            startActivity(intent)
            handlerThread.quitSafely()
        }, 2500)
    }
}