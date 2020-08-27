package com.example.mocklist.viewmodel.employeeListPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mocklist.model.EmployeeListItem
import com.example.mocklist.repository.EmployeeListRepository
import com.example.mocklist.viewmodel.BaseViewModel

class EmployeeListPageViewModel(private val mEmployeeListRepository: EmployeeListRepository) : BaseViewModel(){


    private val mEmployeeItem = MutableLiveData<EmployeeListItem>()

    /**
     * Pagination list of all Popular
     * type: Type of university(popular)
     * searchUniversity: search the university
     */
    fun getEmployeeList() =
        mEmployeeListRepository.getEmployeeList()

    fun getEmployee(): LiveData<EmployeeListItem> {
        return mEmployeeItem
    }


    fun setEmployee(data: EmployeeListItem) {
        mEmployeeItem.postValue(data)
    }


}