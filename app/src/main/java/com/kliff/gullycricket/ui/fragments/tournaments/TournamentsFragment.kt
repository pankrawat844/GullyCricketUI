package com.kliff.gullycricket.ui.fragments.tournaments


import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.TournamentsVPAdapter
import kotlinx.android.synthetic.main.fragment_tournamnets.*

/**
 * A simple [Fragment] subclass.
 */
class TournamentsFragment : Fragment() {

    lateinit var bundle: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tournamnets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tournamentsViewPager.adapter = TournamentsVPAdapter(childFragmentManager)
        tournamentsTabLayout.setupWithViewPager(tournamentsViewPager)

        if (arguments?.getString("tabPosition") != null) {
            bundle = arguments?.getString("tabPosition")!!
            when(bundle) {
                "My Tournament" -> {
                    tournamentsViewPager.currentItem = 0}
            }
        }
    }

}
