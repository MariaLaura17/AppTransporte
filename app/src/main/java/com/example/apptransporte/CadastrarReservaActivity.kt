package com.example.apptransporte

//import androidx.core.view.ViewCompat
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apptransporte.databinding.ActivityCadastrarReservaBinding

class CadastrarReservaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarReservaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflate the layout using Data Binding
        binding = ActivityCadastrarReservaBinding.inflate(layoutInflater)
        setContentView(binding.root) // Set the inflated layout as content view


        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.buttonEnviar.setOnClickListener {
            /*            if (binding.checkBoxSegunda.isChecked){
            //val agenda = Agenda()
            }*/

        }
    }
}