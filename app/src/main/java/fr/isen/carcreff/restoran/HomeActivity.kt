package fr.isen.carcreff.restoran

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import fr.isen.carcreff.restoran.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.starters.setOnClickListener {
        changeActivity(getString(R.string.starters_home))
        }

        binding.maincourse.setOnClickListener {
            changeActivity(getString(R.string.maincourse_home))
        }

        binding.dessert.setOnClickListener {
            changeActivity(getString(R.string.dessert_home))
        }

    }

    private fun changeActivity(category: String){
        val intent = Intent(this, MainCourseActivity::class.java)
        intent.putExtra("category_type", category)
        startActivity(intent)
    }

    override fun onStop(){
        super.onStop()
        Log.d("HomeActivity", "vous stoppez la page home")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("HomeActivity", "vous quittez la page home")
    }



}

