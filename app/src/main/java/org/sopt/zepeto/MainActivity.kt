package org.sopt.zepeto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
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
            when (it.itemId) {
                R.id.menu_home -> {
                    binding.vpMain.currentItem = HOME_POS
                    return@setOnItemSelectedListener true
                }
                R.id.menu_world -> {
                    binding.vpMain.currentItem = WORLD_POS
                    return@setOnItemSelectedListener true
                }
                R.id.menu_make -> {
                    binding.vpMain.currentItem = MAKE_POS
                    return@setOnItemSelectedListener true
                }
                R.id.menu_feed -> {
                    binding.vpMain.currentItem = FEED_POS
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.vpMain.currentItem = PROFILE_POS
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object {
        const val HOME_POS = 0
        const val WORLD_POS = 1
        const val MAKE_POS = 2
        const val FEED_POS = 3
        const val PROFILE_POS = 4
    }
}
