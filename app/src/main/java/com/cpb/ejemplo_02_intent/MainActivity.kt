package com.cpb.ejemplo_02_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import com.cpb.ejemplo_02_intent.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    val saludo = "Hola desde al Activity Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.mipmap.ic_launcher_round)

        setContentView(binding.root)
        binding.btnCalcular.setOnClickListener {
            val anioNac: Int = binding.editTextNumber.text.toString().toInt()
            val anioAct = Calendar.getInstance().get(Calendar.YEAR)
            val miEdad = anioAct - anioNac
            binding.textView.text = "Tu edad es: $miEdad años"
        }
        binding.btnSiguiente.setOnClickListener {
            startActivity(this,SecondActivity::class.java)
        }
    }

    fun startActivity(activity: Activity, nextActivity: Class<*>) {
        val intent = Intent(activity, nextActivity)
        intent.putExtra("saludo",saludo)
        activity.startActivity(intent)
        //activity.finish()


    }
}