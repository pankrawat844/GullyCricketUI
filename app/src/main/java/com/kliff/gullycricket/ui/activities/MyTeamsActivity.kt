package com.kliff.gullycricket.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.MyTeamVPAdapter
import kotlinx.android.synthetic.main.activity_my_teams.*

class MyTeamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_teams)
        setSupportActionBar(myTeamToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        myTeamVP.adapter = MyTeamVPAdapter(supportFragmentManager)
        myTeamTabs.setupWithViewPager(myTeamVP)

        myTeamToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
