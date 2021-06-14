package ru.yura.people;

public class IndeecName extends PersonName{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IndeecName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Должна быть хотя бы одна часть имени");
        this.name = name;
    }
    private String name;
    @Override
    public String toString(){
        return name;
    }
}
