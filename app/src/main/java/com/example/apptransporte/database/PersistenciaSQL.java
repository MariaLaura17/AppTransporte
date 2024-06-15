package com.example.apptransporte.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.apptransporte.model.Passageiro;
import com.example.apptransporte.model.Universidade;

import java.util.ArrayList;

public class PersistenciaSQL {
    private SQLiteDatabase conexao;

    public PersistenciaSQL(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public void putUniversidade(String nomeUniversidade){
        ContentValues insert = new ContentValues();
        insert.put("nomeUniversidade", nomeUniversidade);
        conexao.insert("Universidade", null, insert);
    }

    // Retorna uma lista de nomes das universidades
    public ArrayList<Universidade> selectUniversidade(){
        ArrayList<Universidade> universidade = new ArrayList<>();
        String select = "SELECT * FROM Universidade";
        Cursor consulta = conexao.rawQuery(select, null);

        if (consulta.moveToFirst()){
            do {
                int idUniversidade =consulta.getInt(0);
                String nomeUniversidade = consulta.getString(1);
                universidade.add(new Universidade(idUniversidade, nomeUniversidade));
            } while (consulta.moveToNext());
        }
        return universidade;
    }

    // Retorna uma lista de nomes dos passageiros
    public ArrayList<Passageiro> selectPassageiro(){
        ArrayList<Passageiro> passageiro = new ArrayList<>();
        String select = "SELECT * FROM Passageiro";
        Cursor consulta = conexao.rawQuery(select, null);

        if (consulta.moveToFirst()){
            do {
                int idPassageiro=consulta.getInt(0);
                String cpfPassageiro=consulta.getString(1);
                String nomePassageiro=consulta.getString(2);
                String emailPassageiro=consulta.getString(3);
                String telefonePassageiro=consulta.getString(4);
                String enderecoPassageiro=consulta.getString(5);
                int idUniversidadeFk=consulta.getInt(6);
                String senhaPassageiro=consulta.getString(7);
                passageiro.add(new Passageiro(idPassageiro, cpfPassageiro, nomePassageiro, emailPassageiro, telefonePassageiro, enderecoPassageiro, idUniversidadeFk, senhaPassageiro));
            } while (consulta.moveToNext());
        }
        return passageiro;
    }

}