package fr.isen.carcreff.restoran

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ShoppingBasketAdapter(private val List: List<FoodBasket>, private val cellClickListener: CellClickListener) : RecyclerView.Adapter<ShoppingBasketAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.views_foods, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val foodBasket = List[position]

        if(foodBasket.itemfood.pictures[0]!="") {
            Picasso.get()
                .load(foodBasket.itemfood.pictures[0])
                .error(R.drawable.miaoussanstable)
                .into(holder.itemImage)
        }

        else{
            holder.itemImage.setImageResource(R.drawable.miaoussanstable)
        }

        val totalPrice=  (foodBasket.itemfood.prices[0].price).toFloat()* foodBasket.quantity.toFloat()
        holder.itemText.text = foodBasket.quantity.toString() + " "+ foodBasket.itemfood.name_fr
        holder.itemPrice.text = totalPrice.toString() +" €"

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListenerBasket(foodBasket)
        }

    }


    override fun getItemCount(): Int {
        return List.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.itemimage)
        val itemText: TextView = itemView.findViewById(R.id.itemtext)
        val itemPrice: TextView = itemView.findViewById(R.id.itemprice)

    }



}

