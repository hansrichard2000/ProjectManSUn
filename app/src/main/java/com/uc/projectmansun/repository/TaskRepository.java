package com.uc.projectmansun.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.projectmansun.model.local.Task;
import com.uc.projectmansun.model.response.TaskResponse;
import com.uc.projectmansun.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskRepository {
    private static TaskRepository taskRepository;
    private RetrofitService apiService;
    private static final String TAG = "TaskRepository";

    private TaskRepository(String token){
        Log.d(TAG, "TaskRepository: "+ token);
        apiService = RetrofitService.getInstance(token);
    }

    public static TaskRepository getInstance(String token){
        if (taskRepository == null){
            taskRepository = new TaskRepository(token);
        }
        return taskRepository;
    }

    public synchronized void resetInstance(){
        if (taskRepository != null){
            taskRepository = null;
        }
    }

    public MutableLiveData<List<Task>> getTask(){
        MutableLiveData<List<Task>> listTask = new MutableLiveData<>();

        apiService.getTask().enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d(TAG, "onResponse" + response.body().getResults().size());
                        listTask.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listTask;
    }
}
