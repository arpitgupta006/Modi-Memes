package com.arpit.modimemes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        Client.api.fetchAllMemes().enqueue(object : Callback<List<MemeResponse>> {
            override fun onFailure(call: Call<List<MemeResponse>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<MemeResponse>>, response: Response<List<MemeResponse>>) {
                showMemes(response.body()!!)
            }

        })
    }

    private fun showMemes(memes: List<MemeResponse>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ViewAdapter(memes)
        }

    }
}