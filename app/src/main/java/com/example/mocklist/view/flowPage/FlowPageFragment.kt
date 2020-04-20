package com.example.mocklist.view.flowPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mocklist.R
import com.example.mocklist.databinding.FragmentFlowBinding
import com.example.mocklist.utils.setRxOnClickListener
import com.example.mocklist.view.BaseFragment
import com.example.mocklist.viewmodel.otpPage.OtpPageViewModel
import com.example.mocklist.viewobservers.flowPageViewObserver.FlowPageViewObserver
import kotlinx.android.synthetic.main.fragment_flow.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FlowPageFragment : BaseFragment() {

    private var mViewObserver = FlowPageViewObserver()
    private val mViewModel: OtpPageViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFlowBinding.inflate(inflater, container, false)
        binding.data = mViewObserver
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadButtonFunctionality()
    }

    override fun onResume() {
        super.onResume()
    }


    /**
     * Function to handle different button clicks
     */

    private fun loadButtonFunctionality() {
        tvOtpPage.setRxOnClickListener {
            findNavController().navigate(R.id.action_flowPageFragment_to_otpPageFragment)
        }

        btnChatPage.setRxOnClickListener {
            findNavController().navigate(R.id.action_flowPageFragment_to_chatStartPageFragment)

        }

        btnRomanticPage.setRxOnClickListener {
            findNavController().navigate(R.id.action_flowPageFragment_to_homePageFragment)


        }

    }
}
