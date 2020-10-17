package com.friendscircle.app

import android.app.Application
import com.common.core.AppContext

/**
 * author : taowang
 * date :2020/10/11
 * description:
 **/

class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        AppContext.getInstance().init(this)
    }
}

