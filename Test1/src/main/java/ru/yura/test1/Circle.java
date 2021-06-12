package ru.yura.test1;

public class Circle extends  Figures{
    private final float p = 3.14f;
    private double r;
    public Circle(double r){
        this.r = r;
    }
    @Override
    public double getS(){
        return r*r*p;
    }
}
