package ru.yura.test1;

public class KvUr {
    double dt;
    int count;
    public void getDt(double a, double b, double c){
        dt=b*b-4*a*c;
        if (dt>0)
            count=2;
        if (dt==0)
            count=1;
        if (dt<0)
            count=0;
    }
    public double getX1(double b, double a) throws Exception {
        if (count>0)
            return (-b+Math.sqrt(dt))/2*a;
        throw new Exception("Нет корней");
    }
    public double getX2(double b, double a) throws  Exception {
        if (count==2)
            return (-b-Math.sqrt((dt)));
        if (count==1)
            return (-b+Math.sqrt(dt))/2*a;
        throw new Exception("Нет корней");
    }
}
