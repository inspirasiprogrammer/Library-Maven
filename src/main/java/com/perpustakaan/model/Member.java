package com.perpustakaan.model;

public class Member {

    private String idMember;
    private String namaMember;
    private String alamat;
    private int postal;

    public Member() {
    }

    public Member(String idMember, String namaMember, String alamat, int postal) {
        this.idMember = idMember;
        this.namaMember = namaMember;
        this.alamat = alamat;
        this.postal = postal;
    }

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getNamaMember() {
        return namaMember;
    }

    public void setNamaMember(String namaMember) {
        this.namaMember = namaMember;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getPostal() {
        return postal;
    }

    public void setPostal(int postal) {
        this.postal = postal;
    }
}
