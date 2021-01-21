package com.uc.projectmansun.model.local;

import com.google.gson.annotations.SerializedName;
import com.uc.projectmansun.util.Constants;

public class Periode {
    @SerializedName("id")
    String periodeId;

    @SerializedName("tahun_periode")
    String tahun_periode;

    @SerializedName("gambar_periode")
    String gambar_periode;

    @SerializedName("nilai")
    String nilai;

    @SerializedName("created_by")
    String created_by;

    public String getPeriodeId() {
        return periodeId;
    }

    public void setPeriodeId(String periodeId) {
        this.periodeId = periodeId;
    }

    public String getTahun_periode() {
        return tahun_periode;
    }

    public void setTahun_periode(String tahun_periode) {
        this.tahun_periode = tahun_periode;
    }

    public String getGambar_periode() {
        return Constants.BASE_IMAGE_URL_PERIODE + gambar_periode;
    }

    public void setGambar_periode(String gambar_periode) {
        this.gambar_periode = gambar_periode;
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
