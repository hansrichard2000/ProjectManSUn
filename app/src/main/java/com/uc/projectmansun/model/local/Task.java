package com.uc.projectmansun.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Task implements Parcelable {
    @SerializedName("id")
    String taskId;

    @SerializedName("nama_divisi")
    String nama_divisi;

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

    public Task()
    {

    }

    public Task(String taskId, String nama_divisi, String judul, String deskripsi, String deadline, String link_hasil_kerja, String penanggung_jawab, String divisi_id, String status_task_id, String created_by) {
        this.taskId = taskId;
        this.nama_divisi = nama_divisi;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.deadline = deadline;
        this.link_hasil_kerja = link_hasil_kerja;
        this.penanggung_jawab = penanggung_jawab;
        this.divisi_id = divisi_id;
        this.status_task_id = status_task_id;
        this.created_by = created_by;
    }

    protected Task(Parcel in) {
        taskId = in.readString();
        nama_divisi = in.readString();
        judul = in.readString();
        deskripsi = in.readString();
        deadline = in.readString();
        link_hasil_kerja = in.readString();
        penanggung_jawab = in.readString();
        divisi_id = in.readString();
        status_task_id = in.readString();
        created_by = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(taskId);
        dest.writeString(nama_divisi);
        dest.writeString(judul);
        dest.writeString(deskripsi);
        dest.writeString(deadline);
        dest.writeString(link_hasil_kerja);
        dest.writeString(penanggung_jawab);
        dest.writeString(divisi_id);
        dest.writeString(status_task_id);
        dest.writeString(created_by);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getNama_divisi() {
        return nama_divisi;
    }

    public void setNama_divisi(String nama_divisi) {
        this.nama_divisi = nama_divisi;
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
