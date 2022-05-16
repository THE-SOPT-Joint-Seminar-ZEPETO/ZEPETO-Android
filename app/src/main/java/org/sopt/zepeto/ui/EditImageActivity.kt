package org.sopt.zepeto.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.zepeto.databinding.ActivityEditImageBinding

class EditImageActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEditImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}