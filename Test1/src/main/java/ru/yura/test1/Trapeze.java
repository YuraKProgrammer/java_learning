package ru.yura.test1;

public class Trapeze extends Figures{
    private double a;
    private double b;
    private double c;
    private double d;
    private double h;
    public Trapeze(double a, double b, double c, double d, double h){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.h=h;
    }
    @Override
    public double getS(){
        return (a+b)/2*h;
    }
}
