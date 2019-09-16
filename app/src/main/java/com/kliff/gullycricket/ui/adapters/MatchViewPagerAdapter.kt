package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.matches.matchesSubFrags.MyMatchesFragment

class MatchViewPagerAdapter(fragment: FragmentManager?) :
    FragmentStatePagerAdapter(fragment!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MyMatchesFragment()
            1 -> MyMatchesFragment()
            2 -> MyMatchesFragment()
            3 -> MyMatchesFragment()
            else -> MyMatchesFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "My Matches"
            1 -> "Live"
            2 -> "Upcoming"
            3 -> "Past"
            else -> "My Matches"
        }
    }
}