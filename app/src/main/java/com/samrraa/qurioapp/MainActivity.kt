package com.samrraa.qurioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentActivity
import com.samrraa.qurioapp.databinding.ActivityMainBinding
import com.samrraa.qurioapp.view.games.GamesFragment
import com.samrraa.qurioapp.view.home.HomeFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.homeFragment, HomeFragment())
            .commit()
    }
}
