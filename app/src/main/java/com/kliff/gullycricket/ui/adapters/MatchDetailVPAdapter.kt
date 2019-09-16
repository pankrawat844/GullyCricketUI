package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.*
import com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.commentary.CommentaryFragment
import com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.heroes.HeroesFragment

class MatchDetailVPAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> InfoFragment()
            1 -> SummaryFragment()
            2 -> ScorecardFragment()
            3 -> CommentaryFragment()
            4 -> AnalysisFragment()
            5 -> HeroesFragment()
            6 -> MVPFragment()
            7 -> GalleryFragment()
            else -> SummaryFragment()
        }
    }

    override fun getCount(): Int {
        return 8
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Info"
            1 -> "Summary"
            2 -> "Scorecard"
            3 -> "Commentary"
            4 -> "Analysis"
            5 -> "Heroes"
            6 -> "MVP"
            7 -> "Gallery"
            else -> "Summary"
        }
    }
}