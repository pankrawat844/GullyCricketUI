package com.kliff.gullycricket.ui.fragments.matches.matchDetailFrags


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kliff.gullycricket.R
import kotlinx.android.synthetic.main.fragment_summary.*

/**
 * A simple [Fragment] subclass.
 */
class SummaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*hide1.setOnClickListener {
            team1Name.visibility = View.GONE
            team1Score.visibility = View.GONE
            team1Over.visibility = View.GONE
            team1CRR.visibility = View.GONE
            team1CRRersult.visibility = View.GONE
            team1Pro.visibility = View.GONE
            projectedScore.visibility = View.GONE
            RPO.visibility = View.GONE
        }

        hide2.setOnClickListener {

        }

        hide3.setOnClickListener {
            ongo_layout.visibility = View.GONE
        }

        hide4.setOnClickListener {
            finish_match_layout.visibility = View.GONE
        }*/
    }
}
