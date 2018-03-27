package com.docdoku.materialdesigntransitions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

/**
 * The goal of this exercise is to display a grid of images of dogs.
 * Clicking on one of these images displays the details of this dog. The transition between the
 * two activities has to be done with a transition with shared element.
 * You can do this exercise using MVP pattern, or not!
 */
class MainActivity : AppCompatActivity() {

    /**
     * TODO(1) Retrieve a list of image urls of a specific breed thanks to the free API https://dog.ceo/dog-api/
     * For this task, you'd need an http client (OkHttp, Retrofit).
     * The response model is provided (BreedResponse.kt).
     * You'd need to use a JSON mapper (e.g: Gson, Jackson)
     * TODO(2) Set an adapter for the recycler view "rv_images_grid" and give it the urls
     * TODO(3) Implement the methods of the adapter
     * For images loading, you can use Picasso (Square library)
     * TODO(4) Create a new activity "DogDetailsActivity" by using the template 'Scrolling Activity'
     * TODO(5) Add an ImageView in the layout of this activity.
     * Put this ImageView inside the appbar
     * TODO(6) When you click on an image displayed in MainActivity, start the new activity
     * You can pass the url of the dog and reload the image in this activity.
     * TODO(7) Change the theme of your application to enable the window content transition
     * android:windowContentTransitions = true
     * TODO(8) Select the views sharing the element and modify their xml content by adding
     * android:transitionName="@string/dog_image_transition_name"
     * TODO(9) Start the DogDetailsActivity by adding an options bundle
     * You can create the options bundle by calling ActivityOptionsCompat.makeSceneTransitionAnimation
     * and then activity.startActivity(intent, transitionBundle)
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_images_grid.layoutManager = GridLayoutManager(this, 2)
    }
}
