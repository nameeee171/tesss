package com.umm.bioskop;

import java.util.ArrayList;
import java.util.List;

/**
 * Mengelola satu transaksi pemesanan tiket oleh seorang pemesan.
 * Satu transaksi dapat berisi beberapa tiket reguler dan VIP.
 *
 * @author Praktikan Pemrograman Lanjut
 * @version 1.0
 */
public class Pemesanan {
    /** Batas subtotal (rupiah) agar mendapat diskon. */
    public static final double BATAS_DISKON = 100000;
    /** Besar diskon dalam bentuk pecahan (0.1 = 10%). */
    public static final double TARIF_DISKON = 0.1;
    /** Besar pajak dalam bentuk pecahan (0.11 = 11%). */
    public static final double TARIF_PAJAK = 0.11;

    private final DataPemesan pemesan;
    private final List<Tiket> daftarTiket = new ArrayList<>();

    /**
     * Membuat transaksi pemesanan baru.
     *
     * @param pemesan data identitas pemesan
     */
    public Pemesanan(DataPemesan pemesan) {
        this.pemesan = pemesan;
    }

    /**
     * Menambahkan tiket reguler dan menandai kursinya sebagai terisi.
     *
     * @param film   film yang dipilih
     * @param studio studio tempat film diputar
     * @param kursi  kode kursi, misalnya "A1"
     * @throws IllegalArgumentException jika kode kursi tidak valid
     * @throws IllegalStateException    jika kursi sudah dipesan
     */
    public void tambahTiketReguler(Film film, Studio studio, String kursi) {
        studio.pesanKursi(kursi);
        daftarTiket.add(new TiketReguler(film, studio, kursi));
    }

    /**
     * Menambahkan tiket VIP dan menandai kursinya sebagai terisi.
     *
     * @param film   film yang dipilih
     * @param studio studio tempat film diputar
     * @param kursi  kode kursi, misalnya "B1"
     * @throws IllegalArgumentException jika kode kursi tidak valid
     * @throws IllegalStateException    jika kursi sudah dipesan
     */
    public void tambahTiketVip(Film film, Studio studio, String kursi) {
        studio.pesanKursi(kursi);
        daftarTiket.add(new TiketVIP(film, studio, kursi));
    }

    /**
     * Menghitung jumlah harga seluruh tiket sebelum diskon dan pajak.
     *
     * @return subtotal dalam rupiah
     */
    public double hitungSubtotal() {
        double subtotal = 0;
        for (Tiket tiket : daftarTiket) {
            subtotal += tiket.hitungHarga();
        }
        return subtotal;
    }

    /**
     * Menghitung diskon. Diskon diberikan jika subtotal melebihi {@link #BATAS_DISKON}.
     *
     * @param subtotal subtotal sebelum diskon
     * @return besar diskon dalam rupiah, 0 jika tidak berhak diskon
     */
    public double hitungDiskon(double subtotal) {
        if (subtotal > BATAS_DISKON) {
            return subtotal * TARIF_DISKON;
        }
        return 0;
    }

    /**
     * Menghitung pajak dari harga setelah diskon.
     *
     * @param setelahDiskon harga setelah dikurangi diskon
     * @return besar pajak dalam rupiah
     */
    public double hitungPajak(double setelahDiskon) {
        return setelahDiskon * TARIF_PAJAK;
    }

    /**
     * Mencetak bukti pemesanan ke layar.
     */
    public void cetak() {
        double subtotal = hitungSubtotal();
        double diskon = hitungDiskon(subtotal);
        double setelahDiskon = subtotal - diskon;
        double pajak = hitungPajak(setelahDiskon);
        double total = setelahDiskon + pajak;

        System.out.println("=================================");
        System.out.println("      BUKTI PEMESANAN TIKET");
        System.out.println("=================================");
        System.out.println("Pemesan : " + pemesan.nama());
        System.out.println("No. HP  : " + pemesan.noHp());
        System.out.println("Email   : " + pemesan.email());
        System.out.println("Jumlah tiket : " + daftarTiket.size());
        for (Tiket tiket : daftarTiket) {
            System.out.println("- [" + tiket.getJenis() + "] " + tiket.info()
                    + " | Rp " + String.format("%,.0f", tiket.hitungHarga()));
        }
        System.out.println("---------------------------------");
        System.out.printf("Subtotal : Rp %,.0f%n", subtotal);
        System.out.printf("Diskon   : Rp %,.0f%n", diskon);
        System.out.printf("Pajak    : Rp %,.0f%n", pajak);
        System.out.printf("TOTAL    : Rp %,.0f%n", total);
        System.out.println("=================================");
    }
}
