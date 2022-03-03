package com.example.bt_5;

public class EmployeePFullTime extends Employee{
    @Override
    public double TinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString()+"--> Full Timr = "+ TinhLuong();
    }
}
