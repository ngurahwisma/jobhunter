package com.wisma.jobhunter.Services.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ServerDefaultResponse implements Parcelable {
    private String status;
    private String messages;
    private String errors;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    protected ServerDefaultResponse(Parcel in) {
        status = in.readString();
        messages = in.readString();
        errors = in.readString();
    }

    public static final Creator<ServerDefaultResponse> CREATOR = new Creator<ServerDefaultResponse>() {
        @Override
        public ServerDefaultResponse createFromParcel(Parcel in) {
            return new ServerDefaultResponse(in);
        }

        @Override
        public ServerDefaultResponse[] newArray(int size) {
            return new ServerDefaultResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(status);
        parcel.writeString(messages);
        parcel.writeString(errors);
    }
}
