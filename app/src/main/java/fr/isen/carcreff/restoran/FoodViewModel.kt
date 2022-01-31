package fr.isen.carcreff.restoran

import java.io.Serializable

data class FoodViewModel(val image: Int, val text: String, val price: String): Serializable {

}