package com.uc.projectmansun.ui.main.jadwal;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.projectmansun.model.local.Task;
import com.uc.projectmansun.repository.PeriodeRepository;
import com.uc.projectmansun.repository.TaskRepository;

import java.util.List;

public class JadwalViewModel extends ViewModel {
    private TaskRepository taskRepository;
    private static final String TAG = "JadwalViewModel";

    public JadwalViewModel(){

    }

    public void init(String token){
        Log.d(TAG, "init: " + token);
        taskRepository = TaskRepository.getInstance(token);
    }

    public LiveData<List<Task>> getJadwalTask(){
        return taskRepository.getJadwalTask();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        taskRepository.resetInstance();
    }
}
