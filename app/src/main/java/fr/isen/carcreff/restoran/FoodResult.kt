package fr.isen.carcreff.restoran

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FoodResult(val data: List<CategoryModel>) : Serializable

class CategoryModel(val name_fr: String, val items: List<FoodModel>): Serializable

class FoodModel(
    val name_fr: String,
    @SerializedName("images") val pictures: List<String>,
    val prices: List<Price>
): Serializable{
    fun getFirstPicture() = if(pictures[0].isNotEmpty()) pictures[0] else null
    fun getFormattedPrice() = prices[0].price + "€"
}

class Price(val price: String): Serializable


