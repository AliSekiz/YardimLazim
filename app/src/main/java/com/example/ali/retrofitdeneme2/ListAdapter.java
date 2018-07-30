package com.example.ali.retrofitdeneme2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    List<Kullanici> kullaniciList;
    LayoutInflater layoutInflater;
    Activity activity;
    Kullanici kullanici;
    public ListAdapter(List<Kullanici>kullaniciList, Activity activity){
        layoutInflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.kullaniciList=kullaniciList;
        this.activity=activity;

    }

    @Override
    public int getCount() {
        return kullaniciList.size();
    }

    @Override
    public Object getItem(int position) {
        return kullaniciList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=layoutInflater.inflate(R.layout.item_view,null);


        TextView resimad=(TextView)view.findViewById(R.id.adTv);
        TextView reskategori=(TextView)view.findViewById(R.id.kategoriTv);
        ImageView resimView=(ImageView)view.findViewById(R.id.imageView);
        TextView kadiTv=(TextView)view.findViewById(R.id.kadiTv);


        resimad.setText(kullaniciList.get(position).getResimad());
        reskategori.setText(kullaniciList.get(position).getReskategori());
        Picasso.get().load("http://gadraj.com/alimobil/yardimlazim/"+kullaniciList.get(position).getResimad()+".jpg").into(resimView);
        return view;
    }
}
