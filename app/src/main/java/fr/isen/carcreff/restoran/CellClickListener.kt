package fr.isen.carcreff.restoran

interface CellClickListener {
    fun onCellClickListener( data: FoodModel)
    fun onCellClickListenerBasket(data : FoodBasket)
}