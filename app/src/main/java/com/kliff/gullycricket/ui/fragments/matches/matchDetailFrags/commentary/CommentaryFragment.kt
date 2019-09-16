package com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags.commentary


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.CommentaryVPAdapter
import kotlinx.android.synthetic.main.fragment_commentary.*

/**
 * A simple [Fragment] subclass.
 */
class CommentaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_commentary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        commentary_viewPager.adapter = CommentaryVPAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(commentary_viewPager)
    }
}
