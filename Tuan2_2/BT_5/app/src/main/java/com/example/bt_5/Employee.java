package com.example.bt_5;

public abstract class Employee {
    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public abstract double TinhLuong();

    @Override
    public String toString() {
        return this.id+"-"+this.name;
    }
}
