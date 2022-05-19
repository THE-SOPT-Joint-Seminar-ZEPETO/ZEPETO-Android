package org.sopt.zepeto.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.sopt.zepeto.databinding.ActivityEditImageBinding

class EditImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditImageBinding
    private lateinit var imageUri : Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initImage()
        initBtnClickListener()
    }

    private fun initImage() {
        if (intent.hasExtra(IMAGE_URI)) {
            imageUri = intent.getParcelableExtra<Uri>(IMAGE_URI)!!
        }
        Glide.with(this)
            .load(imageUri)
            .into(binding.ivEditImage)
    }

    private fun initBtnClickListener() {
        binding.ibBtEditNext.setOnClickListener {
            val intent = Intent(this, EditContentActivity::class.java)
            intent.putExtra(IMAGE_URI, imageUri)
            startActivity(intent)
            finish()
        }
        binding.root.setOnClickListener {
            binding.clEdit.visibility = View.VISIBLE
        }
        binding.clEdit.setOnClickListener {
            binding.clEdit.visibility = View.INVISIBLE
        }
    }

    companion object {
        const val IMAGE_URI = "imageUri"
    }
}