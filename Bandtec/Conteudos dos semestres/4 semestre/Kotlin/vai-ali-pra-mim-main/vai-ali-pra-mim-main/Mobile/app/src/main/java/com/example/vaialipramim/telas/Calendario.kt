package com.example.vaialipramim.telas

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.vaialipramim.R
import com.example.vaialipramim.utils.AcessoSharedPreferences
import java.time.LocalDateTime

class Calendario : AppCompatActivity() {
    lateinit var preferences: AcessoSharedPreferences

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)
        preferences = AcessoSharedPreferences(this)

        //val usuario: Usuario = intent?.getSerializableExtra("usuario") as Usuario

        val dataPost = findViewById<CalendarView>(R.id.calV_dataPost)

        dataPost.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->
            var mesConvertido: String;
            var diaDoMesConvertido: String;

            if (month +1 >= 10)
                mesConvertido = month.toString()
            else
                mesConvertido = "0${month +1}"

            if (dayOfMonth +1 >= 10)
                diaDoMesConvertido = dayOfMonth.toString()
            else
                diaDoMesConvertido = "0${dayOfMonth+1}"

            var date = LocalDateTime.parse("$year-${mesConvertido}-${diaDoMesConvertido}T10:15:20").toString()

            println(date)
            preferences.SalvarValor("dataPost", date)
        })
    }

    fun voltarTelaPostar(view: View) {
        this.finish()
    }
}