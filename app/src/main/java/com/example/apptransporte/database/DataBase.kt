package com.example.apptransporte.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBase (context: Context): SQLiteOpenHelper(context, "Banco.db", null,
    1){

    val sql = arrayOf(
        "create table Universidade (idUniversidade int auto_increment primary key, nomeUniversidade varchar (40) not null)",
        "create table Passageiro (cpfPassageiro varchar(15) not null unique primary key, nomePassageiro varchar (60) not null,  emailPassageiro varchar(50) not null, telefonePassageiro varchar(20) not null, enderecoPassageiro varchar (100) not null, idUniversidadeFk int not null, foreign key (idUniversidadeFk) references Universidade (idUniversidade))",
        "create table Reserva (idReserva int auto_increment primary key, dataReserva date not null, embarque varchar(30) not null, desembarque varchar(30) not null, cpfPassageiroFk varchar(15) not null, foreign key (cpfPassageiroFk) references Passageiro (cpfPassageiro), idUniversidadeFk int not null, foreign key (idUniversidadeFk) references Universidade (idUniversidade))"
        "INSERT INTO Universidade (nomeUniversidade) VALUES ('UNA Bom Despacho')"
        "INSERT INTO Passageiro (cpfPassageiro, nomePassageiro, emailPassageiro, telefonePassageiro, enderecoPassageiro, idUniversidadeFk) VALUES\n" +
                "    ('123.456.789-01', 'João da Silva', 'joao.silva@email.com', '(37) 9999-9999', 'Rua A, 123, Centro, Lagoa da Prata - MG', 1)"
        "INSERT INTO Passageiro (cpfPassageiro, nomePassageiro, emailPassageiro, telefonePassageiro, enderecoPassageiro, idUniversidadeFk) VALUES/n" +
                "('987.654.321-02', 'Maria da Cunha', 'maria.cunha@email.com', '(37) 8888-8888', 'Avenida B, 456, Bairro X, Lagoa da Prata - MG', 1)"
        "INSERT INTO Passageiro (cpfPassageiro, nomePassageiro, emailPassageiro, telefonePassageiro, enderecoPassageiro, idUniversidadeFk) VALUES/n" +
                "('456.789.012-03', 'Pedro Alves', 'pedro.alves@email.com', '(37) 7777-7777', 'Rua C, 789, Bairro Y, Lagoa da Prata - MG', 1)"
        "INSERT INTO Passageiro (cpfPassageiro, nomePassageiro, emailPassageiro, telefonePassageiro, enderecoPassageiro, idUniversidadeFk) VALUES/n" +
                ""
    )

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}