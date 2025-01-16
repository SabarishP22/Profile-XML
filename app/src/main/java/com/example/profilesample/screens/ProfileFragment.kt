package com.example.profilesample.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profilesample.R
import com.example.profilesample.adapter.PhotoAdapter
import com.example.profilesample.adapter.StoryAdapter
import com.example.profilesample.base.BaseFragment
import com.example.profilesample.databinding.FragmentProfileBinding
import com.example.profilesample.model.Photo
import com.example.profilesample.model.Story

class ProfileFragment : BaseFragment() {

    private lateinit var profileBinding: FragmentProfileBinding
    private lateinit var storyAdapter: StoryAdapter
    private lateinit var photoAdapter: PhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        profileBinding = FragmentProfileBinding.inflate(layoutInflater)
        return profileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        setSomeViews()
        setStoryAdapter()
        setPhotoAdapter()
    }

    private fun setSomeViews() {
        profileBinding.photosCv.setBackgroundResource(R.drawable.top_left_25)
        profileBinding.storiesTv.rotation = -90f
        profileBinding.photosTv.rotation = -90f
    }

    private fun setStoryAdapter() {
        val storyList = listOf(
            Story(R.drawable.profile_1, "Adams"),
            Story(R.drawable.profile_2, "Sophia"),
            Story(R.drawable.profile_3, "Jackson"),
            Story(R.drawable.profile_4, "Olivia"),
            Story(R.drawable.profile_5, "Ethan"),
            Story(R.drawable.profile_6, "Emma"),
            Story(R.drawable.profile_7, "Aiden"),
            Story(R.drawable.profile_8, "Isabella"),
            Story(R.drawable.profile_9, "Liam"),
            Story(R.drawable.profile_10, "Mia"),
        )
        storyAdapter = StoryAdapter(requireContext(), storyList)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        profileBinding.storyRv.layoutManager = layoutManager
        profileBinding.storyRv.adapter = storyAdapter
    }

    private fun setPhotoAdapter() {
        val photoList = listOf(
            Photo(R.drawable.profile_8),
            Photo(R.drawable.profile_6),
            Photo(R.drawable.profile_10),
            Photo(R.drawable.profile_9),
            Photo(R.drawable.profile_5),
            Photo(R.drawable.profile_2),
            Photo(R.drawable.profile_7),
            Photo(R.drawable.profile_1),
            Photo(R.drawable.profile_5),
            Photo(R.drawable.profile_3),
        )
        photoAdapter = PhotoAdapter(requireContext(), photoList)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        profileBinding.photosRv.layoutManager = layoutManager
        profileBinding.photosRv.adapter = photoAdapter
    }
}