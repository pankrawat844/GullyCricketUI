package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.tournaments.tourSubFrags.MyTournaments
import com.kliff.gullycricket.ui.fragments.tournaments.tourSubFrags.TourAllFragment
import com.kliff.gullycricket.ui.fragments.tournaments.tourSubFrags.TourFollowingFragment
import com.kliff.gullycricket.ui.fragments.tournaments.tourSubFrags.TourUpcomingFragment

class TournamentsVPAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {

            0 -> MyTournaments()
            1 -> TourAllFragment()
            2 -> TourUpcomingFragment()
            3 -> TourFollowingFragment()
            else -> MyTournaments()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {

            0 -> "My Tournaments"
            1 -> "All"
            2 -> "Upcoming"
            3 -> "Following"
            else -> "My Tournaments"
        }
    }
}