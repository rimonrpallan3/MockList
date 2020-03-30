package com.example.mocklist.viewmodel.homepage

import com.example.mocklist.repository.HomeRepository
import com.example.mocklist.viewmodel.BaseViewModel

class HomePageViewModel(private val mHomeRepository: HomeRepository) : BaseViewModel(){

    /**
     * Function to load the Data from json file using pagination
     */
    fun getDataList() = mHomeRepository.getDataListPaginated(1)


    /**
     * Function to load the Data when searching
     */
    fun getDataListSearch(query: String) = mHomeRepository.getDataListPageSearch(query)

}