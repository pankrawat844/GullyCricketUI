package com.kliff.gullycricket.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.SelectTeamVPAdapter
import kotlinx.android.synthetic.main.activity_select_teams.*

class SelectTeamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_teams)

        selectTeamToolbar.title = intent.getStringExtra("team")
        setSupportActionBar(selectTeamToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        selectTeamToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        selectTeamViewPager.adapter = SelectTeamVPAdapter(supportFragmentManager)
        selectTeamTabs.setupWithViewPager(selectTeamViewPager)


    }
}
