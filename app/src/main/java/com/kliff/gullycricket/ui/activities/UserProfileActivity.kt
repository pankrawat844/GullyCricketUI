package com.kliff.gullycricket.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kliff.gullycricket.R
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        textMyProfile.setOnClickListener {
            startActivity(Intent(this, CricketProfileActivity::class.java))
        }

        btnMyProfile.setOnClickListener {
            startActivity(Intent(this, CricketProfileActivity::class.java))
        }
    }
}
