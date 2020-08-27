package com.example.mocklist.viewobservers.employeeListPageViewObserver

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.mocklist.model.EmployeeListItem
import com.example.mocklist.view.homepage.adapter.EmployeeListPageAdapter
import com.example.mocklist.BR;

class EmployeeListPageViewObserver : BaseObservable() {

    private var mEmployeeListAdapter = EmployeeListPageAdapter()


    private var mProgressLoader: Boolean = false

    @Bindable
    fun getEmployeeListAdapter() = mEmployeeListAdapter

    fun setAdapterData(data: List<EmployeeListItem>) {
        mEmployeeListAdapter.setData(data)
        mEmployeeListAdapter.notifyDataSetChanged()
    }


    @Bindable
    fun getProgressLoaderVisibility() =
        if (mProgressLoader) View.VISIBLE else View.GONE


    fun setProgressLoaderVisibility(view: Boolean) {
        mProgressLoader = view
        notifyPropertyChanged(BR.progressLoaderVisibility)
    }

}