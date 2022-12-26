package com.example.testtaskshift.controlers.activities
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.testtaskshift.R
import com.example.testtaskshift.controlers.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager: FragmentManager = supportFragmentManager
        manager.beginTransaction()
            .add(R.id.cont_main, MainFragment(),"MAIN_FRAG" )
            .commit()

    }
}