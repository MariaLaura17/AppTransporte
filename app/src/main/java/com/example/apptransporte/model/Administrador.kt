package com.example.apptransporte.model

class Administrador (
    val idAdministrador: Int=0,
    val cpfAdministrador: String="",
    val nomeAdministrador: String="",
    val emailAdministrador:String="",
    val telefoneAdministrador:String="",
    val senhaAdministrador:String=""){

    override fun toString(): String {
        return "Administrador(idAdministrador='$idAdministrador', cpfAdministrador='$cpfAdministrador', nomeAdministrador='$nomeAdministrador', emailAdministrador='$emailAdministrador', telefoneAdministrador='$telefoneAdministrador', senhaAdministrador='$senhaAdministrador'"
    }

}