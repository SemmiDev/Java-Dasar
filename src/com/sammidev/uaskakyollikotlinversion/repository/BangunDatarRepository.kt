package com.sammidev.uaskakyollikotlinversion.repository

import com.sammidev.uaskakyollikotlinversion.entity.*
import com.sammidev.uaskakyollikotlinversion.service.BangunDatarService
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

class BangunDatarRepository : BangunDatarService{
    override fun luasSegitigaSikuSiku(segitigaSikuSiku: SegitigaSikuSiku): Double {
        return (segitigaSikuSiku.alas * segitigaSikuSiku.tinggi) / 2
    }

    override fun kelilingSegitigaSikuSiku(segitigaSikuSiku: SegitigaSikuSiku): Double {
        return segitigaSikuSiku.alas * 3
    }

    override fun luasSegitigaSembarang(segitigaSembarang: SegitigaSembarang): Double {
        val sisi = (segitigaSembarang.sisiA + segitigaSembarang.sisiB + segitigaSembarang.sisiC) / 2
        return sqrt(sisi * (sisi - segitigaSembarang.sisiA) * (sisi - segitigaSembarang.sisiB) * (sisi - segitigaSembarang.sisiC))
    }

    override fun kelilingSegitigaSembarang(segitigaSembarang: SegitigaSembarang): Double {
        return segitigaSembarang.sisiA + segitigaSembarang.sisiB + segitigaSembarang.sisiC
    }

    override fun luasSegitigaSamaSisi(segitigaSamaSisi: SegitigaSamaSisi): Double {
        return (segitigaSamaSisi.sisi.pow(2) / 4) * sqrt(3.0)
    }

    override fun kelilingSegitigaSamaSisi(segitigaSamaSisi: SegitigaSamaSisi): Double {
        return segitigaSamaSisi.sisi * 3
    }

    override fun luasPersegi(persegi: Persegi): Double {
        return persegi.sisi.pow(2)
    }

    override fun kelilingPersegi(persegi: Persegi): Double {
        return 4 * persegi.sisi
    }

    override fun luasLingkaran(lingkaran: Lingkaran): Double {
        return PI * lingkaran.jariJari.pow(2)
    }

    override fun kelilingLingkaran(lingkaran: Lingkaran): Double {
        return 2 * PI * lingkaran.jariJari
    }

    override fun luasTrapesium(trapesium: Trapesium): Double {
        return (trapesium.sisiAB + trapesium.sisiCD) * (trapesium.tinggi * 0.5)
    }

    override fun kelilingTrapesium(trapesium: Trapesium): Double {
        return trapesium.sisiAB + trapesium.sisiBC + trapesium.sisiCD + trapesium.sisiAD
    }

    override fun luasPersegiPanjang(persegipanjang: PersegiPanjang): Double {
        return persegipanjang.panjang * persegipanjang.lebar
    }

    override fun kelilingPersegiPanjang(persegipanjang: PersegiPanjang): Double {
        return 2 * (persegipanjang.panjang + persegipanjang.lebar)
    }

    override fun luasBelahKetupat(belahKetupat: BelahKetupat): Double {
        return (belahKetupat.diagonal1 * belahKetupat.diagonal2) / 2
    }

    override fun kelilingBelahKetupat(belahKetupat: BelahKetupat): Double {
        return belahKetupat.sisi * 4
    }

    override fun luasJajargenjang(jajarGenjang: JajarGenjang): Double {
        return jajarGenjang.alas * jajarGenjang.tinggi
    }

    override fun kelilingJajargenjang(jajarGenjang: JajarGenjang): Double {
        return 2 * (jajarGenjang.alas + jajarGenjang.tinggi)
    }
}