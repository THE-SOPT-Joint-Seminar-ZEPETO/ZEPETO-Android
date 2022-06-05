package org.sopt.zepeto.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imgUrl")
fun ImageView.loadImg(url: String) {
    Glide.with(this).load(url).into(this)
}

@BindingAdapter("imgUrlToCircle")
fun ImageView.loadCircleImg(url: String) {
    Glide.with(this).load(url).circleCrop().into(this)
}
