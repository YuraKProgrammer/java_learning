package ru.yura.people;

public class MainClass {
    public static void main(String[] args) {
        var f1 = new FIO("Адам","Богович","Иванов");
        var p1 = new Person(f1, Gender.Male);
        p1.setCountry(Country.France);
        var f2 = new FIO("Ева","Боговна",null);
        var p2 = new Person(f2, Gender.Female);
        p2.setCountry(Country.France);
        var ie1 = new IndiecName("Абу",null,"Аль-Адавий","ибн","Хафс",null);
        var p3 = new Person(ie1, Gender.Male);
        p3.setCountry(Country.China);
        var ee1 = new IndeecName("Зоркий глаз");
        var p4 = new Person(ee1, Gender.Male);
        Person[] persons = new Person[]{p1,p2,p3,p4};
        for (var p: persons) {
                System.out.println(p);
        }
    }
}
