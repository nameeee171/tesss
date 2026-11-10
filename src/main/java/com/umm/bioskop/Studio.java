package com.umm.bioskop;

/**
 * Merepresentasikan sebuah studio bioskop beserta status kursinya.
 * Kursi dinamai dengan huruf baris dan nomor kolom, misalnya "A1" atau "C5".
 *
 * @author Praktikan Pemrograman Lanjut
 * @version 1.0
 */
public class Studio {
    private final String nama;
    private final int jumlahBaris;
    private final int jumlahKolom;
    private final boolean[][] terisi;

    /**
     * Membuat studio baru dengan semua kursi kosong.
     *
     * @param nama        nama studio, misalnya "Studio 1"
     * @param jumlahBaris jumlah baris kursi
     * @param jumlahKolom jumlah kursi pada setiap baris
     */
    public Studio(String nama, int jumlahBaris, int jumlahKolom) {
        this.nama = nama;
        this.jumlahBaris = jumlahBaris;
        this.jumlahKolom = jumlahKolom;
        this.terisi = new boolean[jumlahBaris][jumlahKolom];
    }

    /**
     * Mengambil nama studio.
     *
     * @return nama studio
     */
    public String getNama() {
        return nama;
    }

    /**
     * Menghitung jumlah kursi yang masih kosong.
     *
     * @return jumlah kursi tersedia
     */
    public int getJumlahKursiTersedia() {
        int tersedia = 0;
        for (int i = 0; i < jumlahBaris; i++) {
            for (int j = 0; j < jumlahKolom; j++) {
                if (!terisi[i][j]) {
                    tersedia++;
                }
            }
        }
        return tersedia;
    }

    /**
     * Memesan sebuah kursi sehingga statusnya menjadi terisi.
     *
     * @param kode kode kursi, misalnya "A1"
     * @throws IllegalArgumentException jika format kode salah atau kursi tidak ada di studio
     * @throws IllegalStateException    jika kursi sudah dipesan
     */
    public void pesanKursi(String kode) {
        int[] posisi = parseKode(kode);
        if (terisi[posisi[0]][posisi[1]]) {
            throw new IllegalStateException("Kursi " + kode + " sudah dipesan");
        }
        terisi[posisi[0]][posisi[1]] = true;
    }

    /**
     * Mengubah kode kursi menjadi indeks baris dan kolom.
     *
     * @param kode kode kursi, misalnya "C5"
     * @return array dua elemen: indeks baris dan indeks kolom (mulai dari 0)
     * @throws IllegalArgumentException jika format kode salah atau kursi tidak ada di studio
     */
    private int[] parseKode(String kode) {
        if (kode == null || kode.length() < 2) {
            throw new IllegalArgumentException("Format kursi salah: " + kode);
        }
        int baris = Character.toUpperCase(kode.charAt(0)) - 'A';
        int kolom;
        try {
            kolom = Integer.parseInt(kode.substring(1)) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Format kursi salah: " + kode);
        }
        if (baris < 0 || baris >= jumlahBaris || kolom < 0 || kolom >= jumlahKolom) {
            throw new IllegalArgumentException("Kursi " + kode + " tidak ada di " + nama);
        }
        return new int[]{baris, kolom};
    }
}
