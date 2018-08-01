package com.example.ali.retrofitdeneme2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StarterActivity extends AppCompatActivity {
    EditText kadiEdit,sifreEdit;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        kadiEdit=(EditText)findViewById(R.id.editText);
        sifreEdit=(EditText)findViewById(R.id.editText2);

        ((Button)findViewById(R.id.girisButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oturumAc(kadiEdit.getText().toString(),sifreEdit.getText().toString());

            }
        });
        ((Button)findViewById(R.id.kayıtOl)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(),AddPerson.class);
                    startActivity(intent);
                    finish();
            }
        });

    }
    public void oturumAc(final String kadi, String sifre){

        Connect connect= ApiClient.getRetrofit().create(Connect.class);
        Call<List<Kullanici>> call=connect.getKullanici(kadi,sifre);
        call.enqueue(new Callback<List<Kullanici>>() {
            @Override
            public void onResponse(Call<List<Kullanici>> call, Response<List<Kullanici>> response) {
                if(response.isSuccessful()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("kadi",kadiEdit.getText().toString());
                    startActivity(intent);
                    finish();

                }
                else {


                }
            }

            @Override
            public void onFailure(Call<List<Kullanici>> call, Throwable t) {
                String hata=kadiEdit.getText().toString();
                Toast.makeText(getApplicationContext(),hata+" böyle bir kullanıcı bulunamadı.",Toast.LENGTH_LONG).show();
                Log.d("Hata","Burdayımmmm");

            }
        });

    }
}