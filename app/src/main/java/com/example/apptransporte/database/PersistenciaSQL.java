package com.example.apptransporte.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.apptransporte.model.Passageiro;
import com.example.apptransporte.model.Reserva;
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

    //Insere reserva
    public void putReserva(String dataReserva, String embarqueReserva, String desembarqueReserva, int idPassageiroFK, int idUniversidadeFK){
        ContentValues insert = new ContentValues();
        insert.put("dataReserva", dataReserva);
        insert.put("embarqueReserva", embarqueReserva);
        insert.put("desembarqueReserva", desembarqueReserva);
        insert.put("idPassageiroFK", idPassageiroFK);
        insert.put("idUniversidadeFK", idUniversidadeFK);
        conexao.insert("Reserva", null, insert);
    }

    // Retorna uma lista de registro de Reservas
    public ArrayList<Reserva> selectReserva(){
        ArrayList<Reserva> reserva = new ArrayList<>();
        String select = "SELECT * FROM Reserva";
        Cursor consulta = conexao.rawQuery(select, null);

        if (consulta.moveToFirst()){
            do {
                int idReserva=consulta.getInt(0);
                String dataReserva=consulta.getString(1);
                String embarqueReserva=consulta.getString(2);
                String desembarqueReserva=consulta.getString(3);
                int idPassageiroFK=consulta.getInt(4);
                int idUniversidadeFK=consulta.getInt(5);
                reserva.add(new Reserva(idReserva, dataReserva, embarqueReserva, desembarqueReserva, idPassageiroFK, idUniversidadeFK));
            } while (consulta.moveToNext());
        }
        return reserva;
    }

}