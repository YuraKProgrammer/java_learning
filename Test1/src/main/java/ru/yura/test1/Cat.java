package ru.yura.test1;

public class Cat extends Animal{
    private float mass;


    public float getMass(){
        return mass;
    }

    private String getSingleSound(){
        switch (getName().charAt(0)){
            case 'Я':return "Мяу";
            case 'М':return "Мур";
            case 'Г':return "Ррррр";
            default:return "---";
        }
    }

    public String getSound(int c){
        var result = "";
        for (var i = 0; i<c; i++)
            result+=" "+getSingleSound();
        return result;
    }

    public Cat(String name, float mass){
        super(name);
        if (mass<=0 || mass>=1000)
            throw new IllegalArgumentException("Неправильная масса");
        this.mass=mass;
    }
    public Cat(String name){
        this(name,0.5f);

    }

    @Override
    public String getColor(){
        return "Серый";
    }
}
