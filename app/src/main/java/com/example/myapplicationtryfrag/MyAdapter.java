package com.example.myapplicationtryfrag;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Mydata> list;
    View viewprev;
    int selected = -1;
    OnClickListenerShch onClickListenerShch;




    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            Log.e("check", "myviewholder");
            img = (ImageView) view.findViewById(R.id.myimg);
            t1 = (TextView) view.findViewById(R.id.mytxt1);
//
            view.setClickable(true);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListenerShch.onClick(view,getAdapterPosition());
                }
            });


        }

        public void bindData(Mydata mydata) {




            Glide.with(itemView.getContext()).load(mydata.getT2()).into(img);

            t1.setText(mydata.getT1());


        }
    }

    MyAdapter(List<Mydata> list,OnClickListenerShch onClickListenerShch) {

        this.list = list;
        this.onClickListenerShch=onClickListenerShch;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.e("check", "onbindviewholder");
        Mydata mydata = list.get(position);
       holder.bindData(mydata);
     //  Glide.with(holder.itemView.getContext()).load(mydata.t2).into(holder.img);





        if(selected==position){
            holder.itemView.setBackgroundColor(Color.parseColor("#5e5e5e"));
        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        }



//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                //   notifyDataSetChanged();
//                int prevselected = selected;
//                selected= position;
//                if(prevselected!=-1){
//                    notifyItemChanged(prevselected);
//                }
//                notifyItemChanged(position);
//            }
//        });


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("check", "oncreateviewholder");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myrow, parent, false);
//itemView.setBackgroundColor(0xFF00FF00);


        return new MyViewHolder(itemView);

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {

        Log.e("check", "getitemcount");
        return list.size();
    }
}
