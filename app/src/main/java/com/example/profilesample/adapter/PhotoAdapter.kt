package com.example.profilesample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.profilesample.R
import com.example.profilesample.model.Photo

class PhotoAdapter(
    private val context: Context,
    private var list: List<Photo>
) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photoIv: ImageView = view.findViewById(R.id.photoIv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context)
                .inflate(R.layout.photos_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mList = list[position]
        holder.photoIv.setImageResource(mList.image)
    }
}