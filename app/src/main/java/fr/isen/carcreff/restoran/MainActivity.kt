package fr.isen.carcreff.restoran

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val text = "Bienvenue"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()


        val starterButton =findViewById<Button>(R.id.starters)
        starterButton.setOnClickListener {

            val textStarter = "Menu des entrées"

            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, textStarter, duration)
            toast.show()

            val Intent = Intent(this,StarterActivity::class.java)
            startActivity(Intent)
        }

        val maincourseButton =findViewById<Button>(R.id.maincourse)
        maincourseButton.setOnClickListener {

            val textMainCourse = "Menu des plats"
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, textMainCourse, duration)
            toast.show()

            val Intent = Intent(this,MainCourseActivity::class.java)
            startActivity(Intent)
        }
    }
}

