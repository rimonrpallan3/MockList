package com.example.mocklist.viewmodel.homepage

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mocklist.model.Content
import com.example.mocklist.model.ContentItems
import com.example.mocklist.model.ImagePageList
import com.example.mocklist.model.Page
import com.example.mocklist.utils.AppConstants
import com.example.mocklist.viewmodel.BaseViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.io.BufferedReader

class HomePageViewModel : BaseViewModel(){


    private  var mImagePageList =  MutableLiveData<ImagePageList>()
    private var mPage = MutableLiveData<Page>()
    private var mContentItems = MutableLiveData<ContentItems>()
    private var mContentList = MutableLiveData<List<Content>>()
    private lateinit var mContent: Content

    fun getFirstImageList(context: Context): LiveData<Page> {
        val livedata = MutableLiveData<Page>()
        viewModelScope.launch {
            val inputStream = context.assets.open(AppConstants.FIRST_PAGE_LIST)
            val fileString = inputStream.bufferedReader().use(BufferedReader::readText)
            val imagePageList = Gson().fromJson(fileString, ImagePageList::class.java)
            livedata.postValue(imagePageList.page)
        }
        return livedata
    }

    fun getSecondImageList(context: Context): LiveData<List<Content>> {
        val livedata = MutableLiveData<List<Content>>()
        viewModelScope.launch {
            val inputStream = context.assets.open(AppConstants.SECOND_PAGE_LIST)
            val fileString = inputStream.bufferedReader().use(BufferedReader::readText)
            val imagePageList = Gson().fromJson(fileString, ImagePageList::class.java)
            livedata.postValue(imagePageList.page.content_items.content)
        }
        return livedata
    }


    fun getLastImageList(context: Context): LiveData<Page> {
        val livedata = MutableLiveData<Page>()
        viewModelScope.launch {
            val inputStream = context.assets.open(AppConstants.LAST_PAGE_LIST)
            val fileString = inputStream.bufferedReader().use(BufferedReader::readText)
            val imagePageList = Gson().fromJson(fileString, ImagePageList::class.java)
            livedata.postValue(imagePageList.page)
        }
        return livedata
    }

   fun getMyDataImageList():MutableLiveData<Page>{
       val livedata = MutableLiveData<Page>()
       val contentList = ArrayList<Content>()
       contentList.add(Content("Family Pot","poster9.jpg"))
       contentList.add(Content("Family Pot","poster8.jpg"))
       contentList.add(Content("Rear Window","poster7.jpg"))
       contentList.add(Content("The Birds","poster9.jpg"))
       contentList.add(Content("Rear Window","poster9.jpg"))
       contentList.add(Content("The Birds","poster8.jpg"))
       contentList.add(Content("Family Pot","poster7.jpg"))
       contentList.add(Content("Family Pot","poster9.jpg"))
       contentList.add(Content("Family Pot","poster8.jpg"))
       contentList.add(Content("Rear Window","poster7.jpg"))
       contentList.add(Content("The Birds with an Extra Long Title","poster9.jpg"))
       contentList.add(Content("Rear Window","poster9.jpg"))
       contentList.add(Content("The Birds","poster8.jpg"))
       contentList.add(Content("Family Pot","posterthatismissing.jpg"))
       contentList.add(Content("Family Pot","poster2.jpg"))
       contentList.add(Content("Family Pot","poster1.jpg"))
       contentList.add(Content("Family Pot","poster3.jpg"))

       val contentItems = ContentItems(contentList)
       val mPage = Page(contentItems,"3","14","Romantic Comedy","27")
       livedata.postValue(mPage)
        return livedata
   }




}