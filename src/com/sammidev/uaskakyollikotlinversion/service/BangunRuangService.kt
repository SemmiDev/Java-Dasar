package com.sammidev.uaskakyollikotlinversion.service

import com.sammidev.uaskakyollikotlinversion.entity.*

interface BangunRuangService {
    fun luasBalok(balok: Balok): Double
    fun volumeBalok(balok: Balok): Double

    fun luasKubus(kubus: Kubus): Double
    fun volumeKubus(kubus: Kubus): Double

    fun luasLimas(limas: Limas): Double
    fun kelilingLimas(limas: Limas): Double

    fun luasTabung(tabung: Tabung): Double
    fun kelilingTabung(tabung: Tabung): Double

    fun luasSelimutBola(bola: Bola): Double
    fun volumeBola(bola: Bola): Double

    fun luasSelimutKerucut(kerucut: Kerucut): Double
    fun volumeKerucut(kerucut: Kerucut): Double
}