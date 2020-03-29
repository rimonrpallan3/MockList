import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.text.TextUtils
import android.util.Patterns
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidadvance.topsnackbar.TSnackbar
import com.example.mocklist.R
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber
import java.io.File
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern
import java.util.logging.Logger


object Utils {

    /**
     * Method to hide softkeyboard
     *
     * @param activity
     */
    fun hideKeyboard(activity: Activity) {
        activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        val inputMethodManager =
            activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = activity.currentFocus
        if (view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun validateUserName(context: Context?,getTxt: String?,txtError: AppCompatTextView): Boolean {
        var isTxtValid = false
        if (getTxt?.isEmpty()!!){
            txtError.visibility = View.VISIBLE
            //txtError.text = context?.getString(R.string.field_null)
        }
        else if (getTxt.length < 2){
            txtError.visibility = View.VISIBLE
           // txtError.text = context?.getString(R.string.full_name_validation_min)
        }else if (getTxt.length > 25){
            txtError.visibility = View.VISIBLE
           // txtError.text = context?.getString(R.string.full_name_validation_max)
        }else{
            txtError.visibility = View.GONE
            isTxtValid = true
        }
        return isTxtValid
    }

    fun validateLetters(txt: String?): Boolean {
        val regx = "[a-zA-Z]+\\.?"
        val pattern =
            Pattern.compile(regx, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(txt)
        return matcher.find()
    }

    fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    fun showSnackBar(view: View, text: String) {
        val snackbar = Snackbar
            .make(view, text, Snackbar.LENGTH_LONG)
        val snackBarView = snackbar.view
        snackBarView.setBackgroundColor(Color.parseColor("#FF6363"))
        val textView = snackBarView.findViewById<TextView>(R.id.snackbar_text)
        textView.setTextColor(Color.WHITE)
        snackbar.show()
    }

    fun showToast(text: String, context: Context, duration: Int) {
        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }

    fun showTopSnackBar(view: View, text: String) {
        val snackbarLayout = TSnackbar
            .make(view, text, TSnackbar.LENGTH_LONG)
        snackbarLayout.setMaxWidth(3000)
        val snackBarView = snackbarLayout.view
        snackBarView.setBackgroundColor(Color.parseColor("#FFBB7C"))
        val textView = snackBarView.findViewById<TextView>(R.id.snackbar_text)
        textView.setTextColor(Color.WHITE)
        snackbarLayout.show()
    }

/*    fun simpleValidationDialog(text: String, context: Context) {
        val dialog = Dialog(context, android.R.style.Theme_Dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //dialog.setContentView(R.layout.validation_layout)
        dialog.setCanceledOnTouchOutside(true)
        dialog.window?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    context,
                    R.color.transparent
                )
            )
        )
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setGravity(Gravity.TOP)
        dialog.txtViewTitle.text = text
        dialog.rlImViewClose.setRxOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }*/

  /*  fun simpleInfoDialog(text: String, context: Context) {
        val dialog = Dialog(context, android.R.style.Theme_Dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.snackbar_info_layout)
        dialog.setCanceledOnTouchOutside(true)
        dialog.window?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    context,
                    R.color.transparent
                )
            )
        )
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setGravity(Gravity.TOP)
        dialog.txtViewTitle.text = text
        dialog.rlImViewClose.setRxOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }*/

    @Throws(ParseException::class)
    fun getDateFromString(dateString: String): Date? {
        val fmt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        fmt.timeZone = TimeZone.getTimeZone("UTC")
        return fmt.parse(dateString)
    }


    @Throws(ParseException::class)
    fun getDateFromStringToString(dateString: String?): String? {
        return if (!dateString.isNullOrEmpty()) {
            val fmt = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            fmt.timeZone = TimeZone.getTimeZone("UTC")
            SimpleDateFormat("EEE,dd MMM").format(fmt.parse(dateString) ?: "")
        } else {
            ""
        }
    }


    fun getFormattedDateFromApiString(dateString: String?): String? {
        dateString?.let {
            val date = getDateFromString(dateString)
            return DateFormat.getDateInstance().format(date)
        }
        return null
    }

     fun getFormattedTime(dateString: String?): String? {
        dateString?.let {
            return if(dateString.isNotEmpty()){
                val date = getDateFromString(dateString)
                // return DateFormat.getTimeInstance().format(date)
                SimpleDateFormat("HH:MM").format(date)
            }else{
                null
            }

        }
        return null
    }



    fun getImageBaseUrlImagePolicy(BaseUrl : String?,ImagePolicy : String?,ImageUrl : String?) :String{
        val imageUrl = "$BaseUrl $ImagePolicy $ImageUrl"
        return if (BaseUrl.isNullOrEmpty() || ImagePolicy.isNullOrEmpty()) {
            ""
        } else {
            imageUrl
        }
    }






}
