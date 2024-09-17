package com.lvwanjie.myapplication.kotlinTest.testCoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CoroutineViewModel : ViewModel(){

    public fun a(){
        viewModelScope.launch {
            var a = 0
            if (3.also { a = it } > 0) {
            }
        }


    }
}