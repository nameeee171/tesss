package com.umm.bioskop;

/**
 * Tiket VIP dengan tambahan biaya layanan di atas harga dasar film.
 *
 * @author Praktikan Pemrograman Lanjut
 * @version 1.0
 */
public class TiketVIP extends Tiket {
    /** Biaya tambahan tiket VIP dalam rupiah. */
    public static final double BIAYA_VIP = 25000;

    /**
     * Membuat tiket VIP baru.
     *
     * @param film   film yang ditonton
     * @param studio studio tempat film diputar
     * @param kursi  kode kursi yang dipesan
     */
    public TiketVIP(Film film, Studio studio, String kursi) {
        super(film, studio, kursi);
    }

    /**
     * Mengambil nama jenis tiket.
     *
     * @return "VIP"
     */
    @Override
    public String getJenis() {
        return "VIP";
    }

    /**
     * Menghitung harga tiket VIP.
     *
     * @return harga dasar film ditambah {@link #BIAYA_VIP}
     */
    @Override
    public double hitungHarga() {
        return getFilm().getHarga() + BIAYA_VIP;
    }
}
