package com.uc.projectmansun.model.response;

import com.google.gson.annotations.SerializedName;
import com.uc.projectmansun.model.local.Task;

import java.util.List;

public class TaskResponse {
    @SerializedName("data")
    private List<Task> results;

    public List<Task> getResults() {
        return results;
    }
}
