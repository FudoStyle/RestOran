package fr.isen.carcreff.restoran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.carcreff.restoran.databinding.ActivityRegisterBinding
import org.json.JSONObject


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registration()
    }


    private fun registration () {
        val intent1 = Intent(this, LoginActivity::class.java)
        val intent2 = Intent(this, LoginActivity::class.java)

        binding.register2.setOnClickListener(){

        if (validateUserName() && validateLastName() && validatePassword() && validateConfirmPassword() && validateMail() && validateAddress()){
                    val firstname = binding.firstName.text.toString()
                    val lastname = binding.lastName.text.toString()
                    val address = binding.address.text.toString()
                    val email = binding.email.text.toString()
                    val password = binding.password1.text.toString()


                    val url = "http://test.api.catering.bluecodegames.com/user/register"
                    val jsonObject = JSONObject()
                    jsonObject.put("id_shop", "1")
                    jsonObject.put("firstname", firstname)
                    jsonObject.put("lastname", lastname)
                    jsonObject.put("address", address)
                    jsonObject.put("email", email)
                    jsonObject.put("password", password)


                    val jsonRequest = JsonObjectRequest(
                        Request.Method.POST, url, jsonObject, { response ->
                            var gson = Gson()
                            Log.d("", "$response")
                        }, {
                            Log.e("", "erreur lors de la récupération")
                        })
                    Volley.newRequestQueue(this).add(jsonRequest)

            startActivity(intent1)
            }
        }

        binding.connect2.setOnClickListener(){

            startActivity(intent2)
        }
    }

    private fun validateUserName(): Boolean {
        if (binding.firstName.text.toString().trim().isEmpty()) {
            Toast.makeText(this,"please input data, edit text cannot be blank",Toast.LENGTH_LONG).show()
            binding.firstName.requestFocus()
            return false
        }
        return true
    }

    private fun validateLastName(): Boolean {
        if (binding.lastName.text.toString().trim().isEmpty()) {
            Toast.makeText(this,"please input data, edit text cannot be blank",Toast.LENGTH_LONG).show()
            binding.lastName.requestFocus()
            return false
        }
        return true
    }

    private fun validateMail(): Boolean {
        if (binding.email.text.toString().trim().isEmpty()) {
            Toast.makeText(this,"please input data, edit text cannot be blank",Toast.LENGTH_LONG).show()
            binding.email.requestFocus()
            return false
        }
        return true
    }

    private fun validateAddress(): Boolean {
        if (binding.address.text.toString().trim().isEmpty()) {
            Toast.makeText(this,"please input data, edit text cannot be blank",Toast.LENGTH_LONG).show()
            binding.address.requestFocus()
            return false
        }
        return true
    }


    private fun validatePassword(): Boolean {
        if (binding.password1.text.toString().trim().isEmpty()) {
            Toast.makeText(this,"please input data, edit text cannot be blank",Toast.LENGTH_LONG).show()
            binding.password1.requestFocus()
            return false
        } else if (binding.password1.text.toString().length < 6) {
            Toast.makeText(this, "Password need to be longer than 6", Toast.LENGTH_LONG).show()
            binding.password1.requestFocus()
            return false
        }
        return true
    }

    private fun validateConfirmPassword(): Boolean {
        when {
            binding.password2.text.toString().trim().isEmpty() -> {
                Toast.makeText(this,"please input data, edit text cannot be blank",Toast.LENGTH_LONG).show()
                binding.password2.requestFocus()
                return false
            }
            binding.password2.text.toString() != binding.password1.text.toString() -> {
                Toast.makeText(this,"password doesn't match",Toast.LENGTH_LONG).show()
                binding.password2.requestFocus()
                return false
            }
        }
        return true
    }
}