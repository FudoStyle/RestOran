package fr.isen.carcreff.restoran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.carcreff.restoran.databinding.ActivityMainCourseBinding

class MainCourseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainCourseTitle.text = intent.getStringExtra("category_type")
    }

}