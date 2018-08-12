package com.example.ali.retrofitdeneme2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    PersonClass personClass;
    ListView listView;
    TextView textView,textView1,textView2;
    EditText yorumEdit;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        textView = (TextView) findViewById(R.id.adTvDetail);
        textView1 = (TextView) findViewById(R.id.kategoriTvDetail);
        textView2=(TextView)findViewById(R.id.textView9);
        imageView = (ImageView) findViewById(R.id.imageViewDetail);
        listView = (ListView)findViewById(R.id.denemelv);
        yorumEdit=(EditText)findViewById(R.id.commentEdit);

        String adTv=getIntent().getStringExtra("ad");
        String kategoriTv=getIntent().getStringExtra("kategori");
        String kadiTv=getIntent().getStringExtra("kadi");

        textView.setText(adTv);
        textView1.setText(kategoriTv);
        textView2.setText(kadiTv);

        Picasso.get().load("http://fetihonal.com/yardimlazim/dosya/"+adTv+".jpg")
                .into(imageView);


    }
    public void addComment(){
        String kadi = personClass.getKadi().toString();
        String yorum=yorumEdit.getText().toString();
        Connect connect=ApiClient.getRetrofit().create(Connect.class);
        Call<CommentClass> call=connect.addComment(kadi,yorum);
        call.enqueue(new Callback<CommentClass>() {
            @Override
            public void onResponse(Call<CommentClass> call, Response<CommentClass> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Oldu",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CommentClass> call, Throwable t) {

            }
        });

    }

}
