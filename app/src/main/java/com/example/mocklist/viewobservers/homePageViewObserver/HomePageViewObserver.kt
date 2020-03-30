package com.example.mocklist.viewobservers.homePageViewObserver

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.paging.PagedList
import com.example.mocklist.model.Content
import com.example.mocklist.view.homepage.adapter.RomanticPageAdapter

class HomePageViewObserver : BaseObservable()  {

    private var mRomanticPageAdapter = RomanticPageAdapter()

    @Bindable
    fun getImageList() =mRomanticPageAdapter

    /**
     * fun to load the adapter with data
     */

    fun setImgList(page: PagedList<Content>)
    {
        mRomanticPageAdapter.submitList(page)
        mRomanticPageAdapter.notifyDataSetChanged()
    }
}