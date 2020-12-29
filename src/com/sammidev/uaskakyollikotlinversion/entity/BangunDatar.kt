package com.sammidev.uaskakyollikotlinversion.entity

data class SegitigaSikuSiku(var alas: Double, var tinggi: Double)
data class SegitigaSembarang(var sisiA: Double,var sisiB: Double,var sisiC: Double)
data class SegitigaSamaSisi(var sisi: Double)
data class Persegi(var sisi: Double)
data class Lingkaran(var jariJari: Double)
data class Trapesium(var sisiAB: Double,var sisiBC: Double,var sisiCD: Double,var sisiAD: Double, var tinggi: Double)
data class PersegiPanjang(var panjang: Double,var lebar: Double )
data class BelahKetupat(var diagonal1: Double, var diagonal2: Double, var sisi: Double)
data class JajarGenjang(var alas: Double,var tinggi: Double,var sisMiring: Double)