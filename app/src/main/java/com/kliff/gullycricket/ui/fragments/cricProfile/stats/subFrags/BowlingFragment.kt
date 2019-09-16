package com.kliff.gullycricket.ui.fragments.cricProfile.stats.subFrags

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kliff.gullycricket.R

/**
 * A simple [Fragment] subclass.
 */
class BowlingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bowling, container, false)
    }

}
