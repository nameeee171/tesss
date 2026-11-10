package com.umm.bioskop;

/**
 * Merepresentasikan sebuah film yang sedang tayang di bioskop.
 *
 * @author Praktikan Pemrograman Lanjut
 * @version 1.0
 */
public class Film {
    private final String judul;
    private final String genre;
    private final int durasiMenit;
    private double harga;

    /**
     * Membuat objek film baru.
     *
     * @param judul       judul film
     * @param genre       genre film, misalnya "Drama" atau "Aksi"
     * @param durasiMenit durasi film dalam menit
     * @param harga       harga dasar satu tiket dalam rupiah
     */
    public Film(String judul, String genre, int durasiMenit, double harga) {
        this.judul = judul;
        this.genre = genre;
        this.durasiMenit = durasiMenit;
        this.harga = harga;
    }

    /**
     * Mengambil judul film.
     *
     * @return judul film
     */
    public String getJudul() {
        return judul;
    }

    /**
     * Mengambil genre film.
     *
     * @return genre film
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Mengambil durasi film.
     *
     * @return durasi dalam menit
     */
    public int getDurasiMenit() {
        return durasiMenit;
    }

    /**
     * Mengambil harga dasar tiket film.
     *
     * @return harga dasar dalam rupiah
     */
    public double getHarga() {
        return harga;
    }

    /**
     * Mengubah harga dasar tiket film.
     *
     * @param harga harga dasar baru dalam rupiah
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }
}
