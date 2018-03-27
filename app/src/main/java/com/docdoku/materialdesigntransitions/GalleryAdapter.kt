package com.docdoku.materialdesigntransitions

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by romainz on 27/03/18.
 */
class GalleryAdapter(private val mUrls: List<String>, private val mContext: AppCompatActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mView = LayoutInflater.from(mContext).inflate(R.layout.rv_item, parent, false)
        return ItemViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return mUrls.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val url = mUrls[position]
        val imageView = holder.itemView.findViewById<ImageView>(R.id.iv_item)
        Picasso.get().load(url).into(imageView)
        holder.itemView?.setOnClickListener({
            val transitionBundle = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptionsCompat.makeSceneTransitionAnimation(mContext, imageView, imageView.transitionName).toBundle()
            } else {
                Bundle()
            }
            val dataBundle = Bundle()
            dataBundle.putString("DOG_URL", url)
            val intent = Intent(mContext, DogDetailsActivity::class.java)
            intent.putExtras(dataBundle)
            mContext.startActivity(intent, transitionBundle)
        })
    }

    class ItemViewHolder(mView: View) : RecyclerView.ViewHolder(mView)

}