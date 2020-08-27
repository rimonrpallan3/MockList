package com.example.mocklist.utils

import com.example.mocklist.BuildConfig

/**
 * The Constants values that using throughout application
 */
object AppConstants {

    const val API_BASE_URL = BuildConfig.BASE_URL
    const val BUTTON_THROTTLE = 500L
    const val FIRST_PAGE_LIST= "list_page_1.json"
    const val SECOND_PAGE_LIST= "list_page_2.json"
    const val LAST_PAGE_LIST= "list_page_3.json"
    const val PAGINATION_PAGE_SIZE: Int = 5

}
