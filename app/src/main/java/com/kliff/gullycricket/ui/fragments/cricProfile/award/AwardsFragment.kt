package com.kliff.gullycricket.ui.fragments.cricProfile.award

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.AwardVPAdapter
import kotlinx.android.synthetic.main.fragment_awards.*

/**
 * A simple [Fragment] subclass.
 */
class AwardsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_awards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        awardVP.adapter = AwardVPAdapter(childFragmentManager)
        awardTabs.setupWithViewPager(awardVP)
    }
}
