package com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kliff.gullycricket.R

/**
 * A simple [Fragment] subclass.
 */
class MVPFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mv, container, false)
    }


}
