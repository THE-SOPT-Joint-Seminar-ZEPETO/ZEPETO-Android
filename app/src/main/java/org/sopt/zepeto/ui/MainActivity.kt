package org.sopt.zepeto.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import org.sopt.zepeto.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {

                val intent = Intent(this, EditImageActivity::class.java)
                intent.putExtra("imageUri", uri)
                startActivity(intent)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBtnClickListener()

    }

    private fun initBtnClickListener() {

        binding.button.setOnClickListener {
            resultLauncher.launch("image/*")

        }
    }

}
