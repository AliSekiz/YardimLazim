package com.example.ali.retrofitdeneme2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    TextView textView,textView1;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        textView = (TextView) findViewById(R.id.adTvDetail);
        textView1 = (TextView) findViewById(R.id.kategoriTvDetail);
        imageView = (ImageView) findViewById(R.id.imageViewDetail);

        String adTv=getIntent().getStringExtra("ad");
        String kategoriTv=getIntent().getStringExtra("kategori");

        textView.setText(adTv);
        textView1.setText(kategoriTv);

        Picasso.get().load("http://gadraj.com/alimobil/yardimlazim/"+adTv+".jpg")
                .into(imageView);






    }

}
