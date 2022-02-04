package fr.isen.carcreff.restoran

import android.net.UrlQuerySanitizer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import fr.isen.carcreff.restoran.databinding.FragmentFoodPictureBinding


class FoodPictureFragment : Fragment() {
    private lateinit var binding: FragmentFoodPictureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("picture_url")?.let { pictureUrl ->
            Picasso.get()
                .load(pictureUrl)
                .placeholder(R.drawable.miaoussanstable)
                .into(binding.foodPictureFrag)
        }
    }

    companion object{
        fun newInstance(pictureUrl:String) =
            FoodPictureFragment().apply{
                arguments = Bundle().apply  {
                    putString("picture_url", pictureUrl)}
            }

    }
}