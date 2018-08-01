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
    TextView textView,textView1,textView2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        textView = (TextView) findViewById(R.id.adTvDetail);
        textView1 = (TextView) findViewById(R.id.kategoriTvDetail);
        textView2=(TextView)findViewById(R.id.textView9);
        imageView = (ImageView) findViewById(R.id.imageViewDetail);

        String adTv=getIntent().getStringExtra("ad");
        String kategoriTv=getIntent().getStringExtra("kategori");
        String kadiTv=getIntent().getStringExtra("kadi");

        textView.setText(adTv);
        textView1.setText(kategoriTv);
        textView2.setText(kadiTv);

        Picasso.get().load("http://192.168.1.103/yardimlazim/dosya/"+adTv+".jpg")
                .into(imageView);






    }

}
