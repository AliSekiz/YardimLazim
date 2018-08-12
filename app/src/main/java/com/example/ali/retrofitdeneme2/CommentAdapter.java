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

public class CommentAdapter extends BaseAdapter {
    List<CommentClass> commentList;
    LayoutInflater inflater;
    Activity activity;
    public CommentAdapter (List<CommentClass> commentList,Activity activity){
        inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.commentList=commentList;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int position) {
        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =inflater.inflate(R.layout.comment_view,null);
        TextView kadi=(TextView)view.findViewById(R.id.cKadiTv);
        TextView yorum=(TextView)view.findViewById(R.id.commentEdit);
        ImageView ppic= (ImageView) view.findViewById(R.id.cimg);

        kadi.setText(commentList.get(position).getKadi());
        yorum.setText(commentList.get(position).getYorum());
        Picasso.get().load("http://fetihonal.com/yardimlazim/profilres/"+
                commentList.get(position).getKadi()+".jpg").into(ppic);


        return view;
    }
}
