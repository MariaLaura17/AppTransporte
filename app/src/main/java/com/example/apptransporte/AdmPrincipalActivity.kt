package com.example.apptransporte

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apptransporte.database.Database
import com.example.apptransporte.database.PersistenciaSQL
import com.example.apptransporte.databinding.ActivityAdmPrincipalBinding

class AdmPrincipalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdmPrincipalBinding
    private lateinit var conexao: SQLiteDatabase
    private lateinit var db: Database
    private lateinit var persistencia: PersistenciaSQL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityAdmPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        conectaDatabase()
        abrirRelatorioActivity()

    }

    private fun abrirRelatorioActivity() {
        binding.buttonRelatorio.setOnClickListener{
            var diaRelatorio: String=""
            if (binding.radioButtonSegunda.isChecked) {
                diaRelatorio="segunda-feira"
            }else if (binding.radioButtonTerA.isChecked){
                diaRelatorio="terça-feira"
            }else if (binding.radioButtonQuarta.isChecked){
                diaRelatorio="quarta-feira"
            }else if (binding.radioButtonQuinta.isChecked){
                diaRelatorio="quinta-feira"
            }else if (binding.radioButtonSexta.isChecked){
                diaRelatorio="sexta-feira"
            }
            val intent=Intent (this, RelatorioActivity::class.java)
            intent.putExtra("diaRelatorio", diaRelatorio)
            startActivity(intent)
            finish()
        }
    }

    private fun conectaDatabase() {
        db = Database(this)
        conexao = db.writableDatabase // Use writableDatabase para inserir dados
        persistencia = PersistenciaSQL(conexao)
    }
}