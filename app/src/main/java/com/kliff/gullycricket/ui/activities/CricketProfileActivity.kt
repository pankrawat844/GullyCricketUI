package com.kliff.gullycricket.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.CrickProVPAdapter
import kotlinx.android.synthetic.main.activity_cricket_profile.*
import kotlinx.android.synthetic.main.activity_user_profile.*

class CricketProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cricket_profile)

        setSupportActionBar(toolbarCrickPro)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        crickProVP.adapter = CrickProVPAdapter(supportFragmentManager)
        tabsCrickPro.setupWithViewPager(crickProVP)

        toolbarCrickPro.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.crick_pro_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.filter -> true
            R.id.cricProForward -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
