package com.umar.tubespab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NavBar = findViewById<ChipNavigationBar>(R.id.ChipNavigationBar)

        val FragmentBeranda = FragmentBeranda()
        val FragmentRiwayat = FragmentRiwayat()
        val FragmentTentang = FragmentTentang()

        setCurrentFragment(FragmentBeranda)

        NavBar.setOnItemSelectedListener {
            id -> when(id) {
                R.id.beranda->setCurrentFragment(FragmentBeranda)
                R.id.riwayat->setCurrentFragment(FragmentRiwayat)
                R.id.tentang->setCurrentFragment(FragmentTentang)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment:Fragment) = supportFragmentManager.beginTransaction().apply {
            replace(R.id.ScreenFragment,  fragment)
            commit()
        }
}