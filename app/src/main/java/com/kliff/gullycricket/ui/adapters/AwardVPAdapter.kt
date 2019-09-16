package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.cricProfile.award.subFrags.AMatchFragment
import com.kliff.gullycricket.ui.fragments.cricProfile.award.subFrags.ATournamentFragment

class AwardVPAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> AMatchFragment()
            1 -> ATournamentFragment()
            else -> AMatchFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Match"
            1 -> "Tournament"
            else -> "Mach"
        }
    }
}