package com.example.mocklist.view.homepage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import com.example.mocklist.databinding.EmployeeListItemBinding
import com.example.mocklist.model.EmployeeList
import com.example.mocklist.model.EmployeeListItem
import com.example.mocklist.view.BaseRecyclerAdapter
import com.example.mocklist.view.homepage.viewholder.EmployeeListViewHolder
import com.example.mocklist.view.homepage.viewholder.ImageListViewHolder
import com.example.mocklist.viewobservers.employeeListPageViewObserver.adapter.EmployeeViewObserver

class EmployeeListPageAdapter() : BaseRecyclerAdapter<EmployeeListItem, EmployeeListViewHolder>() {

    private var mEmployee: EmployeeListItem? = null
    private lateinit var mEmployeeListItem: ((EmployeeListItem?) -> Unit)
    fun setEmployeeList(callback: (EmployeeListItem?) -> Unit) {
        mEmployeeListItem = callback
    }


    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup,
        viewType: Int
    ): EmployeeListViewHolder {
        val binding = EmployeeListItemBinding.inflate(inflater, container, false)
        binding.data = EmployeeViewObserver()
        return EmployeeListViewHolder(binding,mEmployeeListItem)
    }
}