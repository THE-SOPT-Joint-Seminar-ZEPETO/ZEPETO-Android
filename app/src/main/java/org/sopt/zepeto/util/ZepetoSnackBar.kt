package org.sopt.zepeto.util

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import org.sopt.zepeto.databinding.LayoutCompleteSnackBarBinding

class ZepetoSnackBar(view: View) {

    companion object {
        fun make(view: View) = ZepetoSnackBar(view)
    }

    private val context = view.context
    private val snackBar = Snackbar.make(view, "", 2300)
    private val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout
    private val layoutParams = snackBarLayout.layoutParams as FrameLayout.LayoutParams
    private val snackBarBinding =
        LayoutCompleteSnackBarBinding.inflate(LayoutInflater.from(context), null, false)

    init {
        initView()
    }

    private fun initView() {
        layoutParams.gravity = Gravity.TOP
        with(snackBarLayout) {
            removeAllViews()
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            addView(snackBarBinding.root, 0)
        }
    }

    fun addCallBack(
        onShown: (() -> Unit)? = null,
        onDismiss: (() -> Unit)? = null,
    ) {
        snackBar.addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
            override fun onShown(tbb: Snackbar?) { onShown?.invoke() }
            override fun onDismissed(tbb: Snackbar?, e: Int) { onDismiss?.invoke() }
        })
    }

    fun show() {
        snackBar.show()
    }
}
