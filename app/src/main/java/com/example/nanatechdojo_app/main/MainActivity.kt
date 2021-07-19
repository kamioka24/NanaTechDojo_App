package com.example.nanatechdojo_app.main

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nanatechdojo_app.R
import com.example.nanatechdojo_app.repository.AvRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categoriesButton = findViewById<Button>(R.id.categories_button)
        categoriesButton.setOnClickListener {
            tappedCategorycategories_button()
        }

        val collectionsButton = findViewById<Button>(R.id.collections_button)
        collectionsButton.setOnClickListener {
            tappedCollectioncollections_button()
        }
    }

    fun tappedCategorycategories_button() {
        val service = AvRepository().getRetrofit()
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            try {
                val avCategories = service.getAvCategories()
                val text1 = findViewById<TextView>(R.id.textView1)
                text1.text = avCategories.toString()
            } catch(e:Exception) {
                print("はずれ")
            }
        }
    }

    fun tappedCollectioncollections_button() {
        val service = AvRepository().getRetrofit()
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            try {
                val avCollections = service.getAvCollections()
                val text2 = findViewById<TextView>(R.id.textView2)
                text2.text = avCollections.toString()
            } catch(e:Exception) {
                print("はずれ")
            }
        }
    }
}