package org.sopt.zepeto.ui.main.make

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import org.sopt.zepeto.data.ServiceCreator
import org.sopt.zepeto.databinding.FragmentMakeBinding
import org.sopt.zepeto.ui.editimage.EditImageActivity
import org.sopt.zepeto.util.enqueueUtil


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
        initData()
        initBtnClickListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initData() {
        ServiceCreator.zepetoService.getImages().apply {
            enqueueUtil(
                onSuccess = {
                    it.data?.let {
                        makeAdapter = MakeAdapter().apply {
                            setItems(it)
                            binding.rvFeedList.adapter = this
                        }
                    }
                }
            )
        }
    }


    private fun initBtnClickListener() {
        binding.clUpload.setOnClickListener {
            resultLauncher.launch("image/*")
        }
    }
}