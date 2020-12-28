package com.uc.projectmansun.model.local;

import com.google.gson.annotations.SerializedName;

public class Profil {
    @SerializedName("name")
    String user_name;

    @SerializedName("email")
    String user_email;

    @SerializedName("nim")
    String user_nim;

    @SerializedName("departement_name")
    String departement_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_nim() {
        return user_nim;
    }

    public void setUser_nim(String user_nim) {
        this.user_nim = user_nim;
    }

    public String getDepartement_name() {
        return departement_name;
    }

    public void setDepartement_name(String departement_name) {
        this.departement_name = departement_name;
    }
}
