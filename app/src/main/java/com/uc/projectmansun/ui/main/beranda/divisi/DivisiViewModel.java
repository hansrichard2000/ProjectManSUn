package com.uc.projectmansun.ui.main.beranda.divisi;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.projectmansun.model.local.Divisi;
import com.uc.projectmansun.repository.DivisiRepository;

import java.util.List;

public class DivisiViewModel extends ViewModel {
    private DivisiRepository divisiRepository;
    private static final String TAG = "DivisiViewModel";

    public DivisiViewModel(){

    }

    public void init(String token){
        Log.d(TAG, "init: " + token);
        divisiRepository = DivisiRepository.getInstance(token);
    }

    public LiveData<List<Divisi>> getDivisi() {
        return divisiRepository.getDivisi();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        divisiRepository.resetInstance();
    }
}
