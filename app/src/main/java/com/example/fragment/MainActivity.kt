package com.example.fragment

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.fragment.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    lateinit var toggle: ActionBarDrawerToggle

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: ActivityMainBinding
    private lateinit var listener:NavController.OnDestinationChangedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_main)

        drawerLayout = binding.drawerLayout
        val navCtrl = this.findNavController(R.id.navhost_fragment)
        NavigationUI.setupActionBarWithNavController(this, navCtrl , drawerLayout)
        NavigationUI.setupWithNavController(binding.navView , navCtrl)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(toggle)


        navCtrl.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.halamanKategori-> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                    toggle.isDrawerIndicatorEnabled = true
                }
                else -> {
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                    toggle.isDrawerIndicatorEnabled = false
                }
            }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Check if the hamburger menu icon was clicked
        if (toggle.onOptionsItemSelected(item)) {
            // Close the drawer if it was open
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                // Open the drawer if it was closed
                drawerLayout.openDrawer(GravityCompat.START)
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navCtrl = findNavController(R.id.navhost_fragment)
        return NavigationUI.navigateUp(navCtrl ,drawerLayout)

    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle", "onPause dipanggil ")
    }


    override fun onResume() {
        super.onResume()
        Log.i("lifecycle", "onResume dipanggil")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lifecycle", "onRestart dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle", "onStop dipanggil")
    }
}