package com.uc.projectmansun.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.uc.projectmansun.util.Constants;

public class Profil implements Parcelable {
    @SerializedName("student_id")
    String student_id;

    @SerializedName("name")
    String user_name;

    @SerializedName("email")
    String user_email;

    @SerializedName("nim")
    String user_nim;

    @SerializedName("nip")
    String user_nip;

    @SerializedName("departement_name")
    String departement_name;

    @SerializedName("photo")
    String gambar_profil;

    public Profil(){

    }

    public Profil(String student_id, String user_name, String user_email, String user_nim, String user_nip, String departement_name, String gambar_profil) {
        this.student_id = student_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_nim = user_nim;
        this.user_nip = user_nip;
        this.departement_name = departement_name;
        this.gambar_profil = gambar_profil;
    }

    protected Profil(Parcel in) {
        student_id = in.readString();
        user_name = in.readString();
        user_email = in.readString();
        user_nim = in.readString();
        user_nip = in.readString();
        departement_name = in.readString();
        gambar_profil = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(student_id);
        dest.writeString(user_name);
        dest.writeString(user_email);
        dest.writeString(user_nim);
        dest.writeString(departement_name);
        dest.writeString(gambar_profil);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Profil> CREATOR = new Creator<Profil>() {
        @Override
        public Profil createFromParcel(Parcel in) {
            return new Profil(in);
        }

        @Override
        public Profil[] newArray(int size) {
            return new Profil[size];
        }
    };

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

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

    public String getUser_nip() {
        return user_nip;
    }

    public void setUser_nip(String user_nip) {
        this.user_nip = user_nip;
    }

    public String getDepartement_name() {
        return departement_name;
    }

    public void setDepartement_name(String departement_name) {
        this.departement_name = departement_name;
    }

    public String getGambar_profil() {
        return Constants.BASE_IMAGE_URL_PROFILE + gambar_profil;
    }

    public void setGambar_profil(String gambar_profil) {
        this.gambar_profil = gambar_profil;
    }
}
