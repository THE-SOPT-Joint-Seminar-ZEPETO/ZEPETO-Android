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
    var imageUri: Uri = Uri.EMPTY
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.setOnClickListener {
            binding.clEdit.visibility = View.VISIBLE
        }
        binding.clEdit.setOnClickListener {
            binding.clEdit.visibility = View.INVISIBLE
        }

        if (intent.hasExtra("imageUri")) {
            imageUri = intent.getParcelableExtra<Uri>("imageUri")!!
        }

        initImage()
        initBtnClickListener()
    }

    private fun initImage() {
        Glide.with(this)
            .load(imageUri)
            .into(binding.ivEditImage)
    }

    private fun initBtnClickListener() {

        binding.ibBtEditNext.setOnClickListener {
            val intent = Intent(this, EditContentActivity::class.java)
            intent.putExtra("imageUri", imageUri)
            startActivity(intent)
            finish()
        }
    }
}