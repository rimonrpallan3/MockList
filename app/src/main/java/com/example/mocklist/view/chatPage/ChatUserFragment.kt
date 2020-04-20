package com.example.mocklist.view.chatPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mocklist.databinding.FragmentChatRegisterBinding
import com.example.mocklist.databinding.FragmentChatUsersBinding
import com.example.mocklist.view.BaseFragment
import com.example.mocklist.viewmodel.otpPage.OtpPageViewModel
import com.example.mocklist.viewobservers.chatPageViewObserver.ChatUserViewObserver
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChatUserFragment : BaseFragment() {

    private var mViewObserver = ChatUserViewObserver()
    private val mViewModel: OtpPageViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentChatUsersBinding.inflate(inflater, container, false)
        binding.data = mViewObserver
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadButtonFunctionality()
        loadData()
    }

    override fun onResume() {
        super.onResume()
        loadData()

    }


    /**
     * Function to load the Data from json file using pagination
     */

    private fun loadData(){

    }

    /**
     * Function to handle different button clicks
     */

    private fun loadButtonFunctionality(){


    }


}