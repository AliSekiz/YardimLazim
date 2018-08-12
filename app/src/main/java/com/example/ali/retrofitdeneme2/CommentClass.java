package com.example.ali.retrofitdeneme2;

import com.google.gson.annotations.SerializedName;

public class CommentClass {
    @SerializedName("id")
    private String id;
    @SerializedName("kadi")
    private String kadi;
    @SerializedName("yorum")
    private String yorum;
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

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }
}
