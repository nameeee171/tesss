package com.umm.bioskop;

/**
 * Kelas induk (superclass) untuk semua jenis tiket bioskop.
 * Menyimpan data yang sama pada setiap tiket: film, studio, dan kursi.
 *
 * @author Praktikan Pemrograman Lanjut
 * @version 1.0
 */
public abstract class Tiket {
    private final Film film;
    private final Studio studio;
    private final String kursi;

    /**
     * Membuat tiket baru.
     *
     * @param film   film yang ditonton
     * @param studio studio tempat film diputar
     * @param kursi  kode kursi yang dipesan
     */
    protected Tiket(Film film, Studio studio, String kursi) {
        this.film = film;
        this.studio = studio;
        this.kursi = kursi;
    }

    /**
     * Mengambil film pada tiket ini.
     *
     * @return objek {@link Film}
     */
    public Film getFilm() {
        return film;
    }

    /**
     * Mengambil studio pada tiket ini.
     *
     * @return objek {@link Studio}
     */
    public Studio getStudio() {
        return studio;
    }

    /**
     * Mengambil kode kursi pada tiket ini.
     *
     * @return kode kursi sesuai input
     */
    public String getKursi() {
        return kursi;
    }

    /**
     * Menyusun ringkasan tiket dalam satu baris.
     *
     * @return teks berformat "judul | studio | Kursi X"
     */
    public String info() {
        return film.getJudul() + " | " + studio.getNama() + " | Kursi " + kursi.toUpperCase();
    }

    /**
     * Mengambil nama jenis tiket.
     *
     * @return nama jenis, misalnya "REGULER" atau "VIP"
     */
    public abstract String getJenis();

    /**
     * Menghitung harga tiket sesuai jenisnya.
     *
     * @return harga tiket dalam rupiah
     */
    public abstract double hitungHarga();
}
