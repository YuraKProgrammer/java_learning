package ru.yura.test1;

public class Parallelogram extends Figures{
    public double a;
    public double h;
    public Parallelogram(double a, double h){
        this.a=a;
        this.h=h;
    }
    @Override
    public double getS(){
        return a*h;
    }
}
