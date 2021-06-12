package ru.yura.test1;

public class Triangle extends Figures{
    private double a;
    private double b;
    private double c;
    private double h;
    public Triangle(double a, double b, double c, double h){
        this.a=a;
        this.b=b;
        this.c=c;
        if (a>=b+c || b>=a+c || c>=a+b)
            throw new IllegalArgumentException("Любая сторона треугольника меньше суммы двух других сторон");
        this.h=h;
    }
    @Override
    public double getS(){
        return (a*h)/2;
    }
}
