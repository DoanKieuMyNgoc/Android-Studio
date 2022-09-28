package com.example.bt1;

public class NhanVien {
    private String id;
    private String name;
    private boolean gender;
    private String path_imge;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPath_imge() {
        return path_imge;
    }

    public void setPath_imge(String path_imge) {
        this.path_imge = path_imge;
    }

    public NhanVien(String id, String name, boolean gender, String path_imge) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.path_imge = path_imge;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return this.id + "-" + this.name;
    }
}
