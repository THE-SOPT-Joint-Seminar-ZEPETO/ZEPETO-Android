package org.sopt.zepeto

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.sopt.zepeto.databinding.ActivityEditContentBinding
import org.sopt.zepeto.util.ZepetoSnackBar

class EditContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEditTextFocusListener()
        initBackButtonClick()
        initCompleteButtonCLick()
    }

    private fun initBackButtonClick() {
        binding.ivBack.setOnClickListener { super.onBackPressed() }
    }

    private fun initCompleteButtonCLick() {
        binding.btnComplete.setOnClickListener {
            showSnackBar()
        }
    }

    private fun showSnackBar() {
        val completeSnackBar = ZepetoSnackBar.make(binding.root)
        completeSnackBar.addCallBack(
            { binding.viewFullCover.visibility = View.VISIBLE },
            { binding.viewFullCover.visibility = View.INVISIBLE }
        )
        completeSnackBar.show()
    }

    private fun setEditTextFocusListener() {
        binding.etContents.setOnFocusChangeListener { _, hasFocus ->
            binding.isEditTextFocus = hasFocus
        }
    }

    // EditText 이외 영역 클릭 했을 때 키보드 내려가게 하는 코드
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
