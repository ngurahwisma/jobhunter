package com.wisma.jobhunter.Services.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {
    private String status;
    private String id;
    private String username;
    private String nama;
    private String email;
    private String no_hp;
    private String bio;
    private String tanggal_lahir;
    private String created_at;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    protected Users(Parcel in) {
        status = in.readString();
        id = in.readString();
        username = in.readString();
        nama = in.readString();
        email = in.readString();
        no_hp = in.readString();
        bio = in.readString();
        tanggal_lahir = in.readString();
        created_at = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(id);
        dest.writeString(username);
        dest.writeString(nama);
        dest.writeString(email);
        dest.writeString(no_hp);
        dest.writeString(bio);
        dest.writeString(tanggal_lahir);
        dest.writeString(created_at);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };
}
