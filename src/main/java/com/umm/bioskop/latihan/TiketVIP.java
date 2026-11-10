package com.umm.bioskop.latihan;

public class TiketVIP extends Tiket {
    private static final double BIAYA_VIP = 25000;

    public TiketVIP(Film film, String kursi) {
        super(film, kursi);
    }

    @Override
    public String getJenis() {
        return "VIP";
    }

    @Override
    public double hitungHarga() {
        return getFilm().getHarga() + BIAYA_VIP;
    }
}