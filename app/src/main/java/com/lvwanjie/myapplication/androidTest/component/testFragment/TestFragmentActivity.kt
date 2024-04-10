package com.lvwanjie.myapplication.androidTest.component.testFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lvwanjie.myapplication.R

class TestFragmentActivity : AppCompatActivity() {

    private var fragment: Fragment = MyFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_fragment)
    }

    fun btAdd(view: View){
        supportFragmentManager.beginTransaction().add(R.id.fl_con,fragment).commit()
    }

    fun btHid(view: View){
        supportFragmentManager.beginTransaction().hide(fragment).commit()

    }

    fun btShow(view: View){
        supportFragmentManager.beginTransaction().show(fragment).commit()

    }
    fun btAttach(view: View){
        supportFragmentManager.beginTransaction().attach(fragment).commit()

    }
    fun btDetach(view: View){
        supportFragmentManager.beginTransaction().detach(fragment).commit()
    }

    fun btRemove(view: View){
        supportFragmentManager.beginTransaction().remove(fragment).commit()
    }


}