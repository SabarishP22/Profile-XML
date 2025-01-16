package com.example.profilesample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.profilesample.R
import com.example.profilesample.model.Story

class StoryAdapter(
    private val context: Context,
    private var list: List<Story>
) : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val storyItemIv: ImageView = view.findViewById(R.id.storyItemIv)
        val storyItemTv: TextView = view.findViewById(R.id.storyItemTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context)
                .inflate(R.layout.story_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mList = list[position]
        holder.storyItemTv.text = mList.storyName
        holder.storyItemIv.setImageResource(mList.storyImage)
    }
}