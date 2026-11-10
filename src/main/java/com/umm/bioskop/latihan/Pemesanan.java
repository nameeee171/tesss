package com.umm.bioskop.latihan;

public class Pemesanan {

    static double hitungPajak(double subtotal, double diskon) {
        return (subtotal - diskon) * 0.11;
    }

    static double hitungDiskon(double subtotal) {
        double diskon = 0;
        if (subtotal > 100000) {
            diskon = subtotal * 0.1;
        }
        return diskon;
    }

    static double hitungSubtotal(Tiket[] daftarTiket) {
        double subtotal = 0;
        for (Tiket tiket : daftarTiket) {
            subtotal += tiket.hitungHarga();
        }
        return subtotal;
    }

    static void cetakBukti(DataPemesan pemesan, Tiket[] daftarTiket,
                           double subtotal, double diskon, double pajak, double total) {
        System.out.println("Pemesan : " + pemesan.nama());
        System.out.println("No. HP  : " + pemesan.noHp());
        System.out.println("Email   : " + pemesan.email());
        for (Tiket tiket : daftarTiket) {
            System.out.println("- [" + tiket.getJenis() + "] " + tiket.getFilm().getJudul()
                    + " | Kursi " + tiket.getKursi());
        }
        System.out.printf("Subtotal : Rp %,.0f%n", subtotal);
        System.out.printf("Diskon   : Rp %,.0f%n", diskon);
        System.out.printf("Pajak    : Rp %,.0f%n", pajak);
        System.out.printf("TOTAL    : Rp %,.0f%n", total);
    }
}
