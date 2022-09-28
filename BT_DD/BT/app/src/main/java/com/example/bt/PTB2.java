package com.example.bt;

public class PTB2 {
    private int a;
    private int b;
    private int c;
    PTB2(int a, int b, int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public String nghiemPTB2(int a, int b, int c) {
        String st = "";
        float denta = b * b - 4 * a * c;
        if (denta < 0)
            st = "Phương trình vô nghiệm";
        else if (denta == 0)
            st = "Phương trình có nghiệm kép x=" + (-b * 1 / (2 * a));
        else {
            st = "Phương trình có 2 nghiệm ";
            st += "\n x1= " + (-b + Math.sqrt(denta) / (2 * a));
        }
        return st;
    }
}
