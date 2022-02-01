package fr.isen.carcreff.restoran


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.carcreff.restoran.databinding.ActivityMainCourseBinding
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONObject



class MainCourseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainCourseBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val categoryType = intent.getStringExtra("category_type") ?: ""
        binding.mainCourseTitle.text = categoryType


        loadFoodsFromCategory(categoryType)
    }

    private fun loadFoodsFromCategory(categoryType: String){
        val url = "http://test.api.catering.bluecodegames.com/menu"

        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject, { response ->
                val foodResult = Gson().fromJson(response.toString(), FoodResult::class.java)
                displayFoods(foodResult.data.firstOrNull {category -> category.name_fr == categoryType}?.items ?: listOf())
            },{
                Log.e("MainCourseActivity", "erreur lors de la récupération de la liste des plats")
            })
        Volley.newRequestQueue(this).add(jsonRequest)
    }

    private fun displayFoods(courses: List<FoodModel>) {
        binding.mainCourseRecycler.layoutManager = LinearLayoutManager(this)
        binding.mainCourseRecycler.adapter = FoodAdapter(courses) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("course", it)
            startActivity(intent)
        }
    }

}


