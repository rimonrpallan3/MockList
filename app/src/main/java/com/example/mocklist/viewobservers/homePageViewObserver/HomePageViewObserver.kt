package com.example.mocklist.viewobservers.homePageViewObserver

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.mocklist.model.Content
import com.example.mocklist.view.homepage.adapter.HomePageAdapter

class HomePageViewObserver : BaseObservable()  {

    private var img: List<Content> = mutableListOf()

    private  var mHomePageAdapter = HomePageAdapter()

    @Bindable
    fun getImageList() =mHomePageAdapter


    fun setImgList(data :List<Content>)
    {
        img = data
        mHomePageAdapter.setData(data)
        mHomePageAdapter.notifyDataSetChanged()
    }
}