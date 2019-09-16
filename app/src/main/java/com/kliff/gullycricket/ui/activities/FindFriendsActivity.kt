package com.kliff.gullycricket.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.FindFriendVPAdapter
import kotlinx.android.synthetic.main.activity_find_friends.*

class FindFriendsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_friends)
        setSupportActionBar(findToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findVP.adapter = FindFriendVPAdapter(supportFragmentManager)
        findTabs.setupWithViewPager(findVP)

        findToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
