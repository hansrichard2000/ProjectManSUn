package com.uc.projectmansun.model.response;

import com.google.gson.annotations.SerializedName;
import com.uc.projectmansun.model.local.Periode;

import java.util.List;

public class PeriodeResponse {
    @SerializedName("data")
    private List<Periode> results;

    public List<Periode> getResults(){
        return results;
    }
}
