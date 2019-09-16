package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.commentary.commnetarySubFrags.BoundaryFragment
import com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.commentary.commnetarySubFrags.FullOvFragment
import com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.commentary.commnetarySubFrags.OversFragment
import com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.commentary.commnetarySubFrags.WicketsFragment

class CommentaryVPAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OversFragment()
            1 -> FullOvFragment()
            2 -> WicketsFragment()
            3 -> BoundaryFragment()
            else -> OversFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "OVERS"
            1 -> "FULL"
            2 -> "WICKETS"
            3 -> "BOUNDARY"
            else -> "OVERS"
        }
    }
}