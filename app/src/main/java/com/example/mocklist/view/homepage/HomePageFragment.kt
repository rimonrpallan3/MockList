package com.example.mocklist.view.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bigvand.surfboard.utils.setRxOnClickListener
import com.bigvand.surfboard.utils.setRxOnEditTextChangeAfter
import com.bigvand.surfboard.view.BaseFragment
import com.example.mocklist.databinding.FragmentHomePageBinding
import com.example.mocklist.model.Content
import com.example.mocklist.viewmodel.homepage.HomePageViewModel
import com.example.mocklist.viewobservers.homePageViewObserver.HomePageViewObserver
import kotlinx.android.synthetic.main.appbar_layout.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HomePageFragment : BaseFragment() {


    private var mViewObserver = HomePageViewObserver()
    private val mViewModel: HomePageViewModel by sharedViewModel()
    private var mContent:List<Content> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomePageBinding.inflate(inflater, container, false)
        binding.data = mViewObserver
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadButtonFunctionality()
        loadData()
    }

    fun loadData(){
        mViewModel.getMyDataImageList().observe(this, Observer {page ->
            mViewObserver.setImgList(page.content_items.content)
            tvAppBarHeading.setText(page.title)

        })
    }

    fun loadButtonFunctionality(){
        ivSearchListIcon.setRxOnClickListener {
            llWhiteButton.visibility = View.GONE
            tvAppBarHeading.visibility = View.GONE
            etSearchListView.visibility = View.VISIBLE
            ivSearchListIcon.visibility = View.GONE

        }
        etSearchListView.setRxOnEditTextChangeAfter {

        }

        etSearchListView.setOnTouchListener(OnTouchListener { v, event ->
            val DRAWABLE_LEFT = 0
            val DRAWABLE_TOP = 1
            val DRAWABLE_RIGHT = 2
            val DRAWABLE_BOTTOM = 3
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= etSearchListView.getRight() - etSearchListView.getCompoundDrawables()
                        .get(DRAWABLE_RIGHT).getBounds().width()
                ) {
                    // your action here
                    ivSearchListIcon.visibility = View.VISIBLE
                    llWhiteButton.visibility = View.VISIBLE
                    tvAppBarHeading.visibility = View.VISIBLE
                    etSearchListView.visibility = View.GONE
                    return@OnTouchListener true
                }
            }
            false
        })


    }


}