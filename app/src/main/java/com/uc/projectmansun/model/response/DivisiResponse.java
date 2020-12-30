package com.uc.projectmansun.model.response;

import com.google.gson.annotations.SerializedName;
import com.uc.projectmansun.model.local.Divisi;

import java.util.List;

public class DivisiResponse {
    @SerializedName("data")
    private List<Divisi> results;

    public List<Divisi> getResults(){
        return results;
    }
}
