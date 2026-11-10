package com.umm.bioskop.latihan;

public abstract class Tiket {
    private final Film film;
    private final String kursi;

    protected Tiket(Film film, String kursi) {
        this.film = film;
        this.kursi = kursi;
    }

    public Film getFilm() {
        return film;
    }

    public String getKursi() {
        return kursi;
    }

    public abstract String getJenis();

    public abstract double hitungHarga();
}