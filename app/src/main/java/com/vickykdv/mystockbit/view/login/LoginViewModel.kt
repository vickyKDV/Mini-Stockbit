package com.vickykdv.mystockbit.view.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vickykdv.mystockbit.utils.SingleLiveEvent

class LoginViewModel:ViewModel() {
    val onToast = MutableLiveData<Boolean>()
    val isValid = MutableLiveData<Boolean>()

}