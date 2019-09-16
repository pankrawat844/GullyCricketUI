package com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.heroes


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.HeroesVPAdapter
import kotlinx.android.synthetic.main.fragment_heros.*


/**
 * A simple [Fragment] subclass.
 */
class HeroesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heros, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        heroesViewPager.adapter = HeroesVPAdapter(childFragmentManager)
    }
}
