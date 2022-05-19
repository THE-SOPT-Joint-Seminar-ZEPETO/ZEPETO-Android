package org.sopt.zepeto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.zepeto.databinding.ItemMakeListBinding
import org.sopt.zepeto.util.dpToPixel


class MakeAdapter : RecyclerView.Adapter<MakeAdapter.MakeViewHolder>() {
    val makeList = mutableListOf<MakeData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeViewHolder {
        val binding =
            ItemMakeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MakeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MakeViewHolder, position: Int) {
        holder.onBind(makeList[position])
    }

    override fun getItemCount(): Int = makeList.size

    fun setItems(newItems: List<MakeData>) {
        makeList.clear()
        makeList.addAll(newItems)
        notifyDataSetChanged()
    }

    class MakeViewHolder(
        private val binding: ItemMakeListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MakeData) {
            val customDecoration = when (data.images.size) {
                2 -> GridSpaceDecoration(8.dpToPixel(), 2)
                else -> GridSpaceDecoration(12.dpToPixel(), 3)
            }

            MakeContentsAdapter().apply {
                setItems(data.images)
                binding.rvBody.adapter = this
            }

            Glide.with(itemView).load(data.profileImgUrl).circleCrop().into(binding.ivProfile)
            with(binding) {
                tvTitle.text = data.title
                tvDescription.text = data.description
                rvBody.apply {
                    layoutManager = GridLayoutManager(context, data.images.size)
                    addItemDecoration(customDecoration)
                }
            }
        }
    }
}