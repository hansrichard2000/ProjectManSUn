package com.uc.projectmansun.ui.main.beranda.tugas;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.uc.projectmansun.model.local.Task;
import com.uc.projectmansun.repository.TaskRepository;

import java.util.List;

public class TugasViewModel extends ViewModel {
    private TaskRepository taskRepository;
    private static final String TAG = "TugasViewModel";

    public TugasViewModel(){

    }

    public void init(String token){
        Log.d(TAG, "init: " + token);
        taskRepository = TaskRepository.getInstance(token);
    }

    public LiveData<List<Task>> getTask(int divisiId){
        return taskRepository.getTask(divisiId);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        taskRepository.resetInstance();
    }
}
