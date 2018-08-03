package com.example.ali.retrofitdeneme2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public List<PostClass> postList;
    String kadi;
    ListAdapter adapter;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.PostEkle:
                Intent intent = new Intent(getApplicationContext(), UpdatePost.class);
                intent.putExtra("kadi", kadi);
                startActivity(intent);
                break;
            case R.id.Yenile:
                getItem();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kadi=getIntent().getStringExtra("kadi");
        listView = (ListView) findViewById(R.id.listView);
        getItem();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(MainActivity.this);
                mBuilder.setTitle("Uyarı");
                mBuilder.setMessage("Seçilen ileti silinecektir. Emin misiniz?");
                mBuilder.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                         iptalMethod(kadi);
                         getItem();
                    }
                });
                mBuilder.setPositiveButton("Sil", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        silMethod(postList.get(position).getResimad().toString());
                    //    Toast.makeText(getApplicationContext(),postList.get(position).getResimad().toString(),Toast.LENGTH_LONG).show();
                       // getItem();
                    }
                });
                mBuilder.show();
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showSelectedItem(postList.get(position));

            }
        });

    }

    public void getItem() {
        Connect connect = ApiClient.getRetrofit().create(Connect.class);
        Call<List<PostClass>> call = connect.getItem();
        call.enqueue(new Callback<List<PostClass>>() {
            @Override
            public void onResponse(Call<List<PostClass>> call, Response<List<PostClass>> response) {
                postList = response.body();
                adapter = new ListAdapter(postList, MainActivity.this);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<PostClass>> call, Throwable t) {
                Log.d("Hata", "Burdayımmmm");
            }
        });
    }

    private void showSelectedItem(PostClass postClass) {
        Intent i = new Intent(getApplicationContext(), DetailActivity.class);
        i.putExtra("ad", postClass.getResimad());
        i.putExtra("kategori", postClass.getReskategori());
        i.putExtra("kadi", postClass.getKadi());
        startActivity(i);
    }
    private void iptalMethod(String ad){Toast.makeText(getApplicationContext(),ad+" iptal Edildi",Toast.LENGTH_LONG).show();    }
    private void silMethod(String ad){
        Connect connect=ApiClient.getRetrofit().create(Connect.class);
        Call<PostClass>call=connect.deletePost(ad);
        call.enqueue(new Callback<PostClass>() {
            @Override
            public void onResponse(Call<PostClass> call, Response<PostClass> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext()," silindi",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PostClass> call, Throwable t) {

                Toast.makeText(getApplicationContext()," silinmedi",Toast.LENGTH_LONG).show();
            }
        });
    }

}
