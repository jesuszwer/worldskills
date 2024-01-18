package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.Event.EventFragment
import com.example.myapplication.Records.RecordsFragment
import com.example.myapplication.Tickets.TicketsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val myFragment: Fragment = MyFragment()
        fragmentTransaction.replace(R.id.fragment_container, myFragment)

        fragmentTransaction.commit()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation_panel)

        // Обработчики кнопок на панеле навигации
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_events -> {
                    replaceFragment(EventFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_tickets -> {
                    replaceFragment(TicketsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_records -> {
                    replaceFragment(RecordsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
        replaceFragment(EventFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}