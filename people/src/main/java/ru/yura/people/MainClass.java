package ru.yura.people;

public class MainClass {
    public static void main(String[] args) {
        var f1 = new FIO("Адам","Богович","Иванов");
        var p1 = new Person(f1);
        var f2 = new FIO("Ева","Боговна",null);
        var p2 = new Person(f2);
        System.out.println(p1);
        System.out.println(p2);
    }
}
