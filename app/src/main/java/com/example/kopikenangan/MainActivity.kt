package com.example.kopikenangan

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kopikenangan.databinding.ActivityMainBinding
import com.example.kopikenangan.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.tabs.TabLayout.LabelVisibility

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNav : BottomNavigationView = binding.navView
        bottomNav.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
        bottomNav.itemIconSize = resources.getDimensionPixelSize(R.dimen.icon_size)
        bottomNav.setPadding(0,10,0,0)
        if (savedInstanceState == null)
            loadFragment(HomeFragment())

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> loadFragment(HomeFragment())
                R.id.navigation_order -> loadFragment(OrderFragment())
                R.id.navigation_scan -> loadFragment(ScanFragment())
                R.id.navigation_vip -> loadFragment(VIPFragment())
                R.id.navigation_profile -> loadFragment(ProfileFragment())
            }
        true
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
