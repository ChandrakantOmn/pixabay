package com.demo.pagedemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.pagedemo.models.APIResponse

class MainAdapter(
    private var photos: List<APIResponse.Hit>,
    var clickListener: View.OnClickListener
) : RecyclerView.Adapter<MainAdapter.PhotoHolder>() {

    override fun getItemCount(): Int {
        return photos.size
    }


    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val photo = photos[position]
        holder.tags.text = photo.tags
        holder.likes.text = photo.likes.toString()
        holder.favorites.text = photo.favorites.toString()
        if (photo.previewURL?.isNotEmpty() == true) {
            Glide.with(holder.tags.context)
                .load(photo.previewURL)
                .into(holder.photoItem)
        }
    }

    fun getPhoto(adapterPosition: Int): APIResponse.Hit {
        return photos[adapterPosition]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        return PhotoHolder(
            LayoutInflater.from(parent?.context)
                .inflate(R.layout.photo_item, parent, false)
        )
    }

    inner class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tags: TextView
        var likes: TextView
        var favorites: TextView
        var photoItem: ImageView

        init {
            itemView.setOnClickListener(clickListener)
            itemView.tag = this
            tags = itemView.findViewById(R.id.tags)
            likes = itemView.findViewById(R.id.likes)
            favorites = itemView.findViewById(R.id.favorites)
            photoItem = itemView.findViewById(R.id.photo_item)
        }
    }


}