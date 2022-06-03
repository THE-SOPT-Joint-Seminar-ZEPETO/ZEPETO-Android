package org.sopt.zepeto.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.sopt.zepeto.ui.main.feed.FeedFragment
import org.sopt.zepeto.ui.main.home.HomeFragment
import org.sopt.zepeto.ui.main.make.MakeFragment
import org.sopt.zepeto.ui.main.profile.ProfileFragment
import org.sopt.zepeto.ui.main.world.WorldFragment

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