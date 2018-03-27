package com.docdoku.materialdesigntransitions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * The goal of this exercise is to display a grid of images of dogs.
 * Clicking on one of these images displays the details of this dog. The transition between the
 * two activities has to be done with a transition with shared element.
 * You can do this exercise using MVP pattern, or not!
 */
class MainActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_images_grid.layoutManager = GridLayoutManager(this, 2)

        val okHttpClient = OkHttpClient.Builder().build()

        val mapper = jacksonObjectMapper()
        mapper.findAndRegisterModules()
        retrofit = Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://dog.ceo")
                .client(okHttpClient)
                .build()

        val single = retrofit.create(DogsApi::class.java).getCollieImages()

        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ breedResponse ->
                    setAdapter(breedResponse.message)

                }, {
                    Log.e("MainActivity", "Error occurred", it)
                })
    }

    private fun setAdapter(data: List<String>) {
        rv_images_grid.adapter = GalleryAdapter(data, this)
    }
}
