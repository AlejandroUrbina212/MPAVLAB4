package com.app.mpav_lab4.mpav_lab4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private lateinit var drawer: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = android.support.v7.app.ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, StartFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_start)

        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_start -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                StartFragment()
            ).commit()
            R.id.nav_projects -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                ProjectsFragment()
            ).commit()
            R.id.nav_address -> supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                AddressFragment()
            ).commit()
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
