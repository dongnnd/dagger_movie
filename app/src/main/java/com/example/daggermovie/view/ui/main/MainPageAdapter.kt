package com.example.daggermovie.view.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainPageAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int  = 3

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MovieListFragment()
            1 -> TvListFragment()
            else -> PersonListFragment()
        }
    }
}