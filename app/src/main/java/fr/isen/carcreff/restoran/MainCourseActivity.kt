package fr.isen.carcreff.restoran


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.carcreff.restoran.databinding.ActivityMainCourseBinding
import androidx.recyclerview.widget.RecyclerView


class MainCourseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainCourseBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainCourseTitle.text = intent.getStringExtra("category_type")


        // getting the recyclerview by its id

        val recyclerview = findViewById<RecyclerView>(R.id.mainCourseRecycler)

        // this creates a vertical layout Manager
        binding.mainCourseRecycler.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view

            data.add(ItemsViewModel(R.drawable.cook, "Item " + 1))
            data.add(ItemsViewModel(R.drawable.berries, "Item " + 2))


        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}


