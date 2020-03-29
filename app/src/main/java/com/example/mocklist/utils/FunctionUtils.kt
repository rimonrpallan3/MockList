package com.bigvand.surfboard.utils

import android.content.ContentResolver
import android.content.Context
import android.content.res.Resources
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Environment
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.mocklist.R
import com.example.mocklist.utils.AppConstants
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit


fun View.setRxOnClickListener(function: () -> Unit): Disposable {
    return RxView.clicks(this)
        .throttleFirst(AppConstants.BUTTON_THROTTLE, TimeUnit.MILLISECONDS)
        .subscribe {
            function()
        }
}

fun AutoCompleteTextView.setRxOnTextChangeAfter(function: (String) -> Unit): Disposable {
    return RxTextView.afterTextChangeEvents(this)
        .throttleLast(AppConstants.BUTTON_THROTTLE, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .skip(1)
        .subscribe {
            it.editable()?.let { editable ->
                function(editable.toString())
            }
        }
}

fun EditText.setRxOnEditTextChangeAfter(function: (String) -> Unit): Disposable {
    return RxTextView.afterTextChangeEvents(this)
        .throttleLast(AppConstants.BUTTON_THROTTLE, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .skip(1)
        .subscribe {
            it.editable()?.let { editable ->
                function(editable.toString())
            }
        }
}


/**
 * Fun to call API and shown Error dialog easily
 **/
/*
fun networkCallWithRetry(function: (ConnectionErrorMessageDialogFragment) -> Unit) {
    val errorDialog = ConnectionErrorMessageDialogFragment()
    errorDialog.setRetry { function(errorDialog) }
    function(errorDialog)
}
*/

/**
 * Snapshot position
 */
fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
    val layoutManager = recyclerView.layoutManager ?: return RecyclerView.NO_POSITION
    val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
    return layoutManager.getPosition(snapView)
}

/**
 * get the pictures directory that's inside the app-specific directory on
 */
fun getAppSpecificAlbumStorageDir(context: Context, albumName: String): File? {
    val file =
        if (isExternalStorageWritable()) {
            File(context.getExternalFilesDir(Environment.DIRECTORY_DCIM), albumName)
        } else {
            File(
                context.getExternalFilesDir(
                    context.getString(R.string.app_name)
                ), albumName
            )
        }
    if (!file.mkdirs()) {
        Timber.d("Directory not created")
    }
    return file
}

/**
 * Checks if a volume containing external storage is available
 * for read and write.
 */
fun isExternalStorageWritable(): Boolean {
    return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
}

fun getFullUrl(basePath: String, path: String, policy: String): String =
    "https://$basePath/$path$policy"

/**
 * get to kown is the device have onscreen navbar
 */
fun hasNavBar(resources: Resources): Boolean {
    val id: Int = resources.getIdentifier("config_showNavigationBar", "bool", "android")
    return id > 0 && resources.getBoolean(id)
}

/**
 * get to kown is the device have onscreen navbar
 */
fun navBarHeight(resources: Resources): Int {
    val id: Int = resources.getIdentifier("navigation_bar_height", "dimen", "android");
    if (id > 0) {
        return resources.getDimensionPixelSize(id);
    }
    return 0;
}

/**
 * get duration of video in mili sec
 */
fun getVideoDurationInMillSec(context: Context, videoUri: Uri): Long {
    val retriever = MediaMetadataRetriever()
    //use one of overloaded setDataSource() functions to set your data source
    retriever.setDataSource(context, videoUri)
    val time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
    retriever.release()
    return time.toLong()
}

suspend fun Uri.copyTo(resolver: ContentResolver, file: File) {
    val inputStream = resolver.openInputStream(this)!!
    val outputStream = file.outputStream()
    val buffer = ByteArray(1024)
    while (true) {
        val length = inputStream.read(buffer)
        if (length <= 0)
            break
        outputStream.write(buffer, 0, length)
    }
}

suspend fun File.copyTo(resolver: ContentResolver, uri: Uri) {
    val writeStream = resolver.openOutputStream(uri)
    val inputStream = this.inputStream()
    val buffer = ByteArray(1024)
    while (true) {
        val length = inputStream.read(buffer)
        if (length <= 0)
            break
        writeStream!!.write(buffer, 0, length)
    }
}


/**
 * get Followers status to check whether whether the requesteeid follow the requestorId
 */
  fun getFollowStatus(id:Int,followList:List<String>):Boolean {
    return followList.contains(id.toString())

}



