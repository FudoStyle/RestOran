package fr.isen.carcreff.restoran

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.carcreff.restoran.databinding.ViewsDishesBinding


class FoodAdapter(private val courses: List<FoodViewModel>, val onCourseClicked: (FoodViewModel) -> Unit) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    // Holds the views for adding it to image and text
    class ViewHolder(binding: ViewsDishesBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.itemimage
        val textView: TextView = binding.itemtext
        val priceView: TextView = binding.itemprice
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // inflates the card_view_design view
        // that is used to hold list item
        val binding = ViewsDishesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val rank = courses[position]

        holder.imageView.setImageResource(rank.image)
        holder.textView.text = rank.text
        holder.priceView.text = rank.price

        holder.itemView.setOnClickListener{
            onCourseClicked(rank)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return courses.size
    }

}