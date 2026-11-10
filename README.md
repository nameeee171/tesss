# Pemesanan Tiket Bioskop

Program Java berbasis konsol untuk memesan tiket bioskop (reguler dan VIP).
Dibuat untuk praktikum **Pemrograman Lanjut, Modul 3**, Laboratorium Informatika,
Universitas Muhammadiyah Malang. Kode ini adalah hasil refactoring dari program
pada Modul 2 (lihat `PENJELASAN-REFACTORING.md` di paket tugas).

## Fitur Utama

- Data film (judul, genre, durasi, harga dasar)
- Studio dengan kursi berkode baris-kolom (contoh: `A1`, `C5`)
- Dua jenis tiket: **Reguler** (harga film) dan **VIP** (harga film + Rp25.000)
- Validasi kode kursi dan pencegahan pemesanan kursi ganda
- Diskon 10% jika subtotal melebihi Rp100.000, pajak 11%
- Pencetakan bukti pemesanan

## Struktur Proyek

```
src/main/java/com/umm/bioskop/
├── Film.java          # data film
├── Studio.java        # studio dan status kursi
├── Tiket.java         # superclass abstrak untuk semua tiket
├── TiketReguler.java  # tiket reguler
├── TiketVIP.java      # tiket VIP
├── DataPemesan.java   # data identitas pemesan (record)
├── Pemesanan.java     # transaksi, perhitungan diskon dan pajak
└── Main.java          # program demo
```

## Prasyarat

- JDK 17 atau lebih baru
- Maven 3.8+ (opsional, bisa juga compile manual)
- Git

## Instalasi

1. Clone repository

   ```bash
   git clone https://github.com/nameeee171/test.git
   ```

2. Masuk ke direktori proyek

   ```bash
   cd pemesanan-tiket-bioskop
   ```

3. Build proyek

   ```bash
   mvn compile
   ```

## Cara Menjalankan

Dengan Maven:

```bash
mvn exec:java
```

Atau tanpa Maven:

```bash
javac -d out src/main/java/com/umm/bioskop/*.java
java -cp out com.umm.bioskop.Main
```

## Contoh Output

```
Gagal: Kursi A1 sudah dipesan
Gagal: Kursi Z9 tidak ada di Studio 1
=================================
      BUKTI PEMESANAN TIKET
=================================
Pemesan : Budi
No. HP  : 081234567890
Email   : budi@mail.com
Jumlah tiket : 3
- [REGULER] Laskar Pelangi 2 | Studio 1 | Kursi A1 | Rp 45,000
- [REGULER] Laskar Pelangi 2 | Studio 1 | Kursi A2 | Rp 45,000
- [VIP] Laskar Pelangi 2 | Studio 1 | Kursi B1 | Rp 70,000
---------------------------------
Subtotal : Rp 160,000
Diskon   : Rp 16,000
Pajak    : Rp 15,840
TOTAL    : Rp 159,840
=================================
Sisa kursi: 37
```

## Membuat Dokumentasi JavaDoc

Di IntelliJ IDEA: **Tools > Generate JavaDoc**. Atau lewat Maven:

```bash
mvn javadoc:javadoc
```

Hasilnya ada di `target/site/apidocs/index.html`.

## Kontribusi

1. Fork repository ini
2. Buat branch fitur: `git checkout -b feature/nama-fitur`
3. Commit perubahan: `git commit -m "Tambah fitur ..."`
4. Push ke branch: `git push origin feature/nama-fitur`
5. Buka Pull Request

## Penyusun

Praktikan Pemrograman Lanjut, Informatika UMM, 2025.
