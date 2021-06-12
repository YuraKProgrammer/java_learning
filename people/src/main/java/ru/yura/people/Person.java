package ru.yura.people;

public class Person {
    private PersonName name;

    public Person(PersonName name){
        if (name==null)
            throw new IllegalArgumentException();
        this.name=name;
    }

    /**
     * Метод возвращает текстовое представление человека
     */
    @Override
    public String toString(){
        return name.toString();
    }
}
