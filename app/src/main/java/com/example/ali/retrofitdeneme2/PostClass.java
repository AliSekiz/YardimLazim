package com.example.ali.retrofitdeneme2;

import com.google.gson.annotations.SerializedName;

public class PostClass {
    @SerializedName("resimad")
    private String resimad;
    @SerializedName("reskategori")
    private String reskategori;
    @SerializedName("resim")
    private String resim;
    @SerializedName("kadi")
    private String kadi;

    public String getKadi() {
        return kadi;
    }

    public void setKadi(String kadi) {
        this.kadi = kadi;
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
}
