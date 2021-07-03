package ru.yura.people;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        var factory = new PeopleFactory();
        var startTime = System.nanoTime();
        var persons = factory.create(10_000);
        printAverageAge(persons);
        printOldestMans(persons);
        printCountries50AgeMans(persons);
        printWhoMore1060(persons);
        printAgeGroupCountryMore(persons);
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
//
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
    private static void printCountries50AgeMans(List<Person> people){
        var map = new HashMap<Country, Integer>();
        for (var p: people){
            if(p.getGender()==Gender.Male){
                if(p.getAge()>50){
                    var c = p.getCountry();
                    if (map.containsKey(c))
                        map.replace(c, map.get(c)+1);
                    else
                        map.put(c,1);
                }
            }
        }
        System.out.println("Количество мужчин старше 50 лет:");
        for (var c: map.keySet()) {
            System.out.println(c+" - "+map.get(c));
        }
    }
    private static void printWhoMore1060(List<Person> people){
        var cMale = 0;
        var cFemale = 0;
        for(var p: people) {
            if (p.getCountry()==Country.Russia){
                if (p.getAge()>=10 && p.getAge()<=60){
                    if(p.getGender()==Gender.Male)
                        cMale++;
                    if(p.getGender()==Gender.Female)
                        cFemale++;
                }
            }
        }
        if (cMale>cFemale)
            System.out.println("В России мужчин в возрасте 10-60 лет больше, чем женщин");
        if (cFemale>cMale)
            System.out.println("В России женщин в возрасте 10-60 лет больше, чем мужчин");
    }
    public static Country getMoreAgePopulatedCountry(int min, int max, List<Person> people){
        var countries = new ArrayList<Country>();
        var map = new HashMap<Country,Integer>();
        Country n = null;
        Country c = null;
        Integer mostCount = 0;
        for (var p: people){
            if (p.getAge()>=min && p.getAge()<max) {
                c = p.getCountry();
                if (countries.contains(c))
                    c=p.getCountry();
                else
                    countries.add(c);
                if (map.containsKey(c))
                    map.replace(c, map.get(c) + 1);
                else
                    map.put(c, 1);
            }
        }
        var countPeoples = new ArrayList<Integer>(map.values()); //Список количеств людей из разных стран
        for (var k: countPeoples) {
            if (k>mostCount)
                mostCount=k;
        }
        for (var cs: countries){
            if (map.get(cs)==mostCount)
               n=cs;
        }
        return n;
    }
    private static void printAgeGroupCountryMore(List<Person> people){
        System.out.println("Страна, в которой проживает больше всего людей в возрасте:");
        for (var minAge=0; minAge<96; minAge+=5) {
            System.out.println(minAge+"-"+(minAge+5)+" - " + getMoreAgePopulatedCountry(minAge, minAge+5, people));
        }
    }
}
