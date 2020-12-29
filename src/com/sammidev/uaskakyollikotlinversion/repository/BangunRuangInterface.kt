package com.sammidev.uaskakyollikotlinversion.repository

import com.sammidev.uaskakyollikotlinversion.entity.*
import com.sammidev.uaskakyollikotlinversion.service.BangunRuangService
import kotlin.math.pow

class BangunRuangRepository : BangunRuangService{

    override fun luasBalok(balok: Balok): Double {
        return 2 * (balok.panjang * balok.lebar) + (balok.panjang + balok.tinggi) + (balok.lebar * balok.tinggi)
    }

    override fun volumeBalok(balok: Balok): Double {
        return balok.panjang * balok.lebar * balok.tinggi
    }

    override fun luasKubus(kubus: Kubus): Double {
        return 6 * kubus.sisi
    }

    override fun volumeKubus(kubus: Kubus): Double {
        return kubus.sisi.pow(3.0)
    }

    override fun luasLimas(limas: Limas): Double {
        return (limas.sisi.pow(2.0) + (limas.sisi * limas.tinggi * 4 / 2))
    }

    override fun kelilingLimas(limas: Limas): Double {
        return 0.3 * ((limas.sisi.pow(2.0) * (limas.sisi/2)))
    }

    override fun luasTabung(tabung: Tabung): Double {
        TODO("Not yet implemented")
    }

    override fun kelilingTabung(tabung: Tabung): Double {
        TODO("Not yet implemented")
    }

    override fun luasSelimutBola(bola: Bola): Double {
        TODO("Not yet implemented")
    }

    override fun volumeBola(bola: Bola): Double {
        TODO("Not yet implemented")
    }

    override fun luasSelimutKerucut(kerucut: Kerucut): Double {
        TODO("Not yet implemented")
    }

    override fun volumeKerucut(kerucut: Kerucut): Double {
        TODO("Not yet implemented")
    }

}