package ca.havensoft.tamilrhymingdictionary.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import ca.havensoft.tamilrhymingdictionary.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    // This makes the NavHostFragment intercept navigation up
    override fun onSupportNavigateUp() = findNavController(R.id.my_nav_host_fragment).navigateUp()
}
