package org.sopt.zepeto.ui.main

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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
        verifyStoragePermissions(this)
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

    // Storage Permissions
    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf<String>(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    fun verifyStoragePermissions(activity: Activity?) {
        // Check if we have write permission
        val permission = ActivityCompat.checkSelfPermission(
            activity!!,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                activity,
                PERMISSIONS_STORAGE,
                REQUEST_EXTERNAL_STORAGE
            )
        }
    }
}
