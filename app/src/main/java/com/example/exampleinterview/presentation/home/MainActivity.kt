package com.example.exampleinterview.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampleinterview.R
import com.example.exampleinterview.data.adapters.CustomAdapter
import com.example.exampleinterview.data.entities.Post
import com.example.exampleinterview.databinding.ActivityMainBinding
import com.example.exampleinterview.domain.repositories.ApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    //Contiene la vista inflada para acceder a los id
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setEvents()
        requestData()
    }

    private fun requestData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(ApiService::class.java)
        lifecycleScope.launch {
            try {
                val post = apiService.getAllPost()
                Log.e("RESPONSE","Response:" + post.size)
                setData(post)
            } catch (e: Exception) {
                Log.e("RESPONSE","Error:" + e.message)
            }
        }
    }


    private fun setEvents(){
        binding.button.setOnClickListener {
            Toast.makeText(this,binding.field1.text,Toast.LENGTH_SHORT).show()
        }
    }

    private fun setData(posts: Array<Post>){
        val customAdapter = CustomAdapter(posts)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = customAdapter
    }
}
