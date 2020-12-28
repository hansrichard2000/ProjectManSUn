package com.uc.projectmansun.ui.main.beranda.proker;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.projectmansun.model.local.Proker;
import com.uc.projectmansun.repository.ProkerRepository;

import java.util.List;

public class ProkerViewModel extends ViewModel {
    private ProkerRepository repository;
    private static final String TAG = "ProkerViewModel";

    public ProkerViewModel(){

    }

    public void init(String token){
        Log.d(TAG, "init: " + token);
        repository = ProkerRepository.getInstance(token);
    }

    public LiveData<List<Proker>> getProker() {
        return repository.getProker();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        repository.resetInstance();
    }
}
