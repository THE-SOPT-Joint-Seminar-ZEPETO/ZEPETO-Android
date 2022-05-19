package org.sopt.zepeto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.zepeto.databinding.FragmentMakeBinding


class MakeFragment : Fragment() {
    private var _binding: FragmentMakeBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다")
    private lateinit var makeAdapter: MakeAdapter

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
        val imagesThree = listOf(
            MakeContentsData(
                "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                true,
                false
            ),
            MakeContentsData(
                "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                false,
                true
            ),
            MakeContentsData(
                "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                true,
                true
            )
        )
        val imagesTwo = listOf(
            MakeContentsData(
                "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                false,
                true
            ),
            MakeContentsData(
                "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                true,
                false
            ),
        )
        val makeAdapter = MakeAdapter().apply {
            makeList.addAll(
                listOf(
                    MakeData(
                        "title1",
                        "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                        "description1",
                        imagesThree
                    ),
                    MakeData(
                        "title2",
                        "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                        "description2",
                        imagesTwo
                    ),
                    MakeData(
                        "title3",
                        "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                        "description3",
                        imagesThree
                    ),
                    MakeData(
                        "title4",
                        "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                        "description4",
                        imagesThree
                    ),
                    MakeData(
                        "title5",
                        "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                        "description5",
                        imagesTwo
                    ),
                    MakeData(
                        "title6",
                        "https://avatars.githubusercontent.com/u/105535772?s=200&v=4",
                        "description6",
                        imagesThree
                    )
                )
            )
            notifyDataSetChanged()
        }
        binding.rvFeedList.adapter = makeAdapter
    }
}