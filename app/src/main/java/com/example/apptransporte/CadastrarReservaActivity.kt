package com.example.apptransporte

//import androidx.core.view.ViewCompat
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apptransporte.database.Database
import com.example.apptransporte.database.PersistenciaSQL
import com.example.apptransporte.databinding.ActivityCadastrarReservaBinding

class CadastrarReservaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCadastrarReservaBinding
    private lateinit var conexao: SQLiteDatabase
    private lateinit var db: Database
    private lateinit var persistencia: PersistenciaSQL

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
        conectaDatabase()

        val opcoesSpinnerEmbarque= arrayOf("Pulo do Gato", "Floricultura", "Posto Leão", "Ponte do Olaria")
        val adapterSpinnerEmbarque=ArrayAdapter(this, android.R.layout.simple_spinner_item, opcoesSpinnerEmbarque)
        adapterSpinnerEmbarque.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) //Adiciona um layout quando as opções aparecem no spinner para serem selecionadas
        binding.spinnerEmbSegunda.adapter=adapterSpinnerEmbarque
binding.spinnerEmbTerca.adapter=adapterSpinnerEmbarque
        binding.spinnerEmbQuarta.adapter=adapterSpinnerEmbarque
        binding.spinnerEmbQuinta.adapter=adapterSpinnerEmbarque
        binding.spinnerEmbSexta.adapter=adapterSpinnerEmbarque

        val opcoesSpinnerDesembarque= arrayOf("Pulo do Gato", "Floricultura", "Posto Leão", "Ponte do Olaria", "Casa")
        val adapterSpinnerDesembarque=ArrayAdapter(this, android.R.layout.simple_spinner_item, opcoesSpinnerDesembarque)
        adapterSpinnerDesembarque.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) //Adiciona um layout quando as opções aparecem no spinner para serem selecionadas
        binding.spinnerDesSegunda.adapter=adapterSpinnerDesembarque
        binding.spinnerDesTerca.adapter=adapterSpinnerDesembarque
        binding.spinnerDesQuarta.adapter=adapterSpinnerDesembarque
        binding.spinnerDesQuinta.adapter=adapterSpinnerDesembarque
        binding.spinnerDesSexta.adapter=adapterSpinnerDesembarque

        binding.buttonEnviar.setOnClickListener {
            if (binding.checkBoxSegunda.isChecked){
                val dataReserva: String="segunda-feira"
                val embarqueReserva=binding.spinnerEmbSegunda.selectedItem.toString()
                val desembarqueReserva=binding.spinnerDesSegunda.selectedItem.toString()
                persistencia.putReserva(dataReserva, embarqueReserva, desembarqueReserva, 1, 1)



                //binding.textViewTituloReserva.text=dataReserva
            }
            startActivity(Intent(this, PrincipalActivity::class.java))
            finish()
        }
    }


    private fun conectaDatabase() {
        db = Database(this)
        conexao = db.writableDatabase // Use writableDatabase para inserir dados
        persistencia = PersistenciaSQL(conexao)
    }
}