package com.example.apptransporte.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.apptransporte.model.Passageiro

class DataBase (context: Context): SQLiteOpenHelper(context, "Banco.db", null,
    1){

    val sql = arrayOf(
        "create table universidade (idUniversidade INTEGER primary key, nomeUniversidade varchar (40) not null)",
        "create table Passageiro (idPassageiro integer primary key,cpfPassageiro varchar(15) not null unique, nomePassageiro varchar (60) not null, emailPassageiro varchar(50) not null, telefonePassageiro varchar(20) not null, enderecoPassageiro varchar (100) not null, idUniversidadeFk integer not null, senha varchar(128) not null)",
        "CREATE TABLE Reserva (idReserva INTEGER PRIMARY KEY, dataReserva DATE NOT NULL, embarque VARCHAR(30) NOT NULL, desembarque VARCHAR(30) NOT NULL, idPassageiroFK INTEGER NOT NULL, idUniversidadeFk INTEGER NOT NULL)",
        "INSERT INTO Universidade (nomeUniversidade) VALUES ('UNA Bom Despacho')",
        "INSERT INTO Passageiro (cpfPassageiro, nomePassageiro, emailPassageiro, telefonePassageiro, enderecoPassageiro, idUniversidadeFk, senha) VALUES('123.456.789-01', 'João da Silva', 'joao.silva@email.com', '(37) 9999-9999', 'Rua A, 123, Centro, Lagoa da Prata - MG', 1, 'abcd1234')",
        "INSERT INTO Passageiro (cpfPassageiro, nomePassageiro, emailPassageiro, telefonePassageiro, enderecoPassageiro, idUniversidadeFk, senha) VALUES('987.654.321-02', 'Maria da Cunha', 'maria.cunha@email.com', '(37) 8888-8888', 'Avenida B, 456, Bairro X, Lagoa da Prata - MG', 1, 'erjr4361')",
        "INSERT INTO Passageiro (cpfPassageiro, nomePassageiro, emailPassageiro, telefonePassageiro, enderecoPassageiro, idUniversidadeFk, senha) VALUES('456.789.012-03', 'Pedro Alves', 'pedro.alves@email.com', '(37) 7777-7777', 'Rua C, 789, Bairro Y, Lagoa da Prata - MG', 1, 'krog4264')",
        "INSERT INTO Passageiro (cpfPassageiro, nomePassageiro, emailPassageiro, telefonePassageiro, enderecoPassageiro, idUniversidadeFk, senha) VALUES('789.012.345-04', 'Ana Souza', 'ana.souza@email.com', '(37) 6666-6666', 'Avenida D, 1011, Bairro Z, Lagoa da Prata - MG', 1, 'jbru5303')",
        "INSERT INTO Passageiro (cpfPassageiro, nomePassageiro, emailPassageiro, telefonePassageiro, enderecoPassageiro, idUniversidadeFk, senha) VALUES('789.012.335-01', 'Ana Souza Rabelo', 'ana.souzarabelo@email.com', '(37) 6662-6366', 'Avenida D, 10145, Bairro Z, Lagoa da Prata - MG', 1, 'bqz.0153')"
    )

    override fun onCreate(db: SQLiteDatabase) {
        sql.forEach {
            db.execSQL(it)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun getQueryData ():Cursor{
        val db = this.readableDatabase
        val query =db.rawQuery("SELECT * FROM passageiro", null)
        return query
    }

    fun getQueryDataForArray(): ArrayList<Passageiro>{
        val db=this.readableDatabase
        val query=db.rawQuery("SELECT * FROM passageiro", null)
        val dataList: ArrayList<Passageiro> = ArrayList() //Criando variável do tipo ArrayList que receberá objetos do tipo Passageiro e atribuindo uma instância de uma nova ArrayList() vazia
        val idIndex = query.getColumnIndex("idPassageiro")
        val cpfIndex=query.getColumnIndex("cpfPassageiro")
        val nomeIndex=query.getColumnIndex("nomePassageiro")
        val emailIndex=query.getColumnIndex("emailPassageiro")
        val telefoneIndex=query.getColumnIndex("telefonePassageiro")
        val enderecoIndex=query.getColumnIndex("enderecoPassageiro")
        val idUniversidadeFKIndex=query.getColumnIndex("idUniversidadeFK")
        val senhaIndex=query.getColumnIndex("senha")

        if (query.count>0){
            query.moveToFirst()
            do {
                val id = query.getInt(idIndex)
                val cpf = query.getString(cpfIndex)
                val nome = query.getString(nomeIndex)
                val email = query.getString(emailIndex)
                val telefone = query.getString(telefoneIndex)
                val endereco = query.getString(enderecoIndex)
                val idUniversidadeFK = query.getInt(idUniversidadeFKIndex)
                val senha = query.getString(senhaIndex)
                dataList.add(Passageiro(id, cpf, nome, email, telefone, endereco, idUniversidadeFK, senha))
            }while (query.moveToNext())
        }
        return dataList
    }

}