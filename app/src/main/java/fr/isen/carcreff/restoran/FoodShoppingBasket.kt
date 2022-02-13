package fr.isen.carcreff.restoran

import java.io.Serializable


data class SavedFoodInBasket (val list : ArrayList<FoodBasket>) : Serializable
data class FoodBasket(val itemfood : FoodModel, var quantity : Int): Serializable