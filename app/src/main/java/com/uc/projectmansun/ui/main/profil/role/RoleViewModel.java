package com.uc.projectmansun.ui.main.profil.role;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.projectmansun.model.local.DivisiRoleUser;
import com.uc.projectmansun.model.local.Proker;
import com.uc.projectmansun.repository.DivisiRoleUserRepository;
import com.uc.projectmansun.repository.ProkerRepository;

import java.util.List;

public class RoleViewModel extends ViewModel {
    private DivisiRoleUserRepository repository;
    private static final String TAG = "DRU_ViewModel";

    public RoleViewModel(){

    }

    public void init(String token){
        Log.d(TAG, "init: " + token);
        repository = DivisiRoleUserRepository.getInstance(token);
    }

    public LiveData<List<DivisiRoleUser>> getDivisiRoleUser() {
        return repository.getDivisiRoleUser();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        repository.resetInstance();
    }
}