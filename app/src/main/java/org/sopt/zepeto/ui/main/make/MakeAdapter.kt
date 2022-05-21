package org.sopt.zepeto.ui.main.make

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.sopt.zepeto.data.response.ResponseImages
import org.sopt.zepeto.databinding.ItemMakeListBinding
import org.sopt.zepeto.util.GridSpaceDecoration
import org.sopt.zepeto.util.dpToPixel


class MakeAdapter : RecyclerView.Adapter<MakeAdapter.MakeViewHolder>() {
    val makeList = mutableListOf<ResponseImages>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeViewHolder {
        val binding =
            ItemMakeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MakeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MakeViewHolder, position: Int) {
        holder.onBind(makeList[position])
    }

    override fun getItemCount(): Int = makeList.size

    fun setItems(newItems: List<ResponseImages>) {
        makeList.clear()
        makeList.addAll(newItems)
        notifyDataSetChanged()
    }

    class MakeViewHolder(
        private val binding: ItemMakeListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseImages) {
            val customDecoration = when (data.images.size) {
                2 -> GridSpaceDecoration(8.dpToPixel(), 2)
                else -> GridSpaceDecoration(12.dpToPixel(), 3)
            }

            MakeContentsAdapter().apply {
                setItems(data.images)
                binding.rvBody.adapter = this
            }

            binding.make = data
            binding.rvBody.apply {
                layoutManager = GridLayoutManager(context, data.images.size)
                addItemDecoration(customDecoration)
            }
        }
    }
}