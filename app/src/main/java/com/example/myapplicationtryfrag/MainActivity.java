package com.example.myapplicationtryfrag;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements frag1.OnAdditionResultListener, OnClickListenerShch, AsyncInt {

//    public MainActivity(List<Mydata> list){
//        this.list=list;
//    }

    public static final String TAG = MainActivity.class.getSimpleName();
    frag1 fragment1;
    frag2 fragment2;
    frag3 fragment3;
    Button button;
    List<Mydata> list = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    OnClickListenerShch onClickListenerShch;
    AsyncInt asyncInt;

    //udhae se liye hue FetchD
    // String mineData = null;
    //    List<Mydata> list=new ArrayList<>();
    // Mydata mydata;


    public List<Mydata> getList() {
        return list;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new frag1();
        fragment2 = new frag2();
        fragment3 = new frag3();

        MyCustomView myCustomView = new MyCustomView(this);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.f1, fragment1);
//        fragmentTransaction.commit();

        FragmentManager fragmentManager1 = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
        fragmentTransaction1.replace(R.id.f2, fragment2);
        fragmentTransaction1.commit();
//
//onClickListenerShch=(OnClickListenerShch) this;
        final FragmentManager fragmentManager2 = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
        fragmentTransaction2.replace(R.id.f3, fragment3);
        fragmentTransaction2.addToBackStack(null);
        fragmentTransaction2.commit();

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recycle);


        FetchD fetchD = new FetchD(this);


        //FetchD fetchD=new FetchD(myAdapter);


        fetchD.execute();
        myAdapter = new MyAdapter(list, this);


//
//        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//
//fragment3.fame(list,position);
//recyclerView.setVisibility(View.GONE);
//FrameLayout frameLayout=findViewById(R.id.f3);
//frameLayout.setVisibility(View.VISIBLE);
//
//            }
//
//
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//
//
//            }
//        }));

//        list.add(new Mydata(R.drawable.ic_launcher_background,"77","huhu"));
//        list.add(new Mydata(R.drawable.ic_launcher_background,"69","hfeu"));
//        list.add(new Mydata(R.drawable.ic_launcher_background,"744","yyyhu"));
//        list.add(new Mydata(R.drawable.ic_launcher_background,"23","ruru"));
//        for (int i = 0; i< 50; i++) {
//            list.add(new Mydata(R.drawable.ic_launcher_background,String.valueOf(i),String.valueOf(i + 1000)));
//        }
//        Mydata mydata=new Mydata("fd","dd","tyty");
//        list.add(mydata);


//        if (list.size() > 0){
//            Log.d("check", "dekk" + list.get(0).getT1());
//             }
//        else {
//            Log.d("check", "dekta dekk");
//        }


        Log.d("check", "heyyaa");
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        //   recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);


    }

    @Override
    public void onBackPressed() {
        recyclerView.setVisibility(View.VISIBLE);
        FrameLayout frameLayout = findViewById(R.id.f3);
        frameLayout.setVisibility(View.GONE);


//        int count = getSupportFragmentManager().getBackStackEntryCount();
//
//        if (count == 0) {
//            super.onBackPressed();
//            //additional code
//        } else {
//            getSupportFragmentManager().popBackStack();
//        }

    }

    @Override
    public void onClick(View v, int position) {
        Log.d(TAG, "onClick: " + position);
        if (position == list.size() - 1) {
            Toast.makeText(this, "yha toast nhi dikhega", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "position--->" + (position + 1), Toast.LENGTH_SHORT).show();
        fragment3.fame(list, position);
        recyclerView.setVisibility(View.GONE);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f3);
        frameLayout.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onresume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onstop");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ondestroy");
    }


    @Override
    public void onAddition(int result) {
        Log.d(TAG, "onAddition: " + result);
        // frag2.i=result;
//        b.putInt("res",result);
//        fragment2.setArguments(b);
        fragment2.fanc(result);


//
    }

    public class A {
        int ij = 0;

    }


    @Override
    public void callbc(List<Mydata> list) {
        this.list.addAll(list);
//        Log.d(TAG,"see"+String.valueOf((list).get(0).getT1()));
//        this.list=list;
//        A a = new A();
//        a.ij = 8;
//        A b = new A();
//        b.ij = 9;
//        if (a.equals(b))
//            Log.d("checking", "hheyyy");
//        if (a == b)
//            Log.d("checking", "gggg");
//        this.list = list;
//        if ((this.list).equals(list)) {
//            Log.d(TAG, "ye bhi");
//        }

        if ((this.list) == list)
            Log.d(TAG, "sameref" + " this.list.size()-->" + (this.list).size() + " list.size()-->" + list.size());
        else
            Log.d(TAG, "notsameref" + " this.list.size()-->" + (this.list).size() + " list.size()-->" + list.size());

        myAdapter.notifyDataSetChanged();

    }

//    OnClickListenerShch mOnclickListener = new OnClickListenerShch() {
//
//        @Override
//        public void onClick(View v, int position) {
//
//        }
//    };
}
