package org.sopt.zepeto.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import org.sopt.zepeto.util.MakeAdapter
import org.sopt.zepeto.util.MakeContentsData
import org.sopt.zepeto.util.MakeData
import org.sopt.zepeto.databinding.FragmentMakeBinding
import org.sopt.zepeto.ui.EditImageActivity
import org.sopt.zepeto.ui.MainActivity


class MakeFragment : Fragment() {
    private var _binding: FragmentMakeBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다")
    private lateinit var makeAdapter: MakeAdapter
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                activity?.let {
                    val intent = Intent(context, EditImageActivity::class.java)
                    intent.putExtra("imageUri", uri)
                    startActivity(intent)
                }
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMakeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initBtnClickListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
        // sample data
        val sampleImgUrl = "https://avatars.githubusercontent.com/u/105535772?s=200&v=4"
        val imagesThree = listOf(
            MakeContentsData(sampleImgUrl, true, false),
            MakeContentsData(sampleImgUrl, false, true),
            MakeContentsData(sampleImgUrl, true, true),
        )
        val imagesTwo = listOf(
            MakeContentsData(sampleImgUrl, false, true),
            MakeContentsData(sampleImgUrl, true, false),
        )
        val makeDataTwo = MakeData("title", sampleImgUrl, "description", imagesThree)
        val makeDataThree = MakeData("title", sampleImgUrl, "description", imagesTwo)

        val makeLists = listOf(
            makeDataThree,
            makeDataTwo,
            makeDataThree,
            makeDataTwo,
            makeDataTwo,
            makeDataThree,
            makeDataTwo
        )

        MakeAdapter().apply {
            setItems(makeLists)
            binding.rvFeedList.adapter = this
        }
    }

    private fun initBtnClickListener() {
        binding.clUpload.setOnClickListener {
            resultLauncher.launch("image/*")
        }
    }
}