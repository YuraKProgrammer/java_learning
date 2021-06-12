package ru.yura.test1;

public class Animal {
    private String name;
    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }
    public Animal(String name){
        if (name=="" || name==null)
            throw new IllegalArgumentException("Пустое имя");
        this.name=name;
    }
    public String getColor(){
        return "";
    }
}
