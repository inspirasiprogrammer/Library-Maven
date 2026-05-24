package com.perpustakaan.model;

public class Buku {

    private String idBuku;
    private String judulBuku;
    private String penulis;
    private int stok;

    public Buku() {
    }

    public Buku(String idBuku, String judulBuku, String penulis, int stok) {
        this.idBuku = idBuku;
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.stok = stok;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
