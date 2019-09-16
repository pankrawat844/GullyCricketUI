package com.kliff.gullycricket.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.adapters.ChallengeVPAdapter
import kotlinx.android.synthetic.main.activity_challenge_match.*

class ChallengeMatchActivity : AppCompatActivity() {

    var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_match)
        setSupportActionBar(challengeToolbar)
        updateOptionsMenu()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        challengeVP.adapter = ChallengeVPAdapter(supportFragmentManager)
        challengeTabs.setupWithViewPager(challengeVP)

        challengeToolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        challengeVP.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> menu?.getItem(0)?.isVisible = true
                    1 -> menu?.getItem(0)?.isVisible = false
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.challenge_menu, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateOptionsMenu() {
        if (menu != null) {
            onPrepareOptionsMenu(menu)
        }
    }
}