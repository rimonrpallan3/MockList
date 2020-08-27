package com.example.mocklist.repository.api

import android.content.Context
import android.content.Intent
import com.example.mocklist.BuildConfig
import com.example.mocklist.managers.SessionManager
import com.example.mocklist.utils.AppConstants
import com.example.mocklist.utils.LiveDataCallAdapterFactory
import com.example.mocklist.view.homepage.HomePageActivity
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


/**
 * Retrofit API Library builder class
 */
class RestApiService(private val mSessionManager: SessionManager, private val mContext: Context) {

    /**
     * Retrofit singleton instance builder
     */
    fun getRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(AppConstants.API_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(getGsonConverterFactory())
            .client(getClient())
            .build()

    /**
     * Json Response converter
     */
    private fun getGsonConverterFactory(): GsonConverterFactory {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return GsonConverterFactory.create(gson)
    }

    /**
     * Log API Calls
     */
    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    /**
     * Add api header interceptors
     */
    private fun getClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .writeTimeout(260, TimeUnit.SECONDS)
            .readTimeout(260, TimeUnit.SECONDS)
            .connectTimeout(260, TimeUnit.SECONDS)
        builder.addInterceptor { chain -> intercept(chain) }
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(getLoggingInterceptor())
            builder.addNetworkInterceptor(com.facebook.stetho.okhttp3.StethoInterceptor())
        }
        return builder.build()
    }

    /**
     * Set accesstoken to header
     */
    @Throws(IOException::class)
    fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()

        // Request customization: add request headers

        var requestBuilder: Request.Builder = original.newBuilder()
        mSessionManager.getSessionId()?.let {
            requestBuilder = original.newBuilder()
                .header("Authorization", it) // <-- this is the important line
        }

        val request: Request = requestBuilder.build()
        val response = chain.proceed(request)
        if (handleError(response)) {
            chain.call().cancel()
        }
        return response
    }

    private fun handleError(response: Response): Boolean {
        if (response.code() == 401) {
            mSessionManager.sessionLogout()
            mContext.startActivity(Intent(mContext, HomePageActivity::class.java).apply {
                flags =
                    Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION
            })
            return true
        }
        return false
    }

    /**
     * Build API call EndPoints
     */
    fun <T> create(retrofit: Retrofit, service: Class<T>): T {
        return retrofit.create(service)
    }


}
