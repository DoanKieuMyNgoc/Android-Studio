package com.example.ui_withpicture;


import java.io.Serializable;

public class NhanVien  implements Serializable {
    private int maso;
    private String hoten;
    private String gioitinh;
    private String donvi;

    public NhanVien() {
    }

    public NhanVien(int maso, String hoten, String gioitinh, String donvi) {
        this.maso = maso;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
    }


    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    @Override
    public String toString() {
        return "NhanVien{"  + maso +  ", " + hoten  +", " + gioitinh  + ", " + donvi  +   '}';
    }


}
