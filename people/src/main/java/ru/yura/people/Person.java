package ru.yura.people;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Person {
    private PersonName name;

    public int getAge(){
        var now = new DateTime();
        var i = new Interval(birthDate, now);
        var days = i.toDuration().getStandardDays();
        return (int)(days/365);
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    private DateTime birthDate;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    private Country country;

    public Gender getGender() {
        return gender;
    }

    private Gender gender;

    public Person(PersonName name, Gender gender){
        if (name==null)
            throw new IllegalArgumentException("Должно быть имя");
        if (gender==null)
            throw new IllegalArgumentException("Должен быть пол");
        this.name=name;
        this.gender=gender;
    }

    /**
     * Метод возвращает текстовое представление человека
     */
    @Override
    public String toString(){
        if (country!=null)
            return name+", "+gender+", "+getAge()+", "+country;
        return name.toString()+", "+getAge()+", "+gender;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate=birthDate;
    }
}
