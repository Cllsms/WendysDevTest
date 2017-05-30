package com.collinsims.wendysdevtest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.splash_screen.*

/**
 * This activity is the splash screen for the application. It is displayed after the app is
 * initially started and before the main activity is displayed.
 */

class splash_screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        progressBar.isIndeterminate = true
        progressBar.animate()

        /**
         * added a timer to this screen to simulate the app loading data for the main screen.
         */
        Handler().postDelayed({
            val intent: Intent = Intent(this, main_activity::class.java)
            startActivity(intent)
            finish()
        }, 750)
    }
}
