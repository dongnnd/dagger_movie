package com.example.daggermovie.view.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewParent
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.example.daggermovie.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI(){
        with(view_pager){
            adapter = MainPageAdapter(supportFragmentManager)
            offscreenPageLimit = 3
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) = Unit

                override fun onPageSelected(position: Int) {
                    bottom_navigation.menu.getItem(position).isChecked = true
                }

                override fun onPageScrollStateChanged(state: Int) = Unit

            })
            bottom_navigation.setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.action_one -> currentItem = 0
                    R.id.action_two -> currentItem = 1
                    R.id.action_three -> currentItem = 2
                }

                true
            }
        }
    }
}