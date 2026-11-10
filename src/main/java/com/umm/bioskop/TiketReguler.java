package com.umm.bioskop;

/**
 * Tiket reguler dengan harga sama seperti harga dasar film.
 *
 * @author Praktikan Pemrograman Lanjut
 * @version 1.0
 */
public class TiketReguler extends Tiket {

    /**
     * Membuat tiket reguler baru.
     *
     * @param film   film yang ditonton
     * @param studio studio tempat film diputar
     * @param kursi  kode kursi yang dipesan
     */
    public TiketReguler(Film film, Studio studio, String kursi) {
        super(film, studio, kursi);
    }

    /**
     * Mengambil nama jenis tiket.
     *
     * @return "REGULER"
     */
    @Override
    public String getJenis() {
        return "REGULER";
    }

    /**
     * Menghitung harga tiket reguler.
     *
     * @return harga dasar film
     */
    @Override
    public double hitungHarga() {
        return getFilm().getHarga();
    }
}
