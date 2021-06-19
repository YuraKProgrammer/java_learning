package ru.yura.people;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        var factory = new PeopleFactory();
        var startTime = System.nanoTime();
        var persons = factory.create(10_000);
        printAverageAge(persons);
        printOldestMans(persons);
        var duration = Duration.ofNanos(System.nanoTime()-startTime);
        System.out.println(persons.size());
        System.out.println("Длительность = "+duration.toNanos()/1_000_000_000f+" секунд");
    }

    private static void printAverageAge(List<Person> people){
        int sumAge=0;
        int count=0;
        for (var p: people){
            if (p.getGender()==Gender.Male) {
                sumAge+=p.getAge();
                count++;
            }
        }
        System.out.println("Средний возраст = "+sumAge/count);
    }

    private static void printOldestMans(List<Person> people){
        var list = new ArrayList<Person>();
        for (var p: people){
            if(p.getGender()==Gender.Male){
                list.add(p);
            }
        }
        list.sort((p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println("Самые старшие мужчины: ");
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(list.size()-2));
        System.out.println(list.get(list.size()-3));
        System.out.println(list.get(list.size()-4));
        System.out.println(list.get(list.size()-5));

    }
}
