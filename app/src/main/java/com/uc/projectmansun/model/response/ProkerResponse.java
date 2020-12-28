package com.uc.projectmansun.model.response;

import com.google.gson.annotations.SerializedName;
import com.uc.projectmansun.model.local.Proker;

import java.util.List;

public class ProkerResponse {
    @SerializedName("data")
    private List<Proker> results;

    public List<Proker> getResults(){
        return results;
    }
}
