package org.sopt.zepeto

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.sopt.zepeto.databinding.ActivityEditContentBinding

class EditContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setEditTextFocusListener()
    }

    private fun setEditTextFocusListener() {
        binding.etContents.setOnFocusChangeListener { _, hasFocus ->
            binding.isEditTextFocus = hasFocus
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        val v = currentFocus
        if (v != null && event.action == MotionEvent.ACTION_UP || event.action == MotionEvent.ACTION_MOVE && v is EditText && !v.javaClass
            .name.startsWith("android.webkit.")
        ) {
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }
}
