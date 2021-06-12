package ru.yura.test1;

public class Tigre extends Cat{
    private int count;
    public Tigre(String name, float mass, int count){
        super(name,mass);
        this.count = count;
    }

    @Override
    public String getColor(){
        return "Жёлтый в полоску";
    }
}
