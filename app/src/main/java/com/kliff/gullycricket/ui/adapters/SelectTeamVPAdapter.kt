package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.selectTeam.AddTeamFragment
import com.kliff.gullycricket.ui.fragments.selectTeam.MyTeamFragment
import com.kliff.gullycricket.ui.fragments.selectTeam.SearchTeamFragment

class SelectTeamVPAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> MyTeamFragment()
            1 -> SearchTeamFragment()
            2 -> AddTeamFragment()
            else -> MyTeamFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "My Team"
            1 -> "Search"
            2 -> "Add"
            else -> "My Team"
        }
    }
}