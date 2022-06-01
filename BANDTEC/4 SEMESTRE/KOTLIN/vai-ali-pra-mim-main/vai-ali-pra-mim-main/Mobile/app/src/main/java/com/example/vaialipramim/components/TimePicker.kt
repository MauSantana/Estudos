package com.example.vaialipramim.components

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.TextView

import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.vaialipramim.R
import java.util.*

class TimePickerFragment() : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    public var horaSelecionada: String = "";
    public var parentView: AppCompatActivity? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        return TimePickerDialog(activity, this, hour, minute, true)
    }

    fun configurarDatePicker(parentView: AppCompatActivity) {
        this.parentView = parentView
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        var horaConvertido: String;
        var minutoConvertido: String;

        if (hourOfDay >= 10)
            horaConvertido = hourOfDay.toString()
        else
            horaConvertido = "0$hourOfDay"

        if (minute >= 10)
            minutoConvertido = minute.toString()
        else
            minutoConvertido = "0$minute"

        horaSelecionada = "${horaConvertido}:${minutoConvertido}:00"
        println(horaSelecionada)
        val tempo_estimado = parentView!!.findViewById<TextView>(R.id.tv_tempo_estimado)
        tempo_estimado.setText(horaSelecionada)
    }
}