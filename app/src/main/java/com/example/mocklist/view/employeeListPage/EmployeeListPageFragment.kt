package com.example.mocklist.view.employeeListPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mocklist.R
import com.example.mocklist.databinding.FragmentEmployeeListBinding
import com.example.mocklist.utils.NetworkStatus
import com.example.mocklist.utils.Utils
import com.example.mocklist.utils.setRxOnClickListener
import com.example.mocklist.view.BaseFragment
import com.example.mocklist.viewmodel.employeeListPage.EmployeeListPageViewModel
import com.example.mocklist.viewobservers.employeeListPageViewObserver.EmployeeListPageViewObserver
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.fragment_employee_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class EmployeeListPageFragment : BaseFragment() {

    private var mViewObserver = EmployeeListPageViewObserver()
    private val mViewModel: EmployeeListPageViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEmployeeListBinding.inflate(inflater, container, false)
        binding.data = mViewObserver
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.v("onViewCreated   ")
        System.out.println("onViewCreated   ")
        tvAppBarHeading.setText("Employee List")
        loadButtonFunctionality()
        loadPopularList()

    }


    private fun loadPopularList(){
        System.out.println("loadPopularList Outter  ")

        if (Utils.isInternetAvailable(context!!)) {
            Timber.i("loadPopularList inside  ")
            System.out.println("loadPopularList inside  ")

                mViewModel.getEmployeeList().observe(this, Observer { response ->
                    mViewObserver.setProgressLoaderVisibility(false)
                        when (response.status) {
                            NetworkStatus.SUCCESS -> {
                                mViewObserver.setProgressLoaderVisibility(false)
                                System.out.println("loadPopularList inside  response SUCCESS")

                                response?.body?.let {
                                     mViewObserver.setAdapterData(it)
                                }

                            }
                            NetworkStatus.ERROR -> {
                                mViewObserver.setProgressLoaderVisibility(false)
                                response.exception?.let { appException ->
                                    if (appException.cause is UnknownHostException || appException.cause is SocketTimeoutException) {
                                        Utils.showTopSnackBar(
                                            appBar,
                                            getString(R.string.oops_no_network)
                                        )
                                    } else {
                                        Timber.i("getEmployeeList response is :${response.toString()}")

                                         Utils.showTopSnackBar(
                                             appBar,
                                             appException.getErrorReponse()?.message!!
                                         )
                                    }
                                } ?: let {
                                    Utils.showTopSnackBar(
                                        appBar,
                                        getString(R.string.something_went_wrong)
                                    )
                                }
                            }
                            NetworkStatus.LOADING -> {
                                mViewObserver.setProgressLoaderVisibility(true)
                            }
                        }
                })


        } else {
            Timber.i("loadPopularList no network  ")


            Utils.showTopSnackBar(
                appBar,
                getString(R.string.oops_no_network)

            )
        }
        mViewObserver.getEmployeeListAdapter().setEmployeeList { employeeListItem ->
            employeeListItem?.let {
                mViewModel.setEmployee(it)
            }
            findNavController().navigate(R.id.action_employeeListPageFragment_to_employeeProfilePageFragment)
        }

    }


    /**
     * Function to handle different button clicks
     */

    private fun loadButtonFunctionality() {

        llWhiteButton.setRxOnClickListener {
            activity!!.finish()
        }

    }
}
