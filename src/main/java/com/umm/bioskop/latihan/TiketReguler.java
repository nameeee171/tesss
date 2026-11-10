package com.umm.bioskop.latihan;

public class TiketReguler extends Tiket {

    public TiketReguler(Film film, String kursi) {
        super(film, kursi);
    }

    @Override
    public String getJenis() {
        return "REGULER";
    }

    @Override
    public double hitungHarga() {
        return getFilm().getHarga();
    }
}