package com.bigvand.surfboard.managers

import android.content.Context

class SessionManager(mContext: Context) :
    BaseManager<SessionManager>(mContext, SessionManager::class.java) {

    private val mSessionId = "SessionId"
    private val mUserId = "UserId"
    private val mIsUserLogin = "IsUserLogin"
    private val mIsUserPassBioPage = "IsUserPassBioPage"
    private val mIsUserPassUniversityRegisterPage = "IsUserPassUniversityRegisterPage "
    private val mLatitude = "Latitide"
    private val mLongitude = "Longitude"
    private val mRange = "Range"
    private val mLocationAddress = "locationAddress"
    private val mIsUniversityUser = "IsUniversityUser"
    private  val mTheme = "theme"


    fun setUserDetailsNew(
        sessionId: String?,
        userId: Long?,
        isLogged: Boolean
    ) {
        save {

            sessionId?.let {
                putString(mSessionId, sessionId)
            }
            userId?.let {
                putLong(mUserId, userId)
            }
            putBoolean(mIsUserLogin, isLogged)
        }
    }


    fun setSessionId(sessionId: String) {
        save {

            sessionId?.let {
                putString(mSessionId, sessionId)
            }
        }
    }
    fun clearSessionId() {
        save {
                putString(mSessionId, "")

        }
    }



    fun setLocation(
        latitude: String?,
        longitude: String?,
        range: Int?
    ) {
        save {
            latitude?.let {
                putString(mLatitude, latitude)
            }
            longitude?.let {
                putString(mLongitude, longitude)
            }
            range?.let {
                putInt(mRange, range)
            }

        }
    }
    fun setLocation(
        latitude: String?,
        longitude: String?) {
        save {
            latitude?.let {
                putString(mLatitude, latitude)
            }
            longitude?.let {
                putString(mLongitude, longitude)
            }

        }
    }

    fun setTheme(theme:Int)
    {
        save { putInt(mTheme, theme) }
    }

    fun setUserLogin(isLogged: Boolean) {
        save { putBoolean(mIsUserLogin, isLogged) }
    }

    fun setUserPassedBioPage(isBioPass: Boolean) {
        save { putBoolean(mIsUserPassBioPage, isBioPass) }
    }

    fun setUserPassedUniversityRegisterPage(isURPass: Boolean) {
        save { putBoolean(mIsUserPassUniversityRegisterPage, isURPass) }
    }

    fun setUniversityUserLogin(isUniversityUser: Boolean) {
        save { putBoolean(mIsUniversityUser, isUniversityUser) }
    }


    fun getUserId() = getSharedPreferences().getLong(mUserId, 0)

    /**
     * fun to know is user already login
     */
    fun isUserLogin() = getSharedPreferences().getBoolean(mIsUserLogin, false)

    /**
     * fun to know is Bio page is skipped or set after login
     */
    fun isUserPassedBioPage() = getSharedPreferences().getBoolean(mIsUserPassBioPage, false)

    /**
     * fun to know is University register page is skipped or set after login and passing bio page
     */
    fun isUserPassedUniversityRegisterPage() = getSharedPreferences().getBoolean(mIsUserPassUniversityRegisterPage, false)

    /**
     * fun authentication id or api token
     */
    fun getSessionId() = getSharedPreferences().getString(mSessionId, "")

    /**
     * fun get latitude
     */
    fun getLatitude() = getSharedPreferences().getString(mLatitude, null)

    /**
     * fun get longitude
     */
    fun getLongitude() = getSharedPreferences().getString(mLongitude, null)

    /**
     * fun get range
     */
    fun getRange() = getSharedPreferences().getInt(mRange, 5)


    /**
     * get last location address
     */
    fun getLastKnowLocationAddress(): String? =
        getSharedPreferences().getString(mLocationAddress, null)

    /**
     * get last location address
     */
    fun setLastKnowLocationAddress(location:String){
        save {
            putString(mLocationAddress,location)
        }
    }



    /**
     * fun to know is University User already login
     */
    fun isUniversityUserLogin() = getSharedPreferences().getBoolean(mIsUniversityUser, false)


    /**
     * fun get Theme
     */
    fun getTheme()=getSharedPreferences().getInt(mTheme, 0)




}