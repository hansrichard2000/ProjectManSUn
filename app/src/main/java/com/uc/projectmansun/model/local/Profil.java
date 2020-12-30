package com.uc.projectmansun.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Profil implements Parcelable {
    @SerializedName("student_id")
    String student_id;

    @SerializedName("name")
    String user_name;

    @SerializedName("email")
    String user_email;

    @SerializedName("nim")
    String user_nim;

    @SerializedName("departement_name")
    String departement_name;

    public Profil(){

    }

    public Profil(String student_id, String user_name, String user_email, String user_nim, String departement_name) {
        this.student_id = student_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_nim = user_nim;
        this.departement_name = departement_name;
    }

    protected Profil(Parcel in) {
        student_id = in.readString();
        user_name = in.readString();
        user_email = in.readString();
        user_nim = in.readString();
        departement_name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(student_id);
        dest.writeString(user_name);
        dest.writeString(user_email);
        dest.writeString(user_nim);
        dest.writeString(departement_name);
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

    public String getDepartement_name() {
        return departement_name;
    }

    public void setDepartement_name(String departement_name) {
        this.departement_name = departement_name;
    }
}
