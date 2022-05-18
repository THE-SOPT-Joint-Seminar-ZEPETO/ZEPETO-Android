package org.sopt.zepeto.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.zepeto.databinding.ActivityEditContentBinding

class EditContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}