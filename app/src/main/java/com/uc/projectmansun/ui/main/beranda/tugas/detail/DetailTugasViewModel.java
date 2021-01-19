package com.uc.projectmansun.ui.main.beranda.tugas.detail;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.uc.projectmansun.model.local.Task;
import com.uc.projectmansun.repository.TaskRepository;

public class DetailTugasViewModel extends ViewModel {
    private TaskRepository taskRepository;
    private static final String TAG = "DetailTugasViewModel";

    public DetailTugasViewModel(){

    }

    public void init(String token){
        Log.d(TAG, "init: " + token);
        taskRepository = TaskRepository.getInstance(token);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        taskRepository.resetInstance();
    }

}
