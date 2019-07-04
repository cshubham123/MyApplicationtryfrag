package com.example.myapplicationtryfrag;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class frag1 extends Fragment {
    EditText edit1, edit2;
    Button b;

    public static final String TAG = frag1.class.getSimpleName();

    private OnAdditionResultListener mAdditionResultListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "oncreateview");
        View v = inflater.inflate(R.layout.actf1, container, false);
        //  final View v2= inflater.inflate(R.layout.actf2, container, false);
        edit1 = (EditText) v.findViewById(R.id.edit1);
        edit2 = (EditText) v.findViewById(R.id.edit2);
        b = (Button) v.findViewById(R.id.buttadd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1 = edit1.getText().toString();
                String s2 = edit2.getText().toString();
                int x1 = Integer.parseInt(s1);
                int x2 = Integer.parseInt(s2);
                int x = x1 + x2;
                mAdditionResultListener.onAddition(x);



            }
        });
        return v;
    }

    public interface OnAdditionResultListener {
        void onAddition(int result);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "oncreate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onattach");
        try {
            mAdditionResultListener = (OnAdditionResultListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnAdditionResultListener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onstart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onresume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onpause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onstop");


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ondestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "ondetach");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onactivitycreated");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "ondestroyview");
    }
}