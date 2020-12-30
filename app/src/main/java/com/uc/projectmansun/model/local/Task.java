package com.uc.projectmansun.model.local;

import com.google.gson.annotations.SerializedName;

public class Task {
    @SerializedName("id")
    String taskId;

    @SerializedName("judul")
    String judul;

    @SerializedName("deskripsi")
    String deskripsi;

    @SerializedName("deadline")
    String deadline;

    @SerializedName("link_hasil_kerja")
    String link_hasil_kerja;

    @SerializedName("penanggung_jawab")
    String penanggung_jawab;

    @SerializedName("divisi_id")
    String divisi_id;

    @SerializedName("status_task_id")
    String status_task_id;

    @SerializedName("created_by")
    String created_by;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getLink_hasil_kerja() {
        return link_hasil_kerja;
    }

    public void setLink_hasil_kerja(String link_hasil_kerja) {
        this.link_hasil_kerja = link_hasil_kerja;
    }

    public String getPenanggung_jawab() {
        return penanggung_jawab;
    }

    public void setPenanggung_jawab(String penanggung_jawab) {
        this.penanggung_jawab = penanggung_jawab;
    }

    public String getDivisi_id() {
        return divisi_id;
    }

    public void setDivisi_id(String divisi_id) {
        this.divisi_id = divisi_id;
    }

    public String getStatus_task_id() {
        return status_task_id;
    }

    public void setStatus_task_id(String status_task_id) {
        this.status_task_id = status_task_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
