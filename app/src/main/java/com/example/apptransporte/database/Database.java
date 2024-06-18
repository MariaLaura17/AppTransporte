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


    // Método para inserir dados de teste na tabela
    private void insereDadosTeste(SQLiteDatabase db) {
        ContentValues valores;
        criarUniversidade(db);
        criarPassageiro(db);
        criarReserva(db);

        //Criação de administrador
        valores=new ContentValues();
        valores.put("cpfAdministrador", "12312312312");
        valores.put("nomeAdministrador", "Roberto Duque");
        valores.put("emailAdministrador", "robertoduque@email.com");
        valores.put("telefoneAdministrador", "37999999900");
        valores.put("senhaAdministrador", "admin");
        db.insert("Administrador", null, valores);
    }

    private static void criarReserva(SQLiteDatabase db) {
        ContentValues valores;
        //Inserção de Reserva
        valores = new ContentValues();
        valores.put("dataReserva", "segunda-feira");
        valores.put("embarqueReserva", "Pulo do Gato");
        valores.put("desembarqueReserva", "Casa");
        valores.put("idPassageiroFK", 1);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "terça-feira");
        valores.put("embarqueReserva", "Pulo do Gato");
        valores.put("desembarqueReserva", "Casa");
        valores.put("idPassageiroFK", 1);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "terça-feira");
        valores.put("embarqueReserva", "Floricultura");
        valores.put("desembarqueReserva", "Posto Leão");
        valores.put("idPassageiroFK", 3);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "terça-feira");
        valores.put("embarqueReserva", "Posto Leão");
        valores.put("desembarqueReserva", "Ponte do Olaria");
        valores.put("idPassageiroFK", 5);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "terça-feira");
        valores.put("embarqueReserva", "Ponte do Olaria");
        valores.put("desembarqueReserva", "Pulo do Gato");
        valores.put("idPassageiroFK", 7);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "terça-feira");
        valores.put("embarqueReserva", "Pulo do Gato");
        valores.put("desembarqueReserva", "Floricultura");
        valores.put("idPassageiroFK", 9);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "terça-feira");
        valores.put("embarqueReserva", "Floricultura");
        valores.put("desembarqueReserva", "Casa");
        valores.put("idPassageiroFK", 11);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "terça-feira");
        valores.put("embarqueReserva", "Posto Leão");
        valores.put("desembarqueReserva", "Pulo do Gato");
        valores.put("idPassageiroFK", 13);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "terça-feira");
        valores.put("embarqueReserva", "Ponte do Olaria");
        valores.put("desembarqueReserva", "Floricultura");
        valores.put("idPassageiroFK", 21);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "segunda-feira");
        valores.put("embarqueReserva", "Floricultura");
        valores.put("desembarqueReserva", "Posto Leão");
        valores.put("idPassageiroFK", 3);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "segunda-feira");
        valores.put("embarqueReserva", "Posto Leão");
        valores.put("desembarqueReserva", "Ponte do Olaria");
        valores.put("idPassageiroFK", 5);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "segunda-feira");
        valores.put("embarqueReserva", "Ponte do Olaria");
        valores.put("desembarqueReserva", "Pulo do Gato");
        valores.put("idPassageiroFK", 7);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "segunda-feira");
        valores.put("embarqueReserva", "Pulo do Gato");
        valores.put("desembarqueReserva", "Floricultura");
        valores.put("idPassageiroFK", 9);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "segunda-feira");
        valores.put("embarqueReserva", "Floricultura");
        valores.put("desembarqueReserva", "Casa");
        valores.put("idPassageiroFK", 11);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "segunda-feira");
        valores.put("embarqueReserva", "Posto Leão");
        valores.put("desembarqueReserva", "Pulo do Gato");
        valores.put("idPassageiroFK", 13);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "segunda-feira");
        valores.put("embarqueReserva", "Ponte do Olaria");
        valores.put("desembarqueReserva", "Floricultura");
        valores.put("idPassageiroFK", 15);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "quarta-feira");
        valores.put("embarqueReserva", "Pulo do Gato");
        valores.put("desembarqueReserva", "Casa");
        valores.put("idPassageiroFK", 2);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "quarta-feira");
        valores.put("embarqueReserva", "Floricultura");
        valores.put("desembarqueReserva", "Posto Leão");
        valores.put("idPassageiroFK", 4);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "quarta-feira");
        valores.put("embarqueReserva", "Posto Leão");
        valores.put("desembarqueReserva", "Ponte do Olaria");
        valores.put("idPassageiroFK", 6);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "quarta-feira");
        valores.put("embarqueReserva", "Ponte do Olaria");
        valores.put("desembarqueReserva", "Pulo do Gato");
        valores.put("idPassageiroFK", 8);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quarta-feira");
        valores.put("embarqueReserva", "Pulo do Gato");
        valores.put("desembarqueReserva", "Floricultura");
        valores.put("idPassageiroFK", 10);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quarta-feira");
        valores.put("embarqueReserva", "Floricultura");
        valores.put("desembarqueReserva", "Casa");
        valores.put("idPassageiroFK", 12);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quarta-feira");
        valores.put("embarqueReserva", "Posto Leão");
        valores.put("desembarqueReserva", "Pulo do Gato");
        valores.put("idPassageiroFK", 14);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quarta-feira");
        valores.put("embarqueReserva", "Ponte do Olaria");
        valores.put("desembarqueReserva", "Floricultura");
        valores.put("idPassageiroFK", 16);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


        valores = new ContentValues();
        valores.put("dataReserva", "quinta-feira");
        valores.put("embarqueReserva", "Pulo do Gato");
        valores.put("desembarqueReserva", "Casa");
        valores.put("idPassageiroFK", 3);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quinta-feira");
        valores.put("embarqueReserva", "Floricultura");
        valores.put("desembarqueReserva", "Pulo do Gato");
        valores.put("idPassageiroFK", 5);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quinta-feira");
        valores.put("embarqueReserva", "Posto Leão");
        valores.put("desembarqueReserva", "Ponte do Olaria");
        valores.put("idPassageiroFK", 7);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quinta-feira");
        valores.put("embarqueReserva", "Ponte do Olaria");
        valores.put("desembarqueReserva", "Floricultura");
        valores.put("idPassageiroFK", 9);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quinta-feira");
        valores.put("embarqueReserva", "Pulo do Gato");
        valores.put("desembarqueReserva", "Posto Leão");
        valores.put("idPassageiroFK", 11);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quinta-feira");
        valores.put("embarqueReserva", "Floricultura");
        valores.put("desembarqueReserva", "Casa");
        valores.put("idPassageiroFK", 13);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quinta-feira");
        valores.put("embarqueReserva", "Posto Leão");
        valores.put("desembarqueReserva", "Pulo do Gato");
        valores.put("idPassageiroFK", 15);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "quinta-feira");
        valores.put("embarqueReserva", "Ponte do Olaria");
        valores.put("desembarqueReserva", "Posto Leão");
        valores.put("idPassageiroFK", 17);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);


         valores = new ContentValues();
        valores.put("dataReserva", "sexta-feira");
        valores.put("embarqueReserva", "Pulo do Gato");
        valores.put("desembarqueReserva", "Casa");
        valores.put("idPassageiroFK", 1);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "sexta-feira");
        valores.put("embarqueReserva", "Floricultura");
        valores.put("desembarqueReserva", "Pulo do Gato");
        valores.put("idPassageiroFK", 3);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "sexta-feira");
        valores.put("embarqueReserva", "Posto Leão");
        valores.put("desembarqueReserva", "Ponte do Olaria");
        valores.put("idPassageiroFK", 5);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "sexta-feira");
        valores.put("embarqueReserva", "Ponte do Olaria");
        valores.put("desembarqueReserva", "Floricultura");
        valores.put("idPassageiroFK", 7);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "sexta-feira");
        valores.put("embarqueReserva", "Pulo do Gato");
        valores.put("desembarqueReserva", "Posto Leão");
        valores.put("idPassageiroFK", 9);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "sexta-feira");
        valores.put("embarqueReserva", "Floricultura");
        valores.put("desembarqueReserva", "Casa");
        valores.put("idPassageiroFK", 11);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "sexta-feira");
        valores.put("embarqueReserva", "Posto Leão");
        valores.put("desembarqueReserva", "Pulo do Gato");
        valores.put("idPassageiroFK", 13);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

        valores = new ContentValues();
        valores.put("dataReserva", "sexta-feira");
        valores.put("embarqueReserva", "Ponte do Olaria");
        valores.put("desembarqueReserva", "Posto Leão");
        valores.put("idPassageiroFK", 15);
        valores.put("idUniversidadeFK", 1);
        db.insert("Reserva", null, valores);

    }

    private static void criarUniversidade(SQLiteDatabase db) {
        // Insere a primeira universidade
        ContentValues valores = new ContentValues();
        valores.put("nomeUniversidade", "UNA - Bom Despacho");
        db.insert("Universidade", null, valores);

        // Insere a segunda universidade
        valores = new ContentValues();
        valores.put("nomeUniversidade", "UEMG Divinópolis");
        db.insert("Universidade", null, valores);
    }

    private static void criarPassageiro(SQLiteDatabase db) {
        ContentValues valores;
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
        valores.put("cpfPassageiro", "78978978000");
        valores.put("nomePassageiro", "João da Silva");
        valores.put("emailPassageiro", "joaodasilva@email.com");
        valores.put("telefonePassageiro", "37999000001");
        valores.put("enderecoPassageiro", "rua 3, n 30, bairro alto, Arcos");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "0000");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "12345678001");
        valores.put("nomePassageiro", "Maria Oliveira");
        valores.put("emailPassageiro", "maria.oliveira@email.com");
        valores.put("telefonePassageiro", "37999000002");
        valores.put("enderecoPassageiro", "Rua 5, n 50, Bairro Centro, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha123");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "23456789002");
        valores.put("nomePassageiro", "Carlos Pereira");
        valores.put("emailPassageiro", "carlos.pereira@email.com");
        valores.put("telefonePassageiro", "37999000003");
        valores.put("enderecoPassageiro", "Rua 10, n 100, Bairro Sul, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "1234abcd");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "34567890003");
        valores.put("nomePassageiro", "Ana Souza");
        valores.put("emailPassageiro", "ana.souza@email.com");
        valores.put("telefonePassageiro", "37999000004");
        valores.put("enderecoPassageiro", "Rua 15, n 150, Bairro Norte, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha456");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "45678901004");
        valores.put("nomePassageiro", "José Santos");
        valores.put("emailPassageiro", "jose.santos@email.com");
        valores.put("telefonePassageiro", "37999000005");
        valores.put("enderecoPassageiro", "Rua 20, n 200, Bairro Leste, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "abcd1234");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "56789012005");
        valores.put("nomePassageiro", "Paula Lima");
        valores.put("emailPassageiro", "paula.lima@email.com");
        valores.put("telefonePassageiro", "37999000006");
        valores.put("enderecoPassageiro", "Rua 25, n 250, Bairro Oeste, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "1234senha");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "67890123006");
        valores.put("nomePassageiro", "Lucas Fernandes");
        valores.put("emailPassageiro", "lucas.fernandes@email.com");
        valores.put("telefonePassageiro", "37999000017");
        valores.put("enderecoPassageiro", "Rua 80, n 800, Bairro Horizonte, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha890");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "78901234007");
        valores.put("nomePassageiro", "Mariana Ribeiro");
        valores.put("emailPassageiro", "mariana.ribeiro@email.com");
        valores.put("telefonePassageiro", "37999000018");
        valores.put("enderecoPassageiro", "Rua 85, n 850, Bairro Vila, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha234");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "89012345008");
        valores.put("nomePassageiro", "Eduardo Carvalho");
        valores.put("emailPassageiro", "eduardo.carvalho@email.com");
        valores.put("telefonePassageiro", "37999000019");
        valores.put("enderecoPassageiro", "Rua 90, n 900, Bairro Centro, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha567");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "90123456009");
        valores.put("nomePassageiro", "Aline Duarte");
        valores.put("emailPassageiro", "aline.duarte@email.com");
        valores.put("telefonePassageiro", "37999000020");
        valores.put("enderecoPassageiro", "Rua 95, n 950, Bairro Sul, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha890");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "01234567010");
        valores.put("nomePassageiro", "Thiago Nogueira");
        valores.put("emailPassageiro", "thiago.nogueira@email.com");
        valores.put("telefonePassageiro", "37999000021");
        valores.put("enderecoPassageiro", "Rua 100, n 1000, Bairro Leste, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha123");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "12345678011");
        valores.put("nomePassageiro", "Natália Correia");
        valores.put("emailPassageiro", "natalia.correia@email.com");
        valores.put("telefonePassageiro", "37999000032");
        valores.put("enderecoPassageiro", "Rua 155, n 1550, Bairro Leste, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha456");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "23456789012");
        valores.put("nomePassageiro", "Gabriel Monteiro");
        valores.put("emailPassageiro", "gabriel.monteiro@email.com");
        valores.put("telefonePassageiro", "37999000033");
        valores.put("enderecoPassageiro", "Rua 160, n 1600, Bairro Oeste, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha789");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "34567890013");
        valores.put("nomePassageiro", "Juliana Azevedo");
        valores.put("emailPassageiro", "juliana.azevedo@email.com");
        valores.put("telefonePassageiro", "37999000034");
        valores.put("enderecoPassageiro", "Rua 165, n 1650, Bairro Central, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha890");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "45678901014");
        valores.put("nomePassageiro", "Leonardo Ribeiro");
        valores.put("emailPassageiro", "leonardo.ribeiro@email.com");
        valores.put("telefonePassageiro", "37999000035");
        valores.put("enderecoPassageiro", "Rua 170, n 1700, Bairro Lago, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha234");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "56789012015");
        valores.put("nomePassageiro", "Larissa Lima");
        valores.put("emailPassageiro", "larissa.lima@email.com");
        valores.put("telefonePassageiro", "37999000036");
        valores.put("enderecoPassageiro", "Rua 175, n 1750, Bairro Colina, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha567");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "67890123016");
        valores.put("nomePassageiro", "Rafael Nunes");
        valores.put("emailPassageiro", "rafael.nunes@email.com");
        valores.put("telefonePassageiro", "37999000037");
        valores.put("enderecoPassageiro", "Rua 180, n 1800, Bairro Horizonte, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha890");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "78901234017");
        valores.put("nomePassageiro", "Carolina Souza");
        valores.put("emailPassageiro", "carolina.souza@email.com");
        valores.put("telefonePassageiro", "37999000038");
        valores.put("enderecoPassageiro", "Rua 185, n 1850, Bairro Jardim, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha234");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "89012345018");
        valores.put("nomePassageiro", "Marcelo Costa");
        valores.put("emailPassageiro", "marcelo.costa@email.com");
        valores.put("telefonePassageiro", "37999000039");
        valores.put("enderecoPassageiro", "Rua 190, n 1900, Bairro Planalto, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha567");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "90123456019");
        valores.put("nomePassageiro", "Tatiana Ferreira");
        valores.put("emailPassageiro", "tatiana.ferreira@email.com");
        valores.put("telefonePassageiro", "37999000040");
        valores.put("enderecoPassageiro", "Rua 195, n 1950, Bairro Mar, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha890");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "01234567020");
        valores.put("nomePassageiro", "Gustavo Martins");
        valores.put("emailPassageiro", "gustavo.martins@email.com");
        valores.put("telefonePassageiro", "37999000041");
        valores.put("enderecoPassageiro", "Rua 200, n 2000, Bairro Sul, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha123");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "12345678021");
        valores.put("nomePassageiro", "Daniela Campos");
        valores.put("emailPassageiro", "daniela.campos@email.com");
        valores.put("telefonePassageiro", "37999000042");
        valores.put("enderecoPassageiro", "Rua 205, n 2050, Bairro Leste, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha456");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "23456789022");
        valores.put("nomePassageiro", "Rafaela Mendes");
        valores.put("emailPassageiro", "rafaela.mendes@email.com");
        valores.put("telefonePassageiro", "37999000043");
        valores.put("enderecoPassageiro", "Rua 210, n 2100, Bairro Oeste, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha789");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "34567890023");
        valores.put("nomePassageiro", "Rodrigo Oliveira");
        valores.put("emailPassageiro", "rodrigo.oliveira@email.com");
        valores.put("telefonePassageiro", "37999000044");
        valores.put("enderecoPassageiro", "Rua 215, n 2150, Bairro Central, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha890");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "45678901024");
        valores.put("nomePassageiro", "Veronica Duarte");
        valores.put("emailPassageiro", "veronica.duarte@email.com");
        valores.put("telefonePassageiro", "37999000045");
        valores.put("enderecoPassageiro", "Rua 220, n 2200, Bairro Lago, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha234");
        db.insert("Passageiro", null, valores);

        valores = new ContentValues();
        valores.put("cpfPassageiro", "56789012025");
        valores.put("nomePassageiro", "Bruna Ferreira");
        valores.put("emailPassageiro", "bruna.ferreira@email.com");
        valores.put("telefonePassageiro", "37999000046");
        valores.put("enderecoPassageiro", "Rua 225, n 2250, Bairro Colina, Arcos/MG");
        valores.put("idUniversidadeFk", 1);
        valores.put("senhaPassageiro", "senha567");
        db.insert("Passageiro", null, valores);


    }
}