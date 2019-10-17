package com.sam43.mindvalleyimageloaderapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sam43.mindvalleyimageloaderapplication.session.Session
import com.sam43.mindvalleyimageloaderapplication.utils.ConnectivityReceiver
import com.sam43.mindvalleyimageloaderapplication.utils.showNetworkMessage

class MainActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showNetworkMessage(isConnected, findViewById<ConstraintLayout>(R.id.container))
        if (isConnected)
            initVM()
    }

    private fun initVM() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSession()
        initNavigationHost()
    }

    private fun initNavigationHost() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun initSession() {
        Session.init(applicationContext)
    }

}
