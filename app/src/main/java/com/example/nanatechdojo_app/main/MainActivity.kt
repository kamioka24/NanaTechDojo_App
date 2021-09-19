package com.example.nanatechdojo_app.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nanatechdojo_app.R
import com.example.nanatechdojo_app.model.AvCategory
import com.example.nanatechdojo_app.model.AvCollection
import com.example.nanatechdojo_app.repository.AvRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categoriesButton = findViewById<Button>(R.id.categories_button)
        categoriesButton.setOnClickListener {
            tappedCategoriesButton()
        }

        val collectionsButton = findViewById<Button>(R.id.collections_button)
        collectionsButton.setOnClickListener {
            tappedCollectionsButton()
        }
    }

    fun tappedCategoriesButton() {
        val service = AvRepository().getRetrofit()
//        val scope = CoroutineScope(Dispatchers.IO)
//        scope.launch {
        try {
            service.getAvCategories().enqueue(object : Callback<AvCategory> {
                override fun onResponse(call: Call<AvCategory>, response: Response<AvCategory>) {
                    val avCategories = service.getAvCategories()
                    val text1 = findViewById<TextView>(R.id.textView1)
                    text1.text = avCategories.toString()
                }

                override fun onFailure(call: Call<AvCategory>, t: Throwable) {
                    Log.d("MainActivity", "はずれ！")
                }
            })
        } catch(e:Exception) {
                textView1.text = "はずれ！"
        }
//        }
    }

    fun tappedCollectionsButton() {
        val service = AvRepository().getRetrofit()
//        val scope = CoroutineScope(Dispatchers.IO)
//        scope.launch {
        try {
            service.getAvCollections().enqueue(object : Callback<AvCollection> {
                override fun onResponse(
                    call: Call<AvCollection>,
                    response: Response<AvCollection>
                ) {
                    val avCollections = service.getAvCollections()
                    val text2 = findViewById<TextView>(R.id.textView2)
                    text2.text = avCollections.toString()
                }

                override fun onFailure(call: Call<AvCollection>, t: Throwable) {
                    Log.d("MainActivity", "はずれ！")
                }
            })
        } catch(e:Exception) {
                textView2.text = "はずれ！"
        }
//        }
    }
}