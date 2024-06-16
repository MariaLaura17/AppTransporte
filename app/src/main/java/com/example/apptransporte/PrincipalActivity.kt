package com.example.apptransporte

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
import com.example.apptransporte.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding
    private lateinit var conexao: SQLiteDatabase
    private lateinit var db: Database
    private lateinit var persistencia: PersistenciaSQL

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

        try {
            conectaDatabase()

            //aqui se tem que recuperar cpf
            val seleciona = persistencia.selectPassageiro()
            val cpf: String=seleciona.get(1).cpf
            binding.textViewRodape.text=cpf

            // Cria um ArrayAdapter para o ListView
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, seleciona)

            // Define o ArrayAdapter como adaptador do ListView
            binding.listviewprincipalpassageiro.adapter = adapter
        } catch (e: Exception) {
            // Trata erros de acesso ao banco de dados
            binding.textViewRodape.text = "Erro ao conectar ao banco de dados"
        }
    }

    private fun conectaDatabase() {
        db = Database(this)
        conexao = db.writableDatabase // Use writableDatabase para inserir dados
        persistencia = PersistenciaSQL(conexao)
    }

    private fun abrirCadastrarReservaActivity() {
        binding.fabReservarViagem.setOnClickListener {
            startActivity(Intent(this, CadastrarReservaActivity::class.java))
        }
    }
}
