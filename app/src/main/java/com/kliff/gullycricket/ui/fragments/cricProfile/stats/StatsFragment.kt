package com.kliff.gullycricket.ui.fragments.cricProfile.stats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.StatsVPAdapter
import kotlinx.android.synthetic.main.fragment_stats.*

/**
 * A simple [Fragment] subclass.
 */
class StatsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statsVP.adapter = StatsVPAdapter(childFragmentManager)
        statsTabs.setupWithViewPager(statsVP)
    }

}
