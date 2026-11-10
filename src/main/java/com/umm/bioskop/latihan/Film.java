package com.umm.bioskop.latihan;

public class Film {
    private final String judul;
    private double harga;

    public Film(String judul, double harga) {
        this.judul = judul;
        this.harga = harga;
    }

    public String getJudul() {
        return judul;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}