package com.uc.projectmansun.model.local;

import com.google.gson.annotations.SerializedName;

public class DivisiRoleUser {

    @SerializedName("nama_proker")
    String nama_proker;

    @SerializedName("nama_role")
    String nama_role;

    @SerializedName("nama_divisi")
    int nama_divisi;

    public String getNama_proker() {
        return nama_proker;
    }

    public void setNama_proker(String nama_proker) {
        this.nama_proker = nama_proker;
    }

    public String getNama_role() {
        return nama_role;
    }

    public void setNama_role(String nama_role) {
        this.nama_role = nama_role;
    }

    public int getNama_divisi() {
        return nama_divisi;
    }

    public void setNama_divisi(int nama_divisi) {
        this.nama_divisi = nama_divisi;
    }
}
