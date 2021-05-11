package com.cpb.ejemplo_02_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cpb.ejemplo_02_intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second)

        supportActionBar!!.title = "Atrás"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bundle = intent.extras
        //if (bundle != null && bundle.getString("saludo") != null){
        if(bundle?.getString("saludo") != null){
            val saludo = bundle.getString("saludo")
            binding.textViewIntent.text = saludo
        }else{
            Toast.makeText(this,"Esta vacío", Toast.LENGTH_SHORT).show()
        }

        binding.btnSiguienteSecond.setOnClickListener {
            //startActivity(this,SecondActivity::class.java)
            startActivity(this,ThirdActivity::class.java)
        }
    }

    fun startActivity(activity: Activity, nextActivity: Class<*>) {
        val intent = Intent(activity, nextActivity)
        activity.startActivity(intent)
        //activity.finish()


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}