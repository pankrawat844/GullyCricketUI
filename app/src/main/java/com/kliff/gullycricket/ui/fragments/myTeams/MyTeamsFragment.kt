package com.kliff.gullycricket.ui.fragments.myTeams

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.activities.CreateTeamActivity
import kotlinx.android.synthetic.main.fragment_my_teams.*

/**
 * A simple [Fragment] subclass.
 */
class MyTeamsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createNewTeam.setOnClickListener {
            startActivity(Intent(context, CreateTeamActivity::class.java))
        }
    }
}
