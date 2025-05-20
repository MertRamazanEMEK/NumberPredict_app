package com.example.saytahmin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.saytahmin.databinding.ActivityPredictBinding
import com.example.saytahmin.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySonucBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sonuc = intent.getIntExtra("value", 0)

        if (sonuc == 1)
        {
            binding.textView2.text = "KAZANDINIZ"
            binding.imageView2.setImageResource(R.drawable.drav_upvote)
        }
        if (sonuc == 0){
            binding.textView2.text = "KAYBETTİNİZ"
            binding.imageView2.setImageResource(R.drawable.draw_bad)
        }
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
    fun tekrar (view : View)
    {
        val intent = Intent(this@SonucActivity,MainActivity::class.java)
        finish()
        startActivity(intent)

    }
}