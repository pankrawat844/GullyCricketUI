package com.kliff.gullycricket.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.MatchDetailVPAdapter
import com.kliff.gullycricket.ui.models.MatchList
import kotlinx.android.synthetic.main.activity_match_detail.*

class MatchDetailActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MatchDetailActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_match_detail)

        setSupportActionBar(matchDetailToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        matchDetailToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        matchDetailViewPager.adapter = MatchDetailVPAdapter(supportFragmentManager)
        matchDetailTabs.setupWithViewPager(matchDetailViewPager)
        matchDetailViewPager.currentItem = 1

        val new: MatchList = intent.getSerializableExtra("matchDetail") as MatchList

        Log.e(TAG, "Hello: ${new.javaClass}")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.match_detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.forward -> true
            R.id.setting -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
