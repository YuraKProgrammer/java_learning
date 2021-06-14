package ru.yura.people;

public class MainClass {
    public static void main(String[] args) {
        var f1 = new FIO("Адам","Богович","Иванов");
        var p1 = new Person(f1);
        var f2 = new FIO("Ева","Боговна",null);
        var p2 = new Person(f2);
        var ie1 = new IndiecName("Абу",null,"Аль-Адавий","ибн","Хафс",null);
        var p3 = new Person(ie1);
        var ee1 = new IndeecName("Зоркий глаз");
        var p4 = new Person(ee1);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}
