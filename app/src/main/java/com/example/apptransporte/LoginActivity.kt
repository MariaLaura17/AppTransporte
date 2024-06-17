package com.example.apptransporte

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apptransporte.database.Database
import com.example.apptransporte.database.PersistenciaSQL
import com.example.apptransporte.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var conexao: SQLiteDatabase
    private lateinit var db: Database
    private lateinit var persistencia: PersistenciaSQL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        conectaDatabase()
        abrirPrincipalActivity()
    }

    private fun abrirPrincipalActivity() {
        binding.buttonLogin.setOnClickListener {


            if (binding.radioButtonAdm.isChecked){
                val seleciona = persistencia.selectAdministrador()
                val cpfConsulta: String=seleciona.get(0).cpfAdministrador
                val cpfDigitado: String=binding.editTextUsuario.text.toString()
                val senhaConsulta: String=seleciona.get(0).senhaAdministrador
                val senhaDigitada: String=binding.editTextPassword.text.toString()
                if (cpfDigitado==cpfConsulta && senhaDigitada==senhaConsulta){
                    startActivity(Intent(this, AdmPrincipalActivity::class.java))
                    finish()
                }
            }else if (binding.radioButtonPassageiro.isChecked){
                val seleciona = persistencia.selectPassageiro()
                val cpfConsulta: String=seleciona.get(0).cpf
                val cpfDigitado: String=binding.editTextUsuario.text.toString()
                val senhaConsulta: String=seleciona.get(0).senha
                val senhaDigitada: String=binding.editTextPassword.text.toString()
                if (cpfDigitado==cpfConsulta && senhaDigitada==senhaConsulta){
                    startActivity(Intent(this, PrincipalActivity::class.java))
                    finish()
                }
            }
        }
    }

    private fun conectaDatabase() {
        db = Database(this)
        conexao = db.writableDatabase // Use writableDatabase para inserir dados
        persistencia = PersistenciaSQL(conexao)
    }
}