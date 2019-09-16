package com.kliff.gullycricket.ui.fragments.matches.matchesSubFrags


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.activities.MatchDetailActivity
import com.kliff.gullycricket.ui.activities.StartMatchActivity
import com.kliff.gullycricket.ui.adapters.MatchListAdapter
import com.kliff.gullycricket.ui.models.MatchList
import com.kliff.gullycricket.ui.viewModels.MyMatchesViewModel
import kotlinx.android.synthetic.main.fragment_my_matches.*
import java.io.Serializable

/**
 * A simple [Fragment] subclass.
 */
class MyMatchesFragment : Fragment() {

    private lateinit var myMatchesViewModel: MyMatchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myMatchesViewModel = ViewModelProviders.of(this)
            .get(MyMatchesViewModel::class.java)

        refreshlayout.setOnRefreshListener {
            myMatchRecyclerView.layoutManager = LinearLayoutManager(activity)
            val adapter = MatchListAdapter()
            myMatchRecyclerView.adapter = adapter

            myMatchesViewModel.getAllMatches().observe(this, Observer {
                adapter.submitList(it)
            })

            refreshlayout.isRefreshing = false
        }
        myMatchRecyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = MatchListAdapter()
        myMatchRecyclerView.adapter = adapter

        myMatchesViewModel.getAllMatches().observe(this, Observer {
            adapter.submitList(it)
        })

        startMatch.setOnClickListener {
            startActivity(Intent(context, StartMatchActivity::class.java))
        }

        adapter.setOnItemClickListener(object : MatchListAdapter.OnItemClickListener {
            override fun onItemClick(matchList: MatchList) {
                val intent = Intent(activity?.application, MatchDetailActivity::class.java)
                intent.putExtra("matchDetail", matchList as Serializable)
                startActivity(intent)
            }
        })
    }
}
