package vn.com.ngoc.app_1;

public class SanPham {
    private int id;
    private String tenSP;
    private double giaTien;
    private String chatLuongSanPham;
    private LoaiSanPham loaiSanPham;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getChatLuongSanPham() {
        return chatLuongSanPham;
    }

    public void setChatLuongSanPham(String chatLuongSanPham) {
        this.chatLuongSanPham = chatLuongSanPham;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", tenSP='" + tenSP + '\'' +
                ", giaTien=" + giaTien +
                ", chatLuongSanPham='" + chatLuongSanPham + '\'' +
                ", loaiSanPham=" + loaiSanPham +
                '}';
    }

    public SanPham() {
    }

    public SanPham(int id, String tenSP, double giaTien, String chatLuongSanPham, LoaiSanPham loaiSanPham) {
        this.id = id;
        this.tenSP = tenSP;
        this.giaTien = giaTien;
        this.chatLuongSanPham = chatLuongSanPham;
        this.loaiSanPham = loaiSanPham;
    }
}
