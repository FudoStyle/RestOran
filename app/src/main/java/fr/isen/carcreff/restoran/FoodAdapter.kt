package fr.isen.carcreff.restoran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.ImageLoader

import com.android.volley.RequestQueue
import com.squareup.picasso.Picasso
import fr.isen.carcreff.restoran.databinding.ViewsFoodsBinding

class FoodAdapter(private val courses: List<FoodModel>, val onCourseClicked: (FoodModel) -> Unit) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    // Holds the views for adding it to image and text
    class ViewHolder(binding: ViewsFoodsBinding) : RecyclerView.ViewHolder(binding.root) {
        val foodPicture: ImageView = binding.itemimage
        val textView: TextView = binding.itemtext
        val foodPrice: TextView = binding.itemprice
        val cross: ImageView = binding.cross
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // inflates the card_view_design view
        // that is used to hold list item
        val binding = ViewsFoodsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val rank = courses[position]

        holder.textView.text = rank.name_fr
        //holder.foodPicture.setImageResource(rank.getFirstPicture())

        Picasso.get()
            .load(rank.getFirstPicture())
            .error(R.drawable.meal1)
            .placeholder(R.drawable.meal1)
            .into(holder.foodPicture)

        holder.foodPrice.text = rank.getFormattedPrice()

        holder.itemView.setOnClickListener{
            onCourseClicked(rank)
        }

        holder.cross.setVisibility(View.INVISIBLE);
    }

    // return the number of the items in the list
    override fun getItemCount(): Int = courses.size
}