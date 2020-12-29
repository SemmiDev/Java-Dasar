package com.sammidev.uaskakyollikotlinversion.service

import com.sammidev.uaskakyollikotlinversion.entity.*

interface BangunDatarService {

    fun luasSegitigaSikuSiku(segitigaSikuSiku: SegitigaSikuSiku): Double
    fun kelilingSegitigaSikuSiku(segitigaSikuSiku: SegitigaSikuSiku): Double

    fun luasSegitigaSembarang(segitigaSembarang: SegitigaSembarang): Double
    fun kelilingSegitigaSembarang(segitigaSembarang: SegitigaSembarang): Double

    fun luasSegitigaSamaSisi(segitigaSamaSisi: SegitigaSamaSisi): Double
    fun kelilingSegitigaSamaSisi(segitigaSamaSisi: SegitigaSamaSisi): Double

    fun luasPersegi(persegi: Persegi): Double
    fun kelilingPersegi(persegi: Persegi): Double

    fun luasLingkaran(lingkaran: Lingkaran): Double
    fun kelilingLingkaran(lingkaran: Lingkaran): Double

    fun luasTrapesium(trapesium: Trapesium): Double
    fun kelilingTrapesium(trapesium: Trapesium): Double

    fun luasPersegiPanjang(persegipanjang: PersegiPanjang): Double
    fun kelilingPersegiPanjang(persegipanjang: PersegiPanjang): Double

    fun luasBelahKetupat(luasBelahKetupat: BelahKetupat): Double
    fun kelilingBelahKetupat(luasBelahKetupat: BelahKetupat): Double

    fun luasJajargenjang(jajarGenjang: JajarGenjang): Double
    fun kelilingJajargenjang(jajarGenjang: JajarGenjang): Double
}