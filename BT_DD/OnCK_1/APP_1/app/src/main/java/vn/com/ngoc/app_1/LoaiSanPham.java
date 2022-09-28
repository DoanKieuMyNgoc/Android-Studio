package vn.com.ngoc.app_1;

public class LoaiSanPham {
    private int id;
    private String tenLSP;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLSP() {
        return tenLSP;
    }

    public void setTenLSP(String tenLSP) {
        this.tenLSP = tenLSP;
    }

    public LoaiSanPham() {
    }

    public LoaiSanPham(int id, String tenLSP) {
        this.id = id;
        this.tenLSP = tenLSP;
    }

    @Override
    public String toString() {
        return "LoaiSanPham{" +
                "id=" + id +
                ", tenLSP='" + tenLSP + '\'' +
                '}';
    }
}
