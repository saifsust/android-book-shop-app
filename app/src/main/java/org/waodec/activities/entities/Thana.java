package org.waodec.activities.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Thana implements Serializable {

    @SerializedName("thana_id")
    private int thanaId;
    @SerializedName("thana_name")
    private String thana_name;

    public Thana() {
    }

    public Thana(String thana_name) {
        this.thana_name = thana_name;
    }

    public Thana(int thanaId, String thana_name) {
        this.thanaId = thanaId;
        this.thana_name = thana_name;
    }

    public int getThanaId() {
        return thanaId;
    }

    public void setThanaId(int thanaId) {
        this.thanaId = thanaId;
    }

    public String getThana_name() {
        return thana_name;
    }

    public void setThana_name(String thana_name) {
        this.thana_name = thana_name;
    }

    @Override
    public String toString() {
        return "Thana{" +
                "thanaId=" + thanaId +
                ", thana_name='" + thana_name + '\'' +
                '}';
    }
}
