package com.richards.jonathan.postapp

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.github.tmurakami.dexopener.DexOpener

class PostAppRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        DexOpener.install(this)
        System.setProperty("org.mockito.android.target", context!!.cacheDir.absolutePath)
        return super.newApplication(cl, className, context)
    }

}