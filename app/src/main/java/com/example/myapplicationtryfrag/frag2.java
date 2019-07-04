package com.example.myapplicationtryfrag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class frag2 extends Fragment {
    public int i=0;
    public void fanc(int u){
        i=u;
        TextView textView = (TextView) (getView()).findViewById(R.id.text);
        textView.setText(Integer.toString(i));

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // View v=getView();
        View v = inflater.inflate(R.layout.actf2, container, false);

//       Bundle b = getArguments();
//       int i=b.getInt("ans");
  //  String result = Integer.toString(i);
//String result="hey";


        return v;
    }

}




