package com.example.saytahmin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.saytahmin.databinding.ActivityPredictBinding
import kotlin.random.Random

class PredictActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPredictBinding
    private var rastgelesayi = 0
    private var sayac = 8
    private var tahmin : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPredictBinding.inflate(layoutInflater)
        val view = binding.root

        rastgelesayi = Random.nextInt(101)
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }
    @SuppressLint("SetTextI18n")
    fun tahminet (view : View)
    {
        tahmin = binding.editTextNumber2.text.toString().toIntOrNull()
        sayac -= 1


        if (tahmin == rastgelesayi)
        {
            val intent = Intent(this@PredictActivity,SonucActivity::class.java)
            intent.putExtra("value", 1) // Kazandı
            finish()
            startActivity(intent)
        }
        if ( tahmin!! >rastgelesayi) {
            binding.tahminText.text = "Azalt"
            binding.textView.text = "Kalan Hak: $sayac"
        }
        if ( tahmin!! < rastgelesayi)
        {
            binding.tahminText.text = "Arttır"
            binding.textView.text = "Kalan Hak: $sayac"
        }
        if (sayac == 0)
        {
            val intent = Intent(this@PredictActivity,SonucActivity::class.java)
            intent.putExtra("value", 0) // Kazandı
            finish()
            startActivity(intent)
        }
    }
}