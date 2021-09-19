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
            service.getAvCategories().enqueue(object : Callback<List<AvCategory>> {
                override fun onResponse(
                    call: Call<List<AvCategory>>,
                    response: Response<List<AvCategory>>
                ) {
                    val avCategories = response.body() ?: return
                    textView1.text = avCategories.toString()
                }

                override fun onFailure(call: Call<List<AvCategory>>, t: Throwable) {
                    Log.d("MainActivity", "はずれ！")
                }
            })
        } catch(e:Exception) {
            Log.d("MainActivity", "はずれ！" + e.message)
            textView1.text = "はずれ！"
        }
//        }
    }

    fun tappedCollectionsButton() {
        val service = AvRepository().getRetrofit()
//        val scope = CoroutineScope(Dispatchers.IO)
//        scope.launch {
        try {
            service.getAvCollections().enqueue(object : Callback<List<AvCollection.Response.Collection>> {
                override fun onResponse(
                    call: Call<List<AvCollection.Response.Collection>>,
                    response: Response<List<AvCollection.Response.Collection>>
                ) {
                    val avCollections = response.body() ?: return
                    textView2.text = avCollections.toString()
                }

                override fun onFailure(call: Call<List<AvCollection.Response.Collection>>, t: Throwable) {
                    Log.d("MainActivity", "はずれ！")
                }
            })
        } catch(e:Exception) {
            Log.d("MainActivity", "はずれ！" + e.message)
            textView2.text = "はずれ！"
        }
//        }
    }
}