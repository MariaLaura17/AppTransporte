package com.example.apptransporte

import android.R
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apptransporte.database.Database
import com.example.apptransporte.database.PersistenciaSQL
import com.example.apptransporte.databinding.ActivityRelatorioBinding

class RelatorioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRelatorioBinding
    private lateinit var conexao: SQLiteDatabase
    private lateinit var db: Database
    private lateinit var persistencia: PersistenciaSQL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityRelatorioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        conectaDatabase()
        val diaRelatorio=intent.getStringExtra("diaRelatorio")
        //aqui se tem que recuperar cpf
        val seleciona = persistencia.gerarRelatorio(diaRelatorio)
        // Cria um ArrayAdapter para o ListView
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_activated_1, seleciona)
        binding.listView.adapter=adapter

        cliqueFAB()
    }

    private fun cliqueFAB() {
        binding.floatingActionButton.setOnClickListener {

            startActivity(Intent(this, AdmPrincipalActivity::class.java))
            finish()
        }
    }

    private fun conectaDatabase() {
        db = Database(this)
        conexao = db.writableDatabase // Use writableDatabase para inserir dados
        persistencia = PersistenciaSQL(conexao)
    }
}