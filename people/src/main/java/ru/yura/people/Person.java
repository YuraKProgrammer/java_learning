package ru.yura.people;

public class Person {
    private PersonName name;

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
            return name+", "+country;
        return name.toString();
    }
}
