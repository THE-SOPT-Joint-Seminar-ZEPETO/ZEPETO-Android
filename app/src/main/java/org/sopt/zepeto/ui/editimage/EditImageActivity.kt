package org.sopt.zepeto.ui.editimage

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import com.bumptech.glide.Glide
import org.sopt.zepeto.R
import org.sopt.zepeto.databinding.ActivityEditImageBinding
import org.sopt.zepeto.ui.editcontent.EditContentActivity

class EditImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditImageBinding
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditImageBinding.inflate(layoutInflater)

        window.apply {
            //상태바
            statusBarColor = Color.BLACK
            //상태바 아이콘(true: 검정 / false: 흰색)
            WindowInsetsControllerCompat(this, this.decorView).isAppearanceLightStatusBars = false
        }

        setContentView(binding.root)
        initImage()
        setImage()
        initBtnClickListener()
        initViewClickListener()
    }

    private fun initImage() {
        if (intent.hasExtra(IMAGE_URI)) {
            imageUri = intent.getParcelableExtra<Uri>(IMAGE_URI)
        }

    }

    private fun setImage(){
        if (imageUri != null) {
            Glide.with(this)
                .load(imageUri)
                .placeholder(R.drawable.dummy_image)
                .error(R.drawable.dummy_image)
                .fallback(R.drawable.dummy_image)
                .into(binding.ivEditImage)
        }

    }

    private fun initBtnClickListener() {
        binding.ibBtEditNext.setOnClickListener {
            val intent = Intent(this, EditContentActivity::class.java)
            intent.putExtra(IMAGE_URI, imageUri)
            startActivity(intent)
            finish()
        }
    }

    private fun initViewClickListener() {
        binding.root.setOnClickListener {
            binding.clEdit.visibility = View.VISIBLE
        }
        binding.clEdit.setOnClickListener {
            binding.clEdit.visibility = View.INVISIBLE
        }
    }

    // 싱글톤 객체라고 합니다..
    companion object {
        const val IMAGE_URI = "imageUri"
    }
}
