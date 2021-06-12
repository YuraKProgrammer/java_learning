package ru.yura.test1;

public class Jiraf extends Animal{
    private float dlina;
    public Jiraf(String name,float dlina){
        super(name);
        if (dlina<=0 || dlina>=100)
            throw new IllegalArgumentException("Неверная длина шеи");
        this.dlina = dlina;
    }

    @Override
    public String getColor(){
        return "Жёлтый в крапинку";
    }
}
