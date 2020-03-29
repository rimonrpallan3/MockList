package com.example.mocklist.viewobservers.homePageViewObserver.adapter

import android.net.Uri
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.mocklist.R
import com.example.mocklist.model.Content

class ImageViewObserver : BaseObservable() {

    private var mData: Content? = null


    @Bindable
    fun getImgHeader()=mData?.name

    @Bindable
    fun getImageUrl(): Int? {
        if(mData?.poster_image =="poster1.jpg"){
            return R.drawable.poster1
        }else if(mData?.poster_image =="poster2.jpg"){
            return R.drawable.poster2
        }else if(mData?.poster_image =="poster3.jpg"){
            return R.drawable.poster3
        }else if(mData?.poster_image =="poster4.jpg"){
            return R.drawable.poster4
        }else if(mData?.poster_image =="poster5.jpg"){
            return R.drawable.poster5
        }else if(mData?.poster_image =="poster6.jpg"){
            return R.drawable.poster6
        }else if(mData?.poster_image =="poster7.jpg"){
            return R.drawable.poster7
        }else if(mData?.poster_image =="poster8.jpg"){
            return R.drawable.poster8
        }else if(mData?.poster_image =="poster9.jpg"){
            return R.drawable.poster9
        }else if(mData?.poster_image =="poster10.jpg"){
            return R.drawable.poster1
        }
        return R.drawable.placeholder_for_missing_posters
    }


    fun setData(data: Content)
    {
        mData=data
        notifyChange()
    }
}