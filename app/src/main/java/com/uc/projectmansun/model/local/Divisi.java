package com.uc.projectmansun.model.local;

import com.google.gson.annotations.SerializedName;

public class Divisi {
    @SerializedName("nama_divisi")
    String nama_divisi;

    @SerializedName("proker_id")
    int proker_id;

    @SerializedName("created_by")
    String created_by;

    public String getNama_divisi() {
        return nama_divisi;
    }

    public void setNama_divisi(String nama_divisi) {
        this.nama_divisi = nama_divisi;
    }

    public int getProker_id() {
        return proker_id;
    }

    public void setProker_id(int proker_id) {
        this.proker_id = proker_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
