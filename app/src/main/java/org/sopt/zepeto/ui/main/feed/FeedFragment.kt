package org.sopt.zepeto.ui.main.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import org.sopt.zepeto.data.ServiceCreator
import org.sopt.zepeto.databinding.FragmentFeedBinding
import org.sopt.zepeto.util.enqueueUtil

class FeedFragment : Fragment() {
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(layoutInflater, container, false)
        initViewClickListener()
        initData()
        setViewMore(binding.tvTextBox, binding.viewMore)
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

    private fun initData() {
        ServiceCreator.zepetoService.getFeed().apply {
            enqueueUtil(
                onSuccess = { baseResponse ->
                    baseResponse.data?.let {
                        binding.tvUserName.text = it.userName
                        binding.tvTextBox.text = it.content
                        Glide.with(this@FeedFragment).load(it.imageUrl).into(binding.ivFeedImage)
                        Glide.with(this@FeedFragment).load(it.userProfileImageUrl).circleCrop()
                            .into(binding.profileImage)
                    }
                }
            )
        }
    }

    private fun setViewMore(contentTextView: TextView, viewMoreTextView: TextView) {
        // getEllipsisCount()을 통한 더보기 표시 및 구현
        // 파라미터 대신에 변수 활용하여 의존성 낮추기
        contentTextView.post {
            val lineCount = contentTextView.layout.lineCount
            if (lineCount > 0) {
                if (contentTextView.layout.getEllipsisCount(lineCount - 1) > 0) {
                    // 더보기 표시
                    viewMoreTextView.visibility = View.VISIBLE

                    // 더보기 클릭 이벤트
                    viewMoreTextView.setOnClickListener {
                        contentTextView.maxLines = Int.MAX_VALUE
                        viewMoreTextView.visibility = View.GONE
                    }

                    contentTextView.setOnClickListener {
                        contentTextView.maxLines = 2
                        viewMoreTextView.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}
