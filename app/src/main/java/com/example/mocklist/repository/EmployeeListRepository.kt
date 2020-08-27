package com.example.mocklist.repository

import androidx.lifecycle.LiveData
import com.example.mocklist.model.ApiResponseBody
import com.example.mocklist.model.EmployeeList
import com.example.mocklist.repository.api.ApiResponse
import com.example.mocklist.repository.api.RestAPIEntity
import com.example.mocklist.utils.NetworkOnlyResource

class EmployeeListRepository (private val mRestAPIEntity: RestAPIEntity){
    /**
     *  this is to upload multi user id proof images
     *  requestBody : list of image file in multipart/form-data
     * */

    fun getEmployeeList() =
        object : NetworkOnlyResource<EmployeeList>() {
            override fun createCall(): LiveData<ApiResponse<EmployeeList>> {

                return mRestAPIEntity.getEmployeeList()
            }

            override fun saveCallResult(item: EmployeeList?) {
                item?.let {data ->
                  /*  data.forEach {employee->
                        System.out.println("address : ${employee.address}")
                        System.out.println("company : ${employee.company}")
                        System.out.println("name : ${employee.name}")
                        System.out.println("id : ${employee.id}")
                        System.out.println("username : ${employee.username}")
                    }*/
                }
            }
        }.asLiveData


}