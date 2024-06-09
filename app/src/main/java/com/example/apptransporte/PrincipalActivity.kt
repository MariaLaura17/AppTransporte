package com.example.apptransporte

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apptransporte.database.DataBase
import com.example.apptransporte.databinding.ActivityPrincipalBinding

class PrincipalActivity: AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        abrirCadastrarReservaActivity()
        val db=DataBase(this)
        val list=db.getQueryDataForArray()
        binding.listviewprincipalpassageiro.adapter=ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, list)
    }

    private fun abrirCadastrarReservaActivity() {
        binding.fabReservarViagem.setOnClickListener {
            startActivity(Intent(this, CadastrarReservaActivity::class.java))
        }
    }


}