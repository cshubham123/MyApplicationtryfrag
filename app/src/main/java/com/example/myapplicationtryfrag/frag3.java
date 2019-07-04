package com.example.myapplicationtryfrag;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class frag3 extends Fragment {
    List<Mydata> mydataList = new ArrayList<>();
    int abc;
//    public frag3(List<Mydata> mydataList,int position ){
//        this.mydataList=mydataList;
//        abc=position;
//    }

    public void fame(List<Mydata> list, int position) {
        this.mydataList = list;
        abc = position;
        ImageView imageView = (ImageView) getView().findViewById(R.id.imgking);

        Glide.with(getView()).load(mydataList.get(abc).getImg()).into(imageView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View v=getView();
        View v = inflater.inflate(R.layout.actf3, container, false);


        return v;
    }

}
