package ru.yura.people.tests;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import ru.yura.people.*;

import java.util.ArrayList;

public class MainClass_Tests {
    @Test
    public void getMoreAgePopulatedCountry_Test(){
        var people = new ArrayList<Person>();
        var p1 = new Person(new FIO("Иван","Иванович","Иванов"), Gender.Male);
        p1.setCountry(Country.Russia);
        p1.setBirthDate(new LocalDate(2010,10,10).toDateTimeAtStartOfDay());
        people.add(p1);

        var p2 = new Person(new FIO("Брюс",null,"Ли"), Gender.Male);
        p2.setCountry(Country.China);
        p2.setBirthDate(new LocalDate(2009,10,10).toDateTimeAtStartOfDay());
        people.add(p2);

        var p3 = new Person(new FIO("Марья","Ивановна",null), Gender.Male);
        p3.setCountry(Country.Russia);
        p3.setBirthDate(new LocalDate(2010,10,10).toDateTimeAtStartOfDay());
        people.add(p3);

        var c = MainClass.getMoreAgePopulatedCountry(10,15,people);
        Assert.assertEquals(Country.Russia,c);
    }
}
