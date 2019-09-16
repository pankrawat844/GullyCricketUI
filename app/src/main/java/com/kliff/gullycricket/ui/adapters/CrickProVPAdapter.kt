package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.cricProfile.award.AwardsFragment
import com.kliff.gullycricket.ui.fragments.cricProfile.PhotosFragment
import com.kliff.gullycricket.ui.fragments.cricProfile.stats.StatsFragment
import com.kliff.gullycricket.ui.fragments.cricProfile.TeamsFragment
import com.kliff.gullycricket.ui.fragments.matches.matchesSubFrags.MyMatchesFragment

class CrickProVPAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MyMatchesFragment()
            1 -> StatsFragment()
            2 -> AwardsFragment()
            3 -> TeamsFragment()
            4 -> PhotosFragment()
            else -> MyMatchesFragment()
        }
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "MATCHES"
            1 -> "STATS"
            2 -> "AWARDS"
            3 -> "TEAMS"
            4 -> "PHOTOS"
            else -> "Matches"
        }
    }
}