package org.sopt.zepeto.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import org.sopt.zepeto.R
import org.sopt.zepeto.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        initAdapter()
        initBottomNavi()
        initView()
    }

    private fun initAdapter() {
        binding.vpMain.adapter = ViewPagerAdapter(this@MainActivity)
    }

    private fun initBottomNavi() {
        binding.vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bnvMain.menu.getItem(position).isChecked = true
            }
        })
    }

    private fun initView() {
        binding.bnvMain.setOnItemSelectedListener {
            with(binding.vpMain) {
                when (it.itemId) {
                    R.id.menu_home -> this.currentItem = HOME_POS
                    R.id.menu_world -> this.currentItem = WORLD_POS
                    R.id.menu_make -> this.currentItem = MAKE_POS
                    R.id.menu_feed -> this.currentItem = FEED_POS
                    else -> this.currentItem = PROFILE_POS
                }
                return@setOnItemSelectedListener true
            }
        }
    }

    fun setCurrentItem(item: Int) {
        binding.vpMain.setCurrentItem(item, true)
    }

    init {
        instance = this
    }

    companion object {
        const val HOME_POS = 0
        const val WORLD_POS = 1
        const val MAKE_POS = 2
        const val FEED_POS = 3
        const val PROFILE_POS = 4

        private var instance: MainActivity? = null
        fun getInstance(): MainActivity? {
            return instance
        }
    }
}
