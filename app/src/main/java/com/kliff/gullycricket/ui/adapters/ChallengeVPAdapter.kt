package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.challenge.NewTeamFragment
import com.kliff.gullycricket.ui.fragments.challenge.TeamAroundYouFragment

class ChallengeVPAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> TeamAroundYouFragment()
            1 -> NewTeamFragment()
            else -> TeamAroundYouFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "TEAM AROUND YOU"
            1 -> "SEARCH/ADD NEW"
            else -> "TEAM AROUND YOU"
        }
    }
}