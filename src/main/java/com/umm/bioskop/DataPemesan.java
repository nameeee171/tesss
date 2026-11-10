package com.umm.bioskop;

/**
 * Data identitas pemesan tiket (parameter object).
 *
 * @author Praktikan Pemrograman Lanjut
 * @version 1.0
 *
 * @param nama  nama lengkap pemesan
 * @param noHp  nomor telepon pemesan
 * @param email alamat email pemesan
 */
public record DataPemesan(String nama, String noHp, String email) {
}
