package com.example.mocklist.view.otpPage

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mocklist.databinding.FragmentOtpPageBinding
import com.example.mocklist.view.BaseFragment
import com.example.mocklist.viewmodel.otpPage.OtpPageViewModel
import com.example.mocklist.viewobservers.otpPageViewObserver.OtpPageViewObserver
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class OtpFragment : BaseFragment() {

    private var mViewObserver = OtpPageViewObserver()
    private val mViewModel: OtpPageViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOtpPageBinding.inflate(inflater, container, false)
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
       /* bottomSheet.etOTP1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {

                beforetextfirst = "" + charSequence
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


                if (bottomSheet.etOTP1.text.toString().isNotEmpty()) {

                    val text = "" + p0
                    if (text.length > 1) {
                        val last = "" + p0?.get(1)
                        bottomSheet.etOTP1.removeTextChangedListener(this)
                        if (beforetextfirst != last)
                            bottomSheet.etOTP1.setText(last)
                        else
                            bottomSheet.etOTP1.setText("" + p0?.get(0))
                        bottomSheet.etOTP1.addTextChangedListener(this)

                    }
                    bottomSheet.etOTP2.requestFocus()

                }

            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })


        bottomSheet.etOTP2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                beforetextsecond = "" + charSequence

            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (bottomSheet.etOTP2.getText().toString().isNotEmpty()) {

                    val text = "" + charSequence
                    if (text.length > 1) {
                        val last = "" + charSequence?.get(1)
                        bottomSheet.etOTP2.removeTextChangedListener(this)
                        if (beforetextsecond != last)
                            bottomSheet.etOTP2.setText(last)
                        else
                            bottomSheet.etOTP2.setText("" + charSequence?.get(0))
                        bottomSheet.etOTP2.addTextChangedListener(this)

                    }
                    bottomSheet.etOTP3.requestFocus()

                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })


        bottomSheet.etOTP3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                beforetextthird = "" + charSequence

            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (bottomSheet.etOTP3.text.toString().isNotEmpty()) {

                    val text = "" + charSequence
                    if (text.length > 1) {
                        val last = "" + charSequence?.get(1)
                        bottomSheet.etOTP3.removeTextChangedListener(this)
                        if (beforetextthird != last)
                            bottomSheet.etOTP3.setText(last)
                        else
                            bottomSheet.etOTP3.setText("" + charSequence?.get(0))
                        bottomSheet.etOTP3.addTextChangedListener(this)

                    }
                    bottomSheet.etOTP4.requestFocus()

                } else {
                    len2 = 0
                }


            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        bottomSheet.etOTP4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                beforetextfourth = "" + charSequence

            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (bottomSheet.etOTP4.text.toString().isNotEmpty()) {

                    val text = "" + charSequence
                    if (text.length > 1) {
                        val last = "" + charSequence?.get(1)
                        bottomSheet.etOTP4.removeTextChangedListener(this)
                        if (beforetextfourth != last)
                            bottomSheet.etOTP4.setText(last)
                        else
                            bottomSheet.etOTP4.setText("" + charSequence?.get(0))
                        bottomSheet.etOTP4.addTextChangedListener(this)

                    }
                    bottomSheet.etOTP5.requestFocus()

                } else {
                    len3 = 0
                }


            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        bottomSheet.etOTP5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                beforetextfifth = "" + charSequence

            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (bottomSheet.etOTP5.text.toString().isNotEmpty()) {

                    val text = "" + charSequence
                    if (text.length > 1) {
                        val last = "" + charSequence?.get(1)
                        bottomSheet.etOTP5.removeTextChangedListener(this)
                        if (beforetextfifth != last)
                            bottomSheet.etOTP5.setText(last)
                        else
                            bottomSheet.etOTP5.setText("" + charSequence?.get(0))
                        bottomSheet.etOTP5.addTextChangedListener(this)

                    }
                    bottomSheet.etOTP6.requestFocus()

                } else {
                    len4 = 0
                }


            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        bottomSheet.etOTP6.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                beforetextsixth = "" + charSequence

            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (bottomSheet.etOTP6.text.toString().length > 0) {

                    bottomSheet.etOTP6.setSelection(bottomSheet.etOTP6.text.toString().length)

                    bottomSheet.btnForwardButton.setImageResource(R.drawable.ic_arrow_forward)
                    bottomSheet.btnForwardButton.isEnabled = true

                } else {
                    len5 = 0

                    bottomSheet.btnForwardButton.setImageResource(R.drawable.ic_arrow_forward_opacity)
                    bottomSheet.btnForwardButton.isEnabled = false

                }


            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        bottomSheet.etOTP6.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                //this is for backspace

                if (bottomSheet.etOTP6.text.toString() == "" && len6 == 0) {
                    bottomSheet.etOTP5.requestFocus()
                    bottomSheet.etOTP5.setText("")
                    backspace_fifth = 1

                }
                len6 = 0

            } else {

                if (event.action == KeyEvent.ACTION_DOWN) {
                    backspace_sixth = 0
                    if (event.action != KeyEvent.FLAG_EDITOR_ACTION) {
                        len6++
                    }

                }

            }
            false
        })

        bottomSheet.etOTP5.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                //this is for backspace

                if (bottomSheet.etOTP5.text.toString() == "" && len5 == 0) {
                    bottomSheet.etOTP4.requestFocus()
                    bottomSheet.etOTP4.setText("")
                    backspace_fourth = 1

                }
                len5 = 0

            } else {

                if (event.action == KeyEvent.ACTION_DOWN) {
                    backspace_fifth = 0
                    if (event.action != KeyEvent.FLAG_EDITOR_ACTION) {
                        len5++
                    }

                }

            }
            false
        })

        bottomSheet.etOTP4.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                //this is for backspace

                if (bottomSheet.etOTP4.text.toString() == "" && len4 == 0) {
                    bottomSheet.etOTP3.requestFocus()
                    bottomSheet.etOTP3.setText("")
                    backspace_third = 1

                }
                len4 = 0

            } else {

                if (event.action == KeyEvent.ACTION_DOWN) {
                    backspace_fourth = 0
                    if (event.action != KeyEvent.FLAG_EDITOR_ACTION) {
                        len4++
                    }

                }

            }
            false
        })

        bottomSheet.etOTP3.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                //this is for backspace

                if (bottomSheet.etOTP3.getText().toString() == "" && len3 == 0) {
                    bottomSheet.etOTP2.requestFocus()
                    bottomSheet.etOTP2.setText("")
                    backspace_second = 1


                }
                len3 = 0
            } else {
                if (event.action == KeyEvent.ACTION_DOWN) {
                    backspace_third = 0
                    len3++
                }

            }
            false
        })

        bottomSheet.etOTP2.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL) {
                //this is for backspace

                if (bottomSheet.etOTP2.getText().toString() == "" && len2 == 0) {
                    bottomSheet.etOTP1.requestFocus()
                    bottomSheet.etOTP1.setText("")
                    backspace_first = 1

                }
                len2 = 0

            } else {
                if (event.action == KeyEvent.ACTION_DOWN) {
                    backspace_second = 0
                    len2++
                }

            }
            false
        })*/

    }

    /**
     * Function to handle different button clicks
     */

    private fun loadButtonFunctionality(){


    }


}