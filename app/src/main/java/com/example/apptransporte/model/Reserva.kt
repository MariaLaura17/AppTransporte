package com.example.apptransporte.model

class Reserva (
    val idReserva: Int=0,
    val dataReserva: String="",
    val embarqueReserva: String="",
    val desembarqueReserva: String="",
    val idPassageiroFK: Int=0,
    val idUniversidadeFK: Int=0){

    override fun toString(): String{
        return "'$idReserva', '$dataReserva', '$embarqueReserva', '$desembarqueReserva', '$idPassageiroFK', '$idUniversidadeFK'"
    }
}