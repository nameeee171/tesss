package com.umm.bioskop;

/**
 * Kelas utama untuk mendemonstrasikan program pemesanan tiket bioskop.
 *
 * @author Praktikan Pemrograman Lanjut
 * @version 1.0
 */
public class Main {
    /**
     * Titik masuk program.
     *
     * @param args argumen command line (tidak digunakan)
     */
    public static void main(String[] args) {
        Film film = new Film("Laskar Pelangi 2", "Drama", 120, 45000);
        Studio studio = new Studio("Studio 1", 5, 8);
        Pemesanan pemesanan = new Pemesanan(new DataPemesan("Budi", "081234567890", "budi@mail.com"));

        pemesanan.tambahTiketReguler(film, studio, "A1");
        pemesanan.tambahTiketReguler(film, studio, "A2");
        pemesanan.tambahTiketVip(film, studio, "B1");
        try {
            pemesanan.tambahTiketReguler(film, studio, "A1");
        } catch (IllegalStateException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
        try {
            pemesanan.tambahTiketReguler(film, studio, "Z9");
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
        pemesanan.cetak();
        System.out.println("Sisa kursi: " + studio.getJumlahKursiTersedia());
    }
}
