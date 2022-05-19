package org.sopt.zepeto

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 5

    override fun createFragment(pos: Int): Fragment {
        return when (pos) {
            MainActivity.HOME_POS -> HomeFragment()
            MainActivity.WORLD_POS -> WorldFragment()
            MainActivity.MAKE_POS -> MakeFragment()
            MainActivity.FEED_POS -> FeedFragment()
            else -> ProfileFragment()
        }
    }
}