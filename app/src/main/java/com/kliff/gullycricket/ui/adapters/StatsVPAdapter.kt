package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.cricProfile.stats.subFrags.BattingFragment
import com.kliff.gullycricket.ui.fragments.cricProfile.stats.subFrags.BowlingFragment
import com.kliff.gullycricket.ui.fragments.cricProfile.stats.subFrags.CaptainFragment
import com.kliff.gullycricket.ui.fragments.cricProfile.stats.subFrags.FieldingFragment

class StatsVPAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BattingFragment()
            1 -> BowlingFragment()
            2 -> FieldingFragment()
            3 -> CaptainFragment()
            else -> BattingFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "BATTING"
            1 -> "BOWLING"
            2 -> "FIELDING"
            3 -> "CAPTAIN"
            else -> "BATTING"
        }
    }
}