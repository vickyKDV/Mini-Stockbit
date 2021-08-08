package com.vickykdv.mystockbit.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment:Fragment() {

    private var mContext: Context? = null
    private lateinit var mBaseActivity: BaseActivity
    private var mInflater: LayoutInflater? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = activity
        if (context is BaseActivity) {
            mBaseActivity = mContext as BaseActivity
            mInflater = LayoutInflater.from(mBaseActivity)
        } else {
            throw ClassCastException("The activity is not child of BaseActivity")
        }
    }

    abstract fun setLayout(): View

    abstract fun onCreateActivity(savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return setLayout()
    }

}