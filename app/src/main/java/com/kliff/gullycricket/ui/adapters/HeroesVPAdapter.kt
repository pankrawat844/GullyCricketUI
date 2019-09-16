package com.kliff.gullycricket.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.heroes.heroesSubFrags.BBatsmanFragment
import com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.heroes.heroesSubFrags.BBowlerFragment
import com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.heroes.heroesSubFrags.POMFragment

class HeroesVPAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> POMFragment()
            1 -> BBatsmanFragment()
            2 -> BBowlerFragment()
            else -> POMFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}