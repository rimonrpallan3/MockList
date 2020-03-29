package com.example.mocklist

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.P
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.SvgDecoder
import coil.util.CoilUtils
import com.bigvand.surfboard.injection.appModule
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber


/**
 * The application level class
 */
class App : Application() {

//    private var mNotificationCountLiveData =
//        MutableLiveData<UnreadNotificationMessageCount>()

    /**
     * On application created
     */
    override fun onCreate() {
        super.onCreate()
        setupCoil()
        setupKoin()
        setupDebuggingLogging()
        //setupCrashAnalytics()
        createAppNotificationChannel()




    }

    private fun createAppNotificationChannel() {
        if (SDK_INT >= Build.VERSION_CODES.O) {
          /*  val serviceChannel = NotificationChannel(
                AppConstants.UPLOAD_VIDEO_NOTIFICATION_CHANNEL_ID,
                getString(R.string.posting),
                NotificationManager.IMPORTANCE_NONE
            )
            serviceChannel.enableVibration(false)
            serviceChannel.setShowBadge(false)
            if (SDK_INT >= Build.VERSION_CODES.Q) {
                serviceChannel.setAllowBubbles(false)
            }
            val manager =
                getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)*/
        }
    }

    private fun setupCoil() {
        mCoilImageLoader = ImageLoader(this) {
            componentRegistry {
                if (SDK_INT >= P) {
                    add(SvgDecoder(this@App))
                } else {
                    add(GifDecoder())
                }

            }
            okHttpClient {
                OkHttpClient.Builder()
                    .cache(CoilUtils.createDefaultCache(this@App))
                    .build()
            }
        }
    }


//    private fun setupCrashAnalytics() {
//        Fabric.with(this, Crashlytics())
//    }

    /**
     * Setup the dependency injection in application level using koin lib
     */
    private fun setupKoin() {
        startKoin {
            if (BuildConfig.DEBUG)
                androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(appModule())
        }
    }

    companion object {
        private lateinit var mCoilImageLoader: ImageLoader
        val coilImageLoader: ImageLoader get() = mCoilImageLoader
    }


    /**
     * Debug on chrome
     */
    private fun setupDebuggingLogging() {
       /* if (BuildConfig.DEBUG) {
            setupStethoInspectionLogging(this)
            Timber.plant(Timber.DebugTree())
        }*/
    }




    /*private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support libraryCHANNEL_ID
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.default_notification_channel_id)
            val descriptionText = getString(R.string.app_name)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun setNotificationCount(notificationCountResources: UnreadNotificationMessageCount) {
        mNotificationCountLiveData.postValue(notificationCountResources)
    }

    fun getNotificationCount(): LiveData<UnreadNotificationMessageCount> =
        mNotificationCountLiveData*/
}