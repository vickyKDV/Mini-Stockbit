package com.vickykdv.mystockbit.view.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.vickykdv.mystockbit.R
import com.vickykdv.mystockbit.base.BaseActivity
import com.vickykdv.mystockbit.databinding.ActivityMainPageBinding
import com.vickykdv.mystockbit.extension.ExtentionUtils.onClick
import com.vickykdv.mystockbit.extension.ExtentionUtils.showToast

class MainPage : BaseActivity() {

    private val binding by lazy {
        ActivityMainPageBinding.inflate(layoutInflater)
    }

    override fun setLayout(): View {
        return binding.root
    }

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        setView()
    }

    private fun setView(){
        with(binding) {
            val navView: BottomNavigationView = navView
            val navController = findNavController(R.id.nav_host_fragment_activity_main_page)
            navView.setupWithNavController(navController)

            imgBack.onClick {
                onBackPressed()
            }

            imgPaper.onClick {
                showToast("History")
            }
        }
    }

}