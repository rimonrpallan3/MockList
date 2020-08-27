package com.example.mocklist.managers

import android.content.Context

class SessionManager(mContext: Context) : BaseManager<SessionManager>(mContext, SessionManager::class.java) {

    private val mSessionId = "SessionId"

    fun sessionLogout() {
        removeKey(mSessionId)
    }

    /**
     * fun authentication id or api token
     */
    fun getSessionId() = getSharedPreferences().getString(mSessionId, "")

}