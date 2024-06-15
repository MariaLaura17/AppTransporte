package com.example.apptransporte.model

class Passageiro(
    val id: Int=0,
    val cpf: String="",
    val nome: String="",
    val email: String="",
    val telefone: String="",
    val endereco: String="",
    val idUniversidadeFK: Int=0,
    val senha: String="") {
    override fun toString():String{
        return "Passageiro(id='$id', cpf='$cpf', nome='$nome', email='$email', telefone='$telefone', endereco='$endereco', idUniversidadeFK='$idUniversidadeFK', senha='$senha')"
    }

}