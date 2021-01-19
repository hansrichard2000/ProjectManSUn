package com.uc.projectmansun.model.response;

import com.google.gson.annotations.SerializedName;
import com.uc.projectmansun.model.local.DivisiRoleUser;
import com.uc.projectmansun.model.local.Profil;

import java.util.List;

public class DivisiRoleUserResponse {
    @SerializedName("data")
    private List<DivisiRoleUser> results;

    public List<DivisiRoleUser> getResults() {
        return results;
    }
}
