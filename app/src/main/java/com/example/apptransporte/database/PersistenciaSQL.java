package com.example.apptransporte.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.apptransporte.model.Administrador;
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

    //Consulta administradores
    public ArrayList<Administrador> selectAdministrador(){
        ArrayList<Administrador> administrador = new ArrayList<>();
        String select = "SELECT * FROM Administrador";
        Cursor consulta = conexao.rawQuery(select, null);

        if (consulta.moveToFirst()){
            do {
                int idAdministrador=consulta.getInt(0);
                String cpfAdministrador=consulta.getString(1);
                String nomeAdministrador=consulta.getString(2);
                String emailAdministrador=consulta.getString(3);
                String telefoneAdministrador=consulta.getString(4);
                String senhaAdministrador=consulta.getString(5);
                administrador.add(new Administrador(idAdministrador, cpfAdministrador, nomeAdministrador, emailAdministrador, telefoneAdministrador, senhaAdministrador));
            } while (consulta.moveToNext());
        }
        return administrador;
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

    //Gera relatório de viagem
    public ArrayList<String> gerarRelatorio(String diaRelatorio){
        ArrayList<String> relatorio=new ArrayList<>();
        String select="SELECT p.nomePassageiro, r.embarqueReserva, r.desembarqueReserva FROM Passageiro p JOIN Reserva r ON p.idPassageiro = r.idPassageiroFK WHERE r.dataReserva = '"+diaRelatorio+"'";
        Cursor consulta = conexao.rawQuery(select, null);

        if (consulta.moveToFirst()){
            do {
                String nomePassageiro=consulta.getString(0);
                String embarqueReserva=consulta.getString(1);
                String desembarqueReserva=consulta.getString(2);
                String linhaRelatorio=nomePassageiro+" "+embarqueReserva+" "+desembarqueReserva;
                relatorio.add(linhaRelatorio);
            } while (consulta.moveToNext());
        }
        return relatorio;
    }

    //retorna consulta para validação de usuário
    public ArrayList<String> selectValidaUsuario(String cpfPassageiro)  {
        ArrayList<String> validaUsuario=new ArrayList<>();
        String select="SELECT idPassageiro, cpfPassageiro, senhaPassageiro FROM Passageiro WHERE cpfPassageiro = '"+cpfPassageiro+"'";
        Cursor consulta = conexao.rawQuery(select, null);

        if (consulta.moveToFirst()){
            do {
                int idPassageiro=consulta.getInt(0);
                String cpfPassageiroConsulta=consulta.getString(1);
                String senhaPassageiro=consulta.getString(2);
                validaUsuario.add(Integer.toString(idPassageiro));
                validaUsuario.add(cpfPassageiro);
                validaUsuario.add(senhaPassageiro);
            } while (consulta.moveToNext());
        }
        return validaUsuario;
    }

    //Consulta dias de viagem do passageiro
    public ArrayList<String> selectDiaReserva(int idPassageiro){
        ArrayList<String> reservaPassageiro=new ArrayList<>();
        String select="SELECT dataReserva FROM Reserva WHERE idPassageiroFK = '"+idPassageiro+"'";
        Cursor consulta = conexao.rawQuery(select, null);

        if (consulta.moveToFirst()){
            do {
                String dataReserva=consulta.getString(0);
                String linhaReservaPassageiro=dataReserva;
                reservaPassageiro.add(linhaReservaPassageiro);
            } while (consulta.moveToNext());
        }
        return reservaPassageiro;
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