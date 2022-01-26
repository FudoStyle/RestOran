package fr.isen.carcreff.restoran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.carcreff.restoran.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nameCourseTitle.text = intent.getStringExtra("category_type")
    }


}