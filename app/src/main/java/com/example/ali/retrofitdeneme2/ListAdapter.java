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
    List<PostClass> postList;
    LayoutInflater layoutInflater;
    Activity activity;
    public ListAdapter(List<PostClass>postList, Activity activity){
        layoutInflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.postList=postList;
        this.activity=activity;

    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
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

        resimad.setText(postList.get(position).getResimad());
        reskategori.setText(postList.get(position).getReskategori());
        Picasso.get().load("http://fetihonal.com/yardimlazim/dosya/"+postList.get(position).getResimad()+".jpg").into(resimView);
        kadiTv.setText(postList.get(position).getKadi());
        return view;
    }
}
