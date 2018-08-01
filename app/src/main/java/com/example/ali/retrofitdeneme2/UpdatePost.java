package com.example.ali.retrofitdeneme2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdatePost extends AppCompatActivity {
    Bundle bundle;
    EditText adEdit,kategoriEdit;
    ImageView resimView;
    private static final int request=777;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_post);

        adEdit=(EditText)findViewById(R.id.adEdit);
        kategoriEdit=(EditText)findViewById(R.id.kategoriEdit);
        resimView=(ImageView)findViewById(R.id.resimView);

        bundle=getIntent().getExtras();

        ((ImageView)findViewById(R.id.resimView)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage();

            }
        });
        ((Button)findViewById(R.id.kaydetButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadPost();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void uploadPost(){
        String kadi=bundle.getString("kadi");
        String resim=imageToString();
        String ad=adEdit.getText().toString();
        String kategori=kategoriEdit.getText().toString();


        Connect connect = ApiClient.getRetrofit().create(Connect.class);
        Call<PostClass>call=connect.uploadPost(ad,kategori,resim,kadi);
        call.enqueue(new Callback<PostClass>() {
            @Override
            public void onResponse(Call<PostClass> call, Response<PostClass> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Olmadı",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostClass> call, Throwable t) {

            }
        });
    }
    private void selectedImage(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,request);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==request && resultCode==RESULT_OK && data!=null){
            Uri path=data.getData();
            try {
                bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                resimView.setImageBitmap(bitmap);
            }catch (Exception e){e.printStackTrace();}
        }
    }
    private String imageToString(){
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
        byte[]imgByte=outputStream.toByteArray();
        return Base64.encodeToString(imgByte,Base64.DEFAULT);
    }
}
