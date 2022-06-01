package org.sopt.zepeto.util

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import org.sopt.zepeto.databinding.LayoutCompleteSnackBarBinding
import org.sopt.zepeto.ui.editcontent.EditContentActivity

class ZepetoSnackBar(view: View) {
    private lateinit var editContentActivity: EditContentActivity

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
            override fun onShown(tbb: Snackbar?) {
                onShown?.invoke()
            }
            override fun onDismissed(tbb: Snackbar?, e: Int) {
                onDismiss?.invoke()
                if (e == Snackbar.Callback.DISMISS_EVENT_TIMEOUT) {
                    editContentActivity.finish()
                }
            }
        })
    }

    fun show() {
        snackBar.show()
    }

    fun addActivityInfo(editContentActivity: EditContentActivity) {
        this.editContentActivity = editContentActivity
    }
}
