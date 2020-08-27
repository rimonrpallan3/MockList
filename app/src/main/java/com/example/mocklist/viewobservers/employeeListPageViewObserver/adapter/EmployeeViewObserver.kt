package com.example.mocklist.viewobservers.employeeListPageViewObserver.adapter

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.mocklist.model.EmployeeListItem
import timber.log.Timber

class EmployeeViewObserver :BaseObservable() {

    private var mData: EmployeeListItem? = null


    @Bindable
    fun getHeading():String =mData?.name?:""

    @Bindable
    fun getSubHeading():String =mData?.company?.name?:""


    @Bindable
    fun getImageUrl(): String? {
        mData?.profile_image?.let {
            Timber.i("getImageUrl : $it")
          return it
        }?: return  ""
    }




    fun setData(data : EmployeeListItem)
    {
        mData=data
        notifyChange()
    }

}