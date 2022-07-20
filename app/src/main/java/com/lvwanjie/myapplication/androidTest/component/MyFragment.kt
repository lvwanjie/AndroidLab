package com.lvwanjie.myapplication.androidTest.component

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lvwanjie.myapplication.R

class MyFragment :Fragment(){

    companion object{
        fun newInstance(type:String):MyFragment{
            val bundle = Bundle()
            bundle.putString("type",type)
            val listFragment = MyFragment()
            listFragment.arguments = bundle
            return listFragment
        }

        fun newInstance(): MyFragment {
            return MyFragment()
        }

        const val TAG = "ListFragment"
    }

    private var type:String? = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "$type  onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "$type onCreateView: ")
        return inflater.inflate(R.layout.fragment_layout,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "$type onActivityCreated: ")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(TAG, "$type onViewCreated: ")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Log.i(TAG, "$type onStart: ")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG, "$type onResume: ")
        super.onResume()
    }

    override fun onPause() {
        Log.i(TAG, "$type onPause: ")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "$type onStop: ")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.i(TAG, "$type onDestroyView: ")
        super.onDestroyView()
    }


    override fun onDestroy() {
        Log.i(TAG, "$type onDestroy: ")
        super.onDestroy()
    }
}