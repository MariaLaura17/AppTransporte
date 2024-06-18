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
    private  var idPassageiro: Int=0


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

    }

    override fun onResume() {
        super.onResume()
        idPassageiro=intent.getIntExtra("idPassageiro", 0)
        try {
            conectaDatabase()
            val seleciona = persistencia.selectDiaReserva(idPassageiro)
            // Cria um ArrayAdapter para o ListView
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, seleciona)

            // Define o ArrayAdapter como adaptador do ListView
            binding.listviewprincipalpassageiro.adapter = adapter
            //notificar o listview de atualizações
            adapter.notifyDataSetChanged()
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
            val intent=Intent(this,  CadastrarReservaActivity::class.java)
            intent.putExtra("idPassageiro", idPassageiro)
            startActivity(intent)
            finish()
        }
    }
}
