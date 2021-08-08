package com.vickykdv.mystockbit.view.login

import android.os.Bundle
import android.view.View
import com.vickykdv.mystockbit.base.BaseActivity
import com.vickykdv.mystockbit.databinding.ActivityLoginBinding
import com.vickykdv.mystockbit.extension.ExtentionUtils.onClick
import com.vickykdv.mystockbit.extension.ExtentionUtils.openActivity
import com.vickykdv.mystockbit.extension.ExtentionUtils.showToast
import com.vickykdv.mystockbit.view.main.MainPage
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {
    private val TAG = "LOGINACTIVITY"
    private val viewModel : LoginViewModel by viewModel()

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun setLayout(): View {
        return binding.root
    }

    override fun onCreateActivity(savedInstanceState: Bundle?) {
        setupObservable()
        setView()
    }

    private fun setView(){
        with(binding){
            btnLogin.setOnClickListener {
               login()
            }

            btnFaceBook.onClick {
                showToast("Facebook")
            }

            btnGoogle.onClick {
                showToast("Google")
            }

            btnFinger.onClick {
                showToast("Login with finger")
            }

            txtForgotPass.onClick {
                showToast("Forgot Pass")
            }

            imgCallCenter.onClick {
                showToast("Call Center")
            }

            lnRegisterNow.onClick {
                showToast("Register Sekarang")
            }
        }
    }

    private fun login(){
        with(binding){
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            if(email.isEmpty()){ viewModel.isValid.value = false
            }else viewModel.isValid.value = password.isNotEmpty()

        }
    }

    private fun setupObservable(){
        viewModel.isValid.observe(this,{
            if(it){
                openActivity(MainPage::class.java,true)
            }else{
                showToast("Email dan Password wajib di isi")
            }
        })
    }



}