package fr.isen.carcreff.restoran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import fr.isen.carcreff.restoran.databinding.ActivityLoginBinding
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registration()
    }


    private fun registration () {
        val intent1 = Intent(this, HomeActivity::class.java)
        val intent2 = Intent(this, RegisterActivity::class.java)


        binding.Connect.setOnClickListener(){

            if (validateMail() && validateConfirmPassword()){
                startActivity(intent1)
            }
        }

        binding.register.setOnClickListener(){

            startActivity(intent2)
        }
    }


    private fun validateMail(): Boolean {
        if (binding.loginEmail.text.toString().trim().isEmpty()) {
            Toast.makeText(this,"please input data, edit text cannot be blank", Toast.LENGTH_LONG).show()
            binding.loginEmail.requestFocus()
            return false
        }
        return true
    }


    private fun validateConfirmPassword(): Boolean {
        when {
            binding.password.text.toString().trim().isEmpty() -> {
                Toast.makeText(this,"please input data, edit text cannot be blank", Toast.LENGTH_LONG).show()
                binding.password.requestFocus()
                return false
            }
            binding.password.text.toString() != "fruit" -> {
                Toast.makeText(this,"password doesn't match", Toast.LENGTH_LONG).show()
                binding.password.requestFocus()
                return false
            }
        }
        return true
    }
}