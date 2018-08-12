package com.example.ali.retrofitdeneme2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Connect {
    @FormUrlEncoded
    @POST("personJson.php")
    Call<List<PersonClass>>getKullanici(@Field("kadi")String kadi, @Field("sifre")String sifre);

    @FormUrlEncoded
    @POST("addPerson.php")
    Call<PersonClass> addPerson(@Field("kadi")String kadi,
                                @Field("sifre")String sifre,
                                @Field("kategori") String kategori,
                                @Field("resim") String resim);
    @FormUrlEncoded
    @POST("addComment.php")
    Call<CommentClass> addComment(@Field("kadi")String kadi,
                                  @Field("yorum")String yorum);
    @FormUrlEncoded
    @POST("commentJson.php")
    Call<List<CommentClass>>getComment();

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
