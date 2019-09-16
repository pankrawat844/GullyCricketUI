package com.kliff.gullycricket.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kliff.gullycricket.R
import kotlinx.android.synthetic.main.activity_select_teams.*
import kotlinx.android.synthetic.main.activity_start_match.*

class StartMatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_match)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        fabTeam1.setOnClickListener {
            startActivity(Intent(this, SelectTeamsActivity::class.java).apply {
                putExtra("team", "Select team A")
            })
        }

        fabTeam2.setOnClickListener {
            startActivity(Intent(this, SelectTeamsActivity::class.java).apply {
                putExtra("team", "Select team B")
            })
        }
    }
}
