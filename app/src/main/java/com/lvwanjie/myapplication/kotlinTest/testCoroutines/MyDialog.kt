package com.lvwanjie.myapplication.kotlinTest.testCoroutines

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.lvwanjie.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CancelJobDialog() : DialogFragment(), CoroutineScope by MainScope() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return inflater.inflate(R.layout.dialog_cancel_job, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val mNoTv = view.findViewById<Button>(R.id.btn_n)
        val mYesTv = view.findViewById<Button>(R.id.btn_p)

        mNoTv.click {
            dismiss()
        }

        mYesTv.click {
            doSth()
        }

    }

    private fun doSth() {

        launch {

            println("执行在另一个协程中...")

            delay(1000L)

            println("另一个协程执行完毕...")
        }

        dismiss()
    }

    override fun onDismiss(dialog: DialogInterface) {
        cancel()
        super.onDismiss(dialog)
    }
}

private fun Button.click(function: () -> Unit) {
    setOnClickListener { function }

}
