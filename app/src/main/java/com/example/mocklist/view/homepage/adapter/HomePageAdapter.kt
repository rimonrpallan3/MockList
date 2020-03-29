package com.example.mocklist.view.homepage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bigvand.surfboard.view.BaseRecyclerAdapter
import com.example.mocklist.databinding.ImageListItemBinding
import com.example.mocklist.model.Content
import com.example.mocklist.view.homepage.viewholder.ImageListViewHolder
import com.example.mocklist.viewobservers.homePageViewObserver.adapter.ImageViewObserver

class HomePageAdapter : BaseRecyclerAdapter<Content, ImageListViewHolder>() {
    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup,
        viewType: Int
    ): ImageListViewHolder {
        val binding  = ImageListItemBinding.inflate(inflater,container, false)
        binding.data = ImageViewObserver()
        return ImageListViewHolder(binding)
    }




}