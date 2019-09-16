package com.kliff.gullycricket.ui.fragments.matches


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.MatchViewPagerAdapter

/**
 * A simple [Fragment] subclass.
 */
class MatchesFragment : Fragment() {

    private lateinit var viewPagerAdapter: MatchViewPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    lateinit var bundle: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_matches, container, false)
        viewPager = view.findViewById(R.id.matchViewPager)
        tabLayout = view.findViewById(R.id.matchTabLayout)
        viewPagerAdapter = MatchViewPagerAdapter(childFragmentManager)

        tabLayout.setupWithViewPager(viewPager)
        viewPager.adapter = viewPagerAdapter

        if (arguments?.getString("tabPosition") != null) {
            bundle = arguments?.getString("tabPosition")!!
            when(bundle) {
                "My Matches" -> viewPager.currentItem = 0
            }
        }
        return view
    }
}
