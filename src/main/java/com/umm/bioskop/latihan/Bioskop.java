package com.umm.bioskop.latihan;

public class Bioskop {
    public static void main(String[] args) {
        Film film = new Film("Laskar Pelangi 2", 45000);
        DataPemesan pemesan = new DataPemesan("Budi", "081234567890", "budi@mail.com");
        Tiket[] daftarTiket = {
                new TiketReguler(film, "A1"),
                new TiketReguler(film, "A2"),
                new TiketVIP(film, "B1")
        };

        double subtotal = Pemesanan.hitungSubtotal(daftarTiket);
        double diskon = Pemesanan.hitungDiskon(subtotal);
        double pajak = Pemesanan.hitungPajak(subtotal, diskon);
        double total = subtotal - diskon + pajak;

        Pemesanan.cetakBukti(pemesan, daftarTiket, subtotal, diskon, pajak, total);
    }
}