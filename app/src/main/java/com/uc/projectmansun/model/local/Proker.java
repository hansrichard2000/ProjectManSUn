package com.uc.projectmansun.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.uc.projectmansun.util.Constants;

public class Proker implements Parcelable{
    @SerializedName("id")
    String prokerId;

    @SerializedName("tahun_periode")
    String tahun_periode;

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
    int pemasukan;

    @SerializedName("pengeluaran")
    int pengeluaran;

    @SerializedName("medsos")
    String medsos;

    @SerializedName("proposal")
    String proposal;

    @SerializedName("lpj")
    String lpj;

    @SerializedName("created_by")
    String created_by;

    @SerializedName("gambar_proker")
    String gambar_proker;

    public Proker(){

    }

    public Proker(String prokerId, String tahun_periode, String nama_proker, int periode_id,
                  int status_proker_id, String deskripsi_proker, String tanggal_mulai,
                  String tanggal_akhir, int pemasukan, int pengeluaran, String medsos,
                  String proposal, String lpj, String created_by, String gambar_proker) {
        this.prokerId = prokerId;
        this.tahun_periode = tahun_periode;
        this.nama_proker = nama_proker;
        this.periode_id = periode_id;
        this.status_proker_id = status_proker_id;
        this.deskripsi_proker = deskripsi_proker;
        this.tanggal_mulai = tanggal_mulai;
        this.tanggal_akhir = tanggal_akhir;
        this.pemasukan = pemasukan;
        this.pengeluaran = pengeluaran;
        this.medsos = medsos;
        this.proposal = proposal;
        this.lpj = lpj;
        this.created_by = created_by;
        this.gambar_proker = gambar_proker;
    }

    protected Proker(Parcel in) {
        prokerId = in.readString();
        tahun_periode = in.readString();
        nama_proker = in.readString();
        periode_id = in.readInt();
        status_proker_id = in.readInt();
        deskripsi_proker = in.readString();
        tanggal_mulai = in.readString();
        tanggal_akhir = in.readString();
        pemasukan = in.readInt();
        pengeluaran = in.readInt();
        medsos = in.readString();
        proposal = in.readString();
        lpj = in.readString();
        created_by = in.readString();
        gambar_proker = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(prokerId);
        dest.writeString(tahun_periode);
        dest.writeString(nama_proker);
        dest.writeInt(periode_id);
        dest.writeInt(status_proker_id);
        dest.writeString(deskripsi_proker);
        dest.writeString(tanggal_mulai);
        dest.writeString(tanggal_akhir);
        dest.writeInt(pemasukan);
        dest.writeInt(pengeluaran);
        dest.writeString(medsos);
        dest.writeString(proposal);
        dest.writeString(lpj);
        dest.writeString(created_by);
        dest.writeString(gambar_proker);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Proker> CREATOR = new Creator<Proker>() {
        @Override
        public Proker createFromParcel(Parcel in) {
            return new Proker(in);
        }

        @Override
        public Proker[] newArray(int size) {
            return new Proker[size];
        }
    };

    public String getProkerId() {
        return prokerId;
    }

    public void setProkerId(String prokerId) {
        this.prokerId = prokerId;
    }

    public String getTahun_periode() {
        return tahun_periode;
    }

    public void setTahun_periode(String tahun_periode) {
        this.tahun_periode = tahun_periode;
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

    public int getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(int pemasukan) {
        this.pemasukan = pemasukan;
    }

    public int getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(int pengeluaran) {
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

    public String getGambar_proker() {
        return Constants.BASE_IMAGE_URL_PROKER + gambar_proker;
    }

    public void setGambar_proker(String gambar_proker) {
        this.gambar_proker = gambar_proker;
    }
}
