package org.sopt.zepeto.ui.main.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.zepeto.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(layoutInflater, container, false)
        initViewClickListener()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViewClickListener() {
        binding.root.setOnClickListener {
            binding.clFeed.visibility = View.VISIBLE
        }
        binding.clFeed.setOnClickListener {
            binding.clFeed.visibility = View.INVISIBLE

        }
    }
}