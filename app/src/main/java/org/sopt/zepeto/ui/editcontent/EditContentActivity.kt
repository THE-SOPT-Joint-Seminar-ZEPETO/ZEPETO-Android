package org.sopt.zepeto.ui.editcontent

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import okhttp3.MultipartBody
import org.sopt.zepeto.data.ServiceCreator
import org.sopt.zepeto.databinding.ActivityEditContentBinding
import org.sopt.zepeto.ui.editimage.EditImageActivity
import org.sopt.zepeto.ui.main.MainActivity
import org.sopt.zepeto.util.MultiPartResolver
import org.sopt.zepeto.util.ZepetoSnackBar
import org.sopt.zepeto.util.enqueueUtil

class EditContentActivity : AppCompatActivity() {
    private val mainActivity = MainActivity.getInstance()
    private lateinit var binding: ActivityEditContentBinding
    private var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initImage()
        setEditTextFocusListener()
        initBackButtonClick()
        initCompleteButtonCLick()
    }

    private fun initBackButtonClick() {
        binding.ivBack.setOnClickListener { super.onBackPressed() }
    }

    private fun initCompleteButtonCLick() {
        binding.btnComplete.setOnClickListener {
            uploadPost(
                contents = binding.etContents.text.toString(),
                image = MultiPartResolver().createImgMultiPart(requireNotNull(imageUri), this)
            )
        }
    }

    private fun uploadPost(contents: String, image: MultipartBody.Part) {
        ServiceCreator.zepetoService.uploadPost(contents, image).apply {
            enqueueUtil(
                onSuccess = {
                    showSnackBar()
                    mainActivity?.setCurrentItem(MainActivity.FEED_POS)
                },
                onError = { code -> Log.d(TAG, "uploadPost: fail $code") }
            )
        }
    }

    private fun showSnackBar() {
        val completeSnackBar = ZepetoSnackBar.make(binding.root)
        completeSnackBar.addActivityInfo(this)
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

    private fun initImage() {
        imageUri = intent.getParcelableExtra(EditImageActivity.IMAGE_URI)
        Glide.with(this).load(imageUri).into(binding.ivPhoto)
    }
}
