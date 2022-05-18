package org.sopt.zepeto.ui

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import androidx.appcompat.app.AppCompatActivity
import org.sopt.zepeto.databinding.ActivityEditImageBinding

class EditImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditImageBinding
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


    }



}