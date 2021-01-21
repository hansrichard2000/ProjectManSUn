package com.uc.projectmansun.ui.main.beranda.proker.detail;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.projectmansun.model.local.Proker;
import com.uc.projectmansun.repository.DivisiRepository;
import com.uc.projectmansun.repository.ProkerRepository;

import java.util.List;

public class DetailProkerViewModel extends ViewModel {
    private ProkerRepository prokerRepository;
    private static final String TAG = "DetailProkerViewModel";

    public DetailProkerViewModel() {

    }

    public void init(String token){
        Log.d(TAG, "init: " + token);
        prokerRepository = ProkerRepository.getInstance(token);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        prokerRepository.resetInstance();
    }
}
