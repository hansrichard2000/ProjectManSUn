package com.uc.projectmansun.ui.main.beranda;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.projectmansun.model.local.Periode;
import com.uc.projectmansun.repository.PeriodeRepository;

import java.util.List;

public class BerandaViewModel extends ViewModel {
    private PeriodeRepository repository;
    private static final String TAG = "BerandaViewModel";

    public BerandaViewModel(){

    }

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        repository = PeriodeRepository.getInstance(token);
    }

    public LiveData<List<Periode>> getPeriode() {
        return repository.getPeriode();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        repository.resetInstance();
    }
}
