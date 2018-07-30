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
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddPerson extends AppCompatActivity {
    EditText kadiEdit,sifreEdit,kategoriEdit;
    ImageView proPic;
    private static final int request=500;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        kadiEdit=(EditText)findViewById(R.id.kadiEdit);
        sifreEdit=(EditText)findViewById(R.id.sifreEdit);
        kategoriEdit=(EditText)findViewById(R.id.kategoriEdit);
        proPic=(ImageView)findViewById(R.id.addProPic);

        ((ImageView)findViewById(R.id.addProPic)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedProImage();
            }
        });
        ((Button)findViewById(R.id.addPersonButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPerson();
            }
        });
    }
    private void addPerson(){
        String resim=imageToString();
        String kadi=kadiEdit.getText().toString();
        String sifre=sifreEdit.getText().toString();
        String kategori=kategoriEdit.getText().toString();

        Connect connect=ApiClient.getRetrofit().create(Connect.class);
        Call<Kullanici> call=connect.addPerson(kadi,sifre,kategori,resim);
        call.enqueue(new Callback<Kullanici>() {
            @Override
            public void onResponse(Call<Kullanici> call, Response<Kullanici> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(), StarterActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Olmadı",Toast.LENGTH_LONG).show();
                }
               
            }

            @Override
            public void onFailure(Call<Kullanici> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Olmadı2",Toast.LENGTH_LONG).show();

            }
        });

    }
    private void selectedProImage(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,500);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==request && resultCode==RESULT_OK && data!=null){
            Uri path=data.getData();
            try{
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                proPic.setImageBitmap(bitmap);
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
