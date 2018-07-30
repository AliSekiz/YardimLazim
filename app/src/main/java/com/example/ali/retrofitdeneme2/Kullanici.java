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
    @SerializedName("resimad")
    private String resimad;
    @SerializedName("reskategori")
    private String reskategori;
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

    public String getResimad() {
        return resimad;
    }

    public void setResimad(String resimad) {
        this.resimad = resimad;
    }

    public String getReskategori() {
        return reskategori;
    }

    public void setReskategori(String reskategori) {
        this.reskategori = reskategori;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }




   /* public Kullanici(String id, String kadi, String sifre,String kategori,String resimad,String reskategori, String resim) {
        this.id = id;
        this.kadi = kadi;
        this.sifre = sifre;
        this.kategori=kategori;
        this.resimad=resimad;
        this.reskategori=reskategori;
        this.resim=resim;
    }

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

    public String getResimad() {
        return resimad;
    }

    public void setResimad(String resimad) {
        this.resimad = resimad;
    }

    public String getReskategori() {
        return reskategori;
    }

    public void setReskategori(String reskategori) {
        this.reskategori = reskategori;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }*/
}
