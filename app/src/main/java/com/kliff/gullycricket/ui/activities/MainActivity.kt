package com.kliff.gullycricket.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kliff.gullycricket.R
import com.kliff.gullycricket.ui.fragments.matches.MatchesFragment
import com.kliff.gullycricket.ui.fragments.tournaments.TournamentsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_tournamnet_dialog.view.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            (R.string.open),
            (R.string.close)
        )

        drawer_layout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()

        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFrame, MatchesFragment())
            .commit()
        val header = nav_view.getHeaderView(0)

        header.setOnClickListener {
            drawer_layout.closeDrawer(GravityCompat.START)
            startActivity(Intent(this, UserProfileActivity::class.java))
        }

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_start_a_match -> {
                    startActivity(Intent(this, StartMatchActivity::class.java))
                    return@setNavigationItemSelectedListener true
                }

                R.id.nav_my_matches -> {
                    val bundle = Bundle().also { my_match ->
                        my_match.putString("tabPosition", "My Matches")
                    }
                    drawer_layout.closeDrawer(GravityCompat.START)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame, MatchesFragment().apply {
                            arguments = bundle
                        })
                        .commit()

                    val item = bottomNavigationView.menu.getItem(0)
                    item.isChecked = true
                    return@setNavigationItemSelectedListener true
                }

                R.id.nav_my_tournament -> {
                    val bundle = Bundle().also { my_tour ->
                        my_tour.putString("tabPosition", "My Tournament")
                    }
                    drawer_layout.closeDrawer(GravityCompat.START)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame, TournamentsFragment().apply {
                            arguments = bundle
                        })
                        .commit()

                    val item = bottomNavigationView.menu.getItem(1)
                    item.isChecked = true
                    return@setNavigationItemSelectedListener true
                }

                R.id.nav_challenge -> {
                    drawer_layout.closeDrawer(GravityCompat.START)
                    startActivity(Intent(this, ChallengeMatchActivity::class.java))
                    return@setNavigationItemSelectedListener true
                }

                R.id.nav_my_teams -> {
                    drawer_layout.closeDrawer(GravityCompat.START)
                    startActivity(Intent(this, MyTeamsActivity::class.java))
                    return@setNavigationItemSelectedListener true
                }

                R.id.nav_add_tournament -> {
                    drawer_layout.closeDrawer(GravityCompat.START)
                    val viewGroup: ViewGroup = findViewById(android.R.id.content)
                    val viewDialog = LayoutInflater.from(this)
                        .inflate(R.layout.add_tournamnet_dialog, viewGroup, false)

                    val dialog: AlertDialog.Builder = AlertDialog.Builder(this)

                    dialog.setView(viewDialog)
                    dialog.setCancelable(false)
                    val alertDialog = dialog.create()
                    alertDialog.show()

                    viewDialog.register.setOnClickListener {
                        Toast.makeText(this, "Ok Clicked", Toast.LENGTH_SHORT).show()
                        alertDialog.dismiss()
                    }

                    viewDialog.cancel.setOnClickListener {
                        Toast.makeText(this, "Ok Clicked", Toast.LENGTH_SHORT).show()
                        alertDialog.dismiss()
                    }
                }

                R.id.nav_find_friends -> {
                    drawer_layout.closeDrawer(GravityCompat.START)
                    startActivity(Intent(this, FindFriendsActivity::class.java))
                }
            }
            return@setNavigationItemSelectedListener true
        }
        //BottomNavigation
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigation)
    }

    private val bottomNavigation = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {

            R.id.tournaments -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFrame, TournamentsFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }

            else -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFrame, MatchesFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
