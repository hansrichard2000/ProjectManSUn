package com.uc.projectmansun.model.local;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Proker {
    @SerializedName("id")
    String prokerId;

    @SerializedName("nama_proker")
    String nama_proker;

    @SerializedName("periode_id")
    int periode_id;

    @SerializedName("status_proker_id")
    int status_proker_id;

    @SerializedName("deskripsi_proker")
    String deskripsi_proker;

    @SerializedName("tanggal_mulai")
    String tanggal_mulai;

    @SerializedName("tanggal_akhir")
    String tanggal_akhir;

    @SerializedName("pemasukan")
    String pemasukan;

    @SerializedName("pengeluaran")
    String pengeluaran;

    @SerializedName("medsos")
    String medsos;

    @SerializedName("proposal")
    String proposal;

    @SerializedName("lpj")
    String lpj;

    @SerializedName("created_by")
    String created_by;

    public String getProkerId() {
        return prokerId;
    }

    public void setProkerId(String prokerId) {
        this.prokerId = prokerId;
    }

    public String getNama_proker() {
        return nama_proker;
    }

    public void setNama_proker(String nama_proker) {
        this.nama_proker = nama_proker;
    }

    public int getPeriode_id() {
        return periode_id;
    }

    public void setPeriode_id(int periode_id) {
        this.periode_id = periode_id;
    }

    public int getStatus_proker_id() {
        return status_proker_id;
    }

    public void setStatus_proker_id(int status_proker_id) {
        this.status_proker_id = status_proker_id;
    }

    public String getDeskripsi_proker() {
        return deskripsi_proker;
    }

    public void setDeskripsi_proker(String deskripsi_proker) {
        this.deskripsi_proker = deskripsi_proker;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getTanggal_akhir() {
        return tanggal_akhir;
    }

    public void setTanggal_akhir(String tanggal_akhir) {
        this.tanggal_akhir = tanggal_akhir;
    }

    public String getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(String pemasukan) {
        this.pemasukan = pemasukan;
    }

    public String getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(String pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public String getMedsos() {
        return medsos;
    }

    public void setMedsos(String medsos) {
        this.medsos = medsos;
    }

    public String getProposal() {
        return proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public String getLpj() {
        return lpj;
    }

    public void setLpj(String lpj) {
        this.lpj = lpj;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
