package org.sopt.zepeto.util

import android.content.Context
import android.content.res.Resources
import kotlin.math.roundToInt

fun Context.dpToPixel(dp: Int): Int =
    (dp * resources.displayMetrics.density).roundToInt()

fun Int.dpToPixel(): Int = this * Resources.getSystem().displayMetrics.density.roundToInt()