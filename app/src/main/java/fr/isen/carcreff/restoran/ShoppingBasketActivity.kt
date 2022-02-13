package fr.isen.carcreff.restoran

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import fr.isen.carcreff.restoran.databinding.ActivityShoppingBasketBinding
import java.io.File

class ShoppingBasketActivity : AppCompatActivity(), CellClickListener {
    private lateinit var binding: ActivityShoppingBasketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBasketBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val filename = "/basket.json"
        val file = File(cacheDir.absolutePath + filename)

        if (file.exists())
        {
            val lu = Gson().fromJson(file.readText(), SavedFoodInBasket::class.java)
            displayBasket(lu.list)
        }

        binding.validbasket.setOnClickListener {
            Toast.makeText(this,"Commande passée !", Toast.LENGTH_LONG).show()
        }

        binding.back.setOnClickListener {
            finish()
        }

        binding.toemptybasket.setOnClickListener{
            if (file.exists())
            {
                val result = file.delete()
                if (result) {
                    println("Deletion succeeded.")
                } else {
                    println("Deletion failed.")
                }

            }

            finish();
            overridePendingTransition(0, 0);
            startActivity(getIntent());
            overridePendingTransition(0, 0);

        }
    }

    private fun displayBasket(foodBasket: ArrayList<FoodBasket>) {
        val recyclerview = binding.listbasket
        recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = ShoppingBasketAdapter(foodBasket,this)
        recyclerview.adapter = adapter
    }

    override fun onCellClickListener(data: FoodModel) {
    }

    override fun onCellClickListenerBasket(data : FoodBasket) {
        val filename = "/basket.json"
        val file = File(cacheDir.absolutePath + filename)
        val lu = Gson().fromJson(file.readText(), SavedFoodInBasket::class.java)
        lu.list.remove(
            FoodBasket(data.itemfood,data.quantity)
        )
        file.writeText(Gson().toJson(SavedFoodInBasket(lu.list)))
        displayBasket(lu.list)
    }
}