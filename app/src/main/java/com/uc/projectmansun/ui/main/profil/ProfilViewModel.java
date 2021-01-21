package com.uc.projectmansun.ui.main.profil;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.projectmansun.model.local.Profil;
import com.uc.projectmansun.repository.PeriodeRepository;
import com.uc.projectmansun.repository.ProfilRepository;

import java.util.List;

public class ProfilViewModel extends ViewModel {
    private ProfilRepository repository;
    private PeriodeRepository periodeRepository;
    private static final String TAG = "ProfilViewModel";

    public ProfilViewModel(){

    }

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        repository = ProfilRepository.getInstance(token);
    }

    public LiveData<List<Profil>> getProfil() {
        return repository.getProfil();
    }

    public LiveData<String> logout() {
        repository.resetInstance();
        return repository.logout();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        repository.resetInstance();
    }


}
