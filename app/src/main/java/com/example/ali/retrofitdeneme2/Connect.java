package com.example.ali.retrofitdeneme2;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Connect {
    @FormUrlEncoded
    @POST("personJson.php")
    Call<List<Kullanici>>getKullanici(@Field("kadi")String kadi,@Field("sifre")String sifre);

    @FormUrlEncoded
    @POST("addPerson.php")
    Call<Kullanici> addPerson(@Field("kadi")String kadi,
                              @Field("sifre")String sifre,
                              @Field("kategori") String kategori,
                              @Field("resim") String resim);

    @GET("dataJson.php")
    Call<List<PostClass>>getItem();

    @FormUrlEncoded
    @POST("uploadPost.php")
    Call<PostClass>uploadPost(@Field("resimad")String ad,
                              @Field("reskategori")String kategori,
                              @Field("resim") String resim,
                              @Field("kadi")String kadi);
    @FormUrlEncoded
    @POST("deletePost")
    Call<PostClass>deletePost(@Field("resimad")String ad);


}
