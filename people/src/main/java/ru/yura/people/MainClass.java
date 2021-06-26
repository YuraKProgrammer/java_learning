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
        printCountries50AgeMans(persons);
        printWhoMore1060(persons);
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
    private static void printCountries50AgeMans(List<Person> people){
        var list = new ArrayList<Person>();
        var cRus=0;
        var cUSA=0;
        var cChi=0;
        var cEng=0;
        var cGer=0;
        var cFra=0;
        var cJap=0;
        var cSpa=0;
        var cIta=0;
        var cInd=0;
        var cMon=0;
        var cCan=0;
        var cEgy=0;
        var cAus=0;
        for (var p: people){
            if(p.getGender()==Gender.Male){
                if(p.getAge()>50){
                    if(p.getCountry()==Country.Russia)
                        cRus++;
                    if(p.getCountry()==Country.USA)
                        cUSA++;
                    if(p.getCountry()==Country.China)
                        cChi++;
                    if(p.getCountry()==Country.England)
                        cEng++;
                    if(p.getCountry()==Country.Germany)
                        cGer++;
                    if(p.getCountry()==Country.France)
                        cFra++;
                    if(p.getCountry()==Country.Japan)
                        cJap++;
                    if(p.getCountry()==Country.Spain)
                        cSpa++;
                    if(p.getCountry()==Country.Italy)
                        cIta++;
                    if(p.getCountry()==Country.India)
                        cInd++;
                    if(p.getCountry()==Country.Mongolia)
                        cMon++;
                    if(p.getCountry()==Country.Canada)
                        cCan++;
                    if(p.getCountry()==Country.Egypt)
                        cEgy++;
                    if(p.getCountry()==Country.Australia)
                        cAus++;
                }
            }
        }
        System.out.println("Количество мужчин старше 50 лет:");
        System.out.println("Россия - "+cRus);
        System.out.println("США - "+cUSA);
        System.out.println("Китай - "+cChi);
        System.out.println("Англия - "+cEng);
        System.out.println("Германия - "+cGer);
        System.out.println("Франция - "+cFra);
        System.out.println("Япония - "+cJap);
        System.out.println("Исания - "+cSpa);
        System.out.println("Италия - "+cIta);
        System.out.println("Индий - "+cInd);
        System.out.println("Монголия - "+cMon);
        System.out.println("Канада - "+cCan);
        System.out.println("Египет - "+cEgy);
        System.out.println("Австралия - "+cAus);
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
}
