package fr.isen.carcreff.restoran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import fr.isen.carcreff.restoran.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val food = intent.getSerializableExtra("course") as FoodModel
        initDetail(food)
    }

    private fun initDetail (food: FoodModel) {
        binding.nameCourseTitle.text = food.name_fr

        binding.foodPhotoPager.adapter = FoodPictureAdapter(this, food.pictures)

        binding.descriptionAnnounce.text = food.ingredients.joinToString(", ") { it.name_fr }

        //button
        var numberFood = 1
        binding.add.text =
            "ajouter au panier : " + (food.prices[0].price.toFloat() * numberFood) + "€"

        //add
        binding.plusle.setOnClickListener {
            numberFood += 1
            binding.quantityAnnounce.text = "" + numberFood
            binding.add.text =
                "ajouter au panier : " + (food.prices[0].price.toFloat() * numberFood) + "€"

        }

        //less
        binding.minun.setOnClickListener {
            if (numberFood > 0) {
                numberFood -= 1
                binding.quantityAnnounce.text = "" + numberFood
                binding.add.text =
                    "ajouter au panier : " + (food.prices[0].price.toFloat() * numberFood) + "€"

            }
        }
    }
}