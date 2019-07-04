package com.example.myapplicationtryfrag.mynewpackage;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;

public class MyViewModel extends ViewModel {

    MutableLiveData<String> meramutabledata;

    public MutableLiveData<String> getMeramutabledata() {
        meramutabledata=new MutableLiveData<>();
        return meramutabledata;
    }
}
