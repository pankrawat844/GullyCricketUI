package com.kliff.gullycricket.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kliff.gullycricket.R
import kotlinx.android.synthetic.main.activity_create_team.*

class CreateTeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_team)
        setSupportActionBar(createTeamToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        createTeamToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
