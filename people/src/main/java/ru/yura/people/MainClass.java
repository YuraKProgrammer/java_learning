package ru.yura.people;

import java.util.HashMap;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
        var factory = new PeopleFactory();
        var persons = factory.create(100);
        for (var p: persons) {
                System.out.println(p);
        }
    }
}
