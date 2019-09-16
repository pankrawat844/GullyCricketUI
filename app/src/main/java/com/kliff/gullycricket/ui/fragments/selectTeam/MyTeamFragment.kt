package com.kliff.gullycricket.ui.fragments.selectTeam


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.kliff.gullycricket.R
import kotlinx.android.synthetic.main.fragment_my_team.*

/**
 * A simple [Fragment] subclass.
 */
class MyTeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView.queryHint = "Quick Search"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchView.clearFocus()
                searchView.queryHint = "Quick Search"
                searchView.setQuery("", false)
                Toast.makeText(context, "Looking for $p0", Toast.LENGTH_LONG).show()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
        searchView.setOnClickListener {
            searchClicked(it)
        }
    }

    private fun searchClicked(view: View) {
        val showKeyboard =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        showKeyboard.showSoftInput(view, 0)
    }

}
