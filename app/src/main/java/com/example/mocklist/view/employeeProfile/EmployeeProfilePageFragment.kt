package com.example.mocklist.view.employeeProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mocklist.R
import com.example.mocklist.databinding.FragmentEmployeeListBinding
import com.example.mocklist.databinding.FragmentEmployeeProfileBinding
import com.example.mocklist.databinding.FragmentFlowBinding
import com.example.mocklist.model.EmployeeListItem
import com.example.mocklist.utils.NetworkStatus
import com.example.mocklist.utils.Utils
import com.example.mocklist.utils.setRxOnClickListener
import com.example.mocklist.view.BaseFragment
import com.example.mocklist.viewmodel.employeeListPage.EmployeeListPageViewModel
import com.example.mocklist.viewobservers.employeeListPageViewObserver.EmployeeListPageViewObserver
import com.example.mocklist.viewobservers.employeeProfilePageViewObserver.EmployeeProfilePageViewObserver
import com.example.mocklist.viewobservers.loadImagefromURL
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.employee_list_item.*
import kotlinx.android.synthetic.main.fragment_employee_list.*
import kotlinx.android.synthetic.main.fragment_employee_profile.*
import kotlinx.android.synthetic.main.fragment_employee_profile.tvName
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import timber.log.Timber
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class EmployeeProfilePageFragment : BaseFragment() {

    private var mViewObserver = EmployeeProfilePageViewObserver()
    private val mViewModel: EmployeeListPageViewModel by sharedViewModel()
    private lateinit var mEmployeeListItem: EmployeeListItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEmployeeProfileBinding.inflate(inflater, container, false)
        binding.data = mViewObserver
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.getEmployee().observe(this, Observer { data ->
            tvAppBarHeading.setText("Employee Profile")
            ivSearchListIcon.visibility = View.GONE

            mEmployeeListItem = data

            loadImagefromURL(ivEmpImg,mEmployeeListItem.profile_image)
            tvName.text = "Name : "+mEmployeeListItem?.name
            tvAddress.text ="Address : "+mEmployeeListItem?.address?.street+", "+mEmployeeListItem?.address?.city
            tvCompanyDetails.text = "Company Name : "+mEmployeeListItem?.company?.name
            tvEmail.text = "Email : "+mEmployeeListItem?.email
            tvUserName.text = "UserName : "+mEmployeeListItem?.username
            tvPhoneNo.text = "Phone No : "+mEmployeeListItem?.phone
            tvWebsite.text = "WebSite Address : "+mEmployeeListItem?.website

            Timber.i("onViewCreated mViewModel username is :${mEmployeeListItem.name}")
            System.out.println("onViewCreated mViewModel username is :${mEmployeeListItem.name}")

        })

        loadButtonFunctionality()
    }

    override fun onResume() {
        super.onResume()
    }




    /**
     * Function to handle different button clicks
     */

    private fun loadButtonFunctionality() {
        llWhiteButton.setRxOnClickListener {
            findNavController().navigateUp()
        }

    }
}
