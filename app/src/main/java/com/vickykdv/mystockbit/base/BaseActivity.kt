package com.vickykdv.mystockbit.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity() {

    private var mInflater: LayoutInflater? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        mInflater = LayoutInflater.from(this)
        onCreateActivity(savedInstanceState)

    }


    abstract fun setLayout() : View

    abstract fun onCreateActivity(savedInstanceState: Bundle?)


}