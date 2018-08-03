package com.example.ali.retrofitdeneme2;

import com.google.gson.annotations.SerializedName;

public class Kullanici {
    @SerializedName("id")
    private String id;
    @SerializedName("kadi")
    private String kadi;
    @SerializedName("sifre")
    private String sifre;
    @SerializedName("kategori")
    private String kategori;
    @SerializedName("resim")
    private String resim;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKadi() {
        return kadi;
    }

    public void setKadi(String kadi) {
        this.kadi = kadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }


}
