package com.example.apptransporte.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public Database (Context context){
        super(context, "TransporteUniversitario", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(createTableUniversidade());
        db.execSQL(createTablePassageiro());
        db.execSQL(createTableReserva());
        db.execSQL(createTableAdministrador());

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

    public static String createTablePassageiro(){
        StringBuilder scriptSQL = new StringBuilder();
        scriptSQL.append("CREATE TABLE IF NOT EXISTS Passageiro( ");
        scriptSQL.append("idPassageiro INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT, ");
        scriptSQL.append("cpfPassageiro VARCHAR (15) NOT NULL UNIQUE, ");
        scriptSQL.append("nomePassageiro VARCHAR (80) NOT NULL, ");
        scriptSQL.append("emailPassageiro VARCHAR (50) NOT NULL, ");
        scriptSQL.append("telefonePassageiro VARCHAR (18) NOT NULL, ");
        scriptSQL.append("enderecoPassageiro VARCHAR (100) NOT NULL, ");
        scriptSQL.append("idUniversidadeFk INTEGER NOT NULL, ");
        scriptSQL.append("senhaPassageiro VARCHAR (64) NOT NULL, ");
        scriptSQL.append("FOREIGN KEY (idUniversidadeFK) REFERENCES Universidade(idUniversidade) ");
        scriptSQL.append(") ");
        return scriptSQL.toString();
    }

    public static String createTableAdministrador(){
        StringBuilder        scriptSQL=new StringBuilder();
        scriptSQL.append("CREATE TABLE IF NOT EXISTS Administrador( ");
        scriptSQL.append("idAdministrador INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT, ");
        scriptSQL.append("cpfAdministrador VARCHAR (15) NOT NULL UNIQUE, ");
        scriptSQL.append("nomeAdministrador VARCHAR (80) NOT NULL, ");
        scriptSQL.append("emailAdministrador VARCHAR (50) NOT NULL, ");
        scriptSQL.append("telefoneAdministrador VARCHAR (18) NOT NULL, ");
        scriptSQL.append("senhaAdministrador VARCHAR (64) NOT NULL ");
        scriptSQL.append(") ");
        return scriptSQL.toString();
    }

    public static String createTableReserva(){
        StringBuilder scriptSQL = new StringBuilder();
        scriptSQL.append("CREATE TABLE IF NOT EXISTS Reserva( ");
        scriptSQL.append("idReserva INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT, ");
        scriptSQL.append("dataReserva VARCHAR (20) NOT NULL, ");
        scriptSQL.append("embarqueReserva VARCHAR (30) NOT NULL, ");
        scriptSQL.append("desembarqueReserva VARCHAR (30) NOT NULL, ");
        scriptSQL.append("idPassageiroFK INTEGER NOT NULL, ");
        scriptSQL.append("idUniversidadeFK INTEGER NOT NULL, ");
        scriptSQL.append("FOREIGN KEY (idPassageiroFK) REFERENCES Passageiro(idPassageiro), ");
        scriptSQL.append("FOREIGN KEY (idUniversidadeFK) REFERENCES Universidade(idUniversidade) ");
        scriptSQL.append(") ");
        return scriptSQL.toString();
    }


    // Método para inserir dados de teste na tabela Universidade
    private void insereDadosTeste(SQLiteDatabase db) {
        // Insere a primeira universidade
        ContentValues valores = new ContentValues();
        valores.put("nomeUniversidade", "Universidade Federal do Rio Grande do Sul");
        db.insert("Universidade", null, valores);

        // Insere a segunda universidade
        valores = new ContentValues();
        valores.put("nomeUniversidade", "Universidade de São Paulo");
        db.insert("Universidade", null, valores);


        //inserção de passageiro
        valores = new ContentValues();
        valores.put("cpfPassageiro", "12312312312");
        valores.put("nomePassageiro", "Pedro");
        valores.put("emailPassageiro", "p@email.com");
        valores.put("telefonePassageiro", "08768433");
        valores.put("enderecoPassageiro", "rua 1, n3, bairro x");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "1234");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "78978978978");
        valores.put("nomePassageiro", "João da Silva");
        valores.put("emailPassageiro", "joaodasilva@email.com");
        valores.put("telefonePassageiro", "37999000001");
        valores.put("enderecoPassageiro", "rua 3, n 30, bairro alto, Arcos");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "0000");
        db.insert("Passageiro", null, valores);

        //Inserção de Reserva
        valores = new ContentValues();
        valores.put("dataReserva", "segunda-feira");
        valores.put("embarqueReserva", "Ponto 1");
        valores.put("desembarqueReserva", "casa");
        valores.put("idPassageiroFK", 1);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        //Criação de administrador
        valores=new ContentValues();
        valores.put("cpfAdministrador", "12312312312");
        valores.put("nomeAdministrador", "Roberto Duque");
        valores.put("emailAdministrador", "robertoduque@email.com");
        valores.put("telefoneAdministrador", "37999999900");
        valores.put("senhaAdministrador", "admin");
        db.insert("Administrador", null, valores);
    }
}