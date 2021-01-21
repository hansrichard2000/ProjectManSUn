package com.uc.projectmansun.model.response;

import com.google.gson.annotations.SerializedName;
import com.uc.projectmansun.model.local.Profil;

import java.util.List;

public class ProfilResponse {
    @SerializedName("data")
    private List<Profil> results;

    public List<Profil> getResults() {
        return results;
    }
}
