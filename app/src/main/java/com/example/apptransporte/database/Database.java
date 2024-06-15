package com.example.apptransporte.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database (Context context){
        super(context, "TransporteUniversitario", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(createTableUniversidade());
        db.execSQL(createPassageiro());

        // Insere dados de teste aqui
        insereDadosTeste(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }

    public static String createTableUniversidade(){
        StringBuilder scriptSQL = new StringBuilder();
        scriptSQL.append("CREATE TABLE IF NOT EXISTS Universidade( ");
        scriptSQL.append("idUniversidade INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT,  ");
        scriptSQL.append("nomeUniversidade VARCHAR(40) ");
        scriptSQL.append(") ");

        return scriptSQL.toString();
    }

    public static String createPassageiro(){
        StringBuilder scriptSQL = new StringBuilder();
        scriptSQL.append("CREATE TABLE IF NOT EXISTS Passageiro( ");
        scriptSQL.append("idPassageiro INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT, ");
        scriptSQL.append("cpfPassageiro VARCHAR (15) NOT NULL UNIQUE, ");
        scriptSQL.append("nomePassageiro VARCHAR (80) NOT NULL, ");
        scriptSQL.append("emailPassageiro VARCHAR (50) NOT NULL, ");
        scriptSQL.append("telefonePassageiro VARCHAR (18) NOT NULL, ");
        scriptSQL.append("enderecoPassageiro VARCHAR (100) NOT NULL, ");
        scriptSQL.append("idUniversidadeFk INTEGER NOT NULL, ");
        scriptSQL.append("senhaPassageiro VARCHAR (64) NOT NULL ");
        scriptSQL.append(") ");
        return scriptSQL.toString();
    }

    // Método para inserir dados de teste na tabela Universidade
    private void insereDadosTeste(SQLiteDatabase db) {
        //inserção de passageiro
        ContentValues valores = new ContentValues();
        valores.put("cpfPassageiro", "123");
        valores.put("nomePassageiro", "Pedro");
        valores.put("emailPassageiro", "p@email.com");
        valores.put("telefonePassageiro", "08768433");
        valores.put("enderecoPassageiro", "rua 1, n3, bairro x");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "34f8senha");
        db.insert("Passageiro", null, valores);


        // Insere a primeira universidade
        valores = new ContentValues();
        valores.put("nomeUniversidade", "Universidade Federal do Rio Grande do Sul");
        db.insert("Universidade", null, valores);

        // Insere a segunda universidade
        valores = new ContentValues();
        valores.put("nomeUniversidade", "Universidade de São Paulo");
        db.insert("Universidade", null, valores);

    }
}