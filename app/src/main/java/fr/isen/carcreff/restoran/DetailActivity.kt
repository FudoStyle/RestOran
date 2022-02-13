package fr.isen.carcreff.restoran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import fr.isen.carcreff.restoran.databinding.ActivityDetailBinding
import java.io.File


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val food = intent.getSerializableExtra("course") as FoodModel
        initDetail(food)

        binding.back3.setOnClickListener {
            finish()
        }
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

        binding.add.setOnClickListener() {
            val itemtoadd = FoodBasket(food, numberFood)
            val filename = "/basket.json"
            val file = File(cacheDir.absolutePath + filename)
            var quantityalreadyinbasket:Int =0
            var namealeradyinbasket :String =""
            var notinbasket:Boolean = false
            Snackbar.make(it, "Ajouté au panier", Snackbar.LENGTH_LONG).show()

            if (file.exists()) {
                var dishbasket = Gson().fromJson(file.readText(), SavedFoodInBasket::class.java)

                for (item in dishbasket.list) {
                    if (item.itemfood.name_fr == itemtoadd.itemfood.name_fr) {
                        quantityalreadyinbasket = itemtoadd.quantity + item.quantity
                        namealeradyinbasket = item.itemfood.name_fr
                        notinbasket=false
                    }
                    else {
                        notinbasket=true
                    }
                }

                if(dishbasket.list.size ==0) notinbasket=true
                if(notinbasket==true) dishbasket.list.add(itemtoadd)
                dishbasket.list.forEach {
                    if (it.itemfood.name_fr== namealeradyinbasket ) it.quantity = quantityalreadyinbasket}
                file.writeText(Gson().toJson(SavedFoodInBasket(dishbasket.list)))
            }
            else {
                file.writeText(Gson().toJson(SavedFoodInBasket(arrayListOf(itemtoadd))))
            }
        }
    }
}