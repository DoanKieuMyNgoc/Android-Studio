package com.example.demogridview;

public class SanPham {
    private String ten;
    private double gia;
    private String tt;
    private int url;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public SanPham(String ten, double gia, int url) {
        this.ten = ten;
        this.gia = gia;
        this.url = url;
    }

    public SanPham(String tt) {
        this.tt = tt;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "ten='" + ten + '\'' +
                ", gia=" + gia +
                ", tt='" + tt + '\'' +
                ", url=" + url +
                '}';
    }
}
