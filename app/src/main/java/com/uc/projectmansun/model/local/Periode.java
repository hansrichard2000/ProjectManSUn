package com.uc.projectmansun.model.local;

import com.google.gson.annotations.SerializedName;

public class Periode {
    @SerializedName("tahun_periode")
    String tahun_periode;

    @SerializedName("nilai")
    String nilai;

    @SerializedName("created_by")
    String created_by;

    public String getTahun_periode() {
        return tahun_periode;
    }

    public void setTahun_periode(String tahun_periode) {
        this.tahun_periode = tahun_periode;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
