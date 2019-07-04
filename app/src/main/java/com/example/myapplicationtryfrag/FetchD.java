package com.example.myapplicationtryfrag;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchD extends AsyncTask<Void,Void,Void> {

    String mineData="";
    List<Mydata>

            list=new ArrayList<>();
//    WeakReference<AsyncInt> asyncInt;
    Mydata mydata=new Mydata();
//
    AsyncInt asyncInt;
    int j=0;

   // MainActivity activity;

    public FetchD(AsyncInt asyncInt) {
        Log.d("check", "aagya andar");

        this.asyncInt=asyncInt;


    }



    @Override
    protected void onPreExecute() {
//        this.call();
        super.onPreExecute();

    }


    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url=new URL("https://api.myjson.com/bins/j7wff");
            Log.d("check","jio");
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line;
                while ((line = bufferedReader.readLine() )!= null) {
                    mineData = mineData + line;
                }

            JSONArray jsonArray=new JSONArray(mineData);
            for(int i=0;i<jsonArray.length();i++) {
                if(i>2){
                    j=69;
                }
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Mydata mydata=new Mydata();
                mydata.setT1(jsonObject.getString("title"));
                mydata.setT2(jsonObject.getString("thumbnailUrl"));
                mydata.setImg(jsonObject.getString("url"));
                list.add(mydata);
                Log.d("check",String.valueOf(i));

            }




            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d("checkdown",mineData);
        return null;
    }



    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
     ////   MainActivity.list=this.list;
       // activity.
//MainActivity activity=new MainActivity(list);
       // myAdapter.notifyDataSetChanged();

asyncInt.callbc(list);

    }
}
