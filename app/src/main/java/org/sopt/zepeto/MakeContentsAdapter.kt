package org.sopt.zepeto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.zepeto.databinding.ItemMakeContentsBinding

class MakeContentsAdapter : RecyclerView.Adapter<MakeContentsAdapter.MakeContentsViewHolder>() {
    val makeContentsList = mutableListOf<MakeContentsData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeContentsViewHolder {
        val binding =
            ItemMakeContentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MakeContentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MakeContentsViewHolder, position: Int) {
        holder.onBind(makeContentsList[position])
    }

    override fun getItemCount(): Int = makeContentsList.size

    class MakeContentsViewHolder(
        private val binding: ItemMakeContentsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: MakeContentsData) {
            Glide.with(itemView).load(data.url).into(binding.ivImage)
            if (data.isStared) binding.ivStar.setImageResource(R.drawable.ic_star_fill)
            if (data.isVideo) binding.ivVideo.visibility = View.VISIBLE
        }
    }
}