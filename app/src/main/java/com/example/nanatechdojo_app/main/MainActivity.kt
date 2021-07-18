package com.example.nanatechdojo_app.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nanatechdojo_app.R
import com.example.nanatechdojo_app.repository.AvRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            tappedCategoryButton()
        }
    }

    fun tappedCategoryButton() {
        val service = AvRepository().getRetrofit()
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            try {
                val avCategories = service.getAvCategories()
                val avCollections = service.getAvCollections()
                val text1 = findViewById<TextView>(R.id.textView1)
                val text2 = findViewById<TextView>(R.id.textView2)
                text1.text = avCategories.toString()
                text2.text = avCollections.toString()
            } catch(e:Exception) {
                print("はずれ")
            }
        }
    }
}