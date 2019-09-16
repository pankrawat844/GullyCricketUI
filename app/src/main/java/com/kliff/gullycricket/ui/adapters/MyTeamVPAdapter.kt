package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.myTeams.FollowingFragment
import com.kliff.gullycricket.ui.fragments.myTeams.MyTeamsFragment
import com.kliff.gullycricket.ui.fragments.myTeams.OpponentsFragment

class MyTeamVPAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> MyTeamsFragment()
            1 -> OpponentsFragment()
            2 -> FollowingFragment()
            else -> MyTeamsFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "MY TEAMS"
            1 -> "OPPONENTS"
            2 -> "FOLLOWING"
            else -> "MY TEAMS"
        }
    }
}