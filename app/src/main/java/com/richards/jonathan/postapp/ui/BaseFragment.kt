package com.richards.jonathan.postapp.ui

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    lateinit var activity: MainActivity

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as MainActivity
    }
}