package fr.isen.carcreff.restoran

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FoodPictureAdapter (activity: AppCompatActivity, val pictures:List<String>): FragmentStateAdapter(activity){
    override fun getItemCount(): Int = pictures.size

    override fun createFragment(position: Int): Fragment {
        return FoodPictureFragment.newInstance(pictures[position])
    }

}