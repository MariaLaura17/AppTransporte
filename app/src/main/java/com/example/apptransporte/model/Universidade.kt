package com.example.apptransporte.model

class Universidade(
    val idUniversidade: Int=0,
    val  nomeUniversidade: String="") {
    override fun toString(): String{
        return "Universidade(idUniversidade='$idUniversidade', nomeUniversidade='$nomeUniversidade')"
    }

}