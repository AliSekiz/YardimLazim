package com.example.ali.retrofitdeneme2;

import android.content.Intent;
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
    public List<Kullanici>kullaniciList;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.PostEkle:
                Intent intent=new Intent(getApplicationContext(),UpdatePost.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        getItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showSelectedItem(kullaniciList.get(position));

            }
        });

    }
    public void getItem(){
        Connect connect = ApiClient.getRetrofit().create(Connect.class);
        Call<List<Kullanici>>call=connect.getItem();
        call.enqueue(new Callback<List<Kullanici>>() {
            @Override
            public void onResponse(Call<List<Kullanici>> call, Response<List<Kullanici>> response) {
                kullaniciList=response.body();
                ListAdapter adapter=new ListAdapter(kullaniciList,MainActivity.this);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Kullanici>> call, Throwable t) {
                Log.d("Hata","Burdayımmmm");
            }
        });
    }
    private void showSelectedItem(Kullanici kullanici){
        Intent i=new Intent(getApplicationContext(),DetailActivity.class);
        i.putExtra("ad",kullanici.getResimad());
        i.putExtra("kategori",kullanici.getReskategori());
        startActivity(i);
    }
}
