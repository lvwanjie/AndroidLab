package com.lvwanjie.myapplication.kotlinTest.testCoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class CoroutineViewModel : ViewModel(){

    public fun a(){
        viewModelScope.launch {

        }
    }
}