package ru.yura.people;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static java.lang.Math.random;

public class PeopleFactory {
    private final String[] mleNames = new String[]{"Мазилов(а)","Иванов(а)","Петров(а)","Кот","Аль-Адавий","Сидоров(а)"};
    private final String[] lstNames = new String[]{"Сергеевич(на)","Валентинович(на)","Борисович(на)","Александрович(на)","Васильевич(на)","Иванович(на)","Валерьевич(на)"};
    private final HashMap<String, Gender> fstN;
    private final String[] fstNames;

    public PeopleFactory() {
        fstN = new HashMap<>();
        fstN.put("Юрий", Gender.Male);
        fstN.put("Михаил", Gender.Male);
        fstN.put("Василий", Gender.Male);
        fstN.put("Александр", Gender.Male);
        fstN.put("Николай", Gender.Male);
        fstN.put("Алексей", Gender.Male);
        fstN.put("Сергей", Gender.Male);
        fstN.put("Илья", Gender.Male);
        fstN.put("Юлия", Gender.Female);
        fstN.put("Любовь", Gender.Female);
        fstN.put("Татьяна", Gender.Female);
        fstN.put("Кристина", Gender.Female);
        fstN.put("Ксения", Gender.Female);
        fstN.put("Александра", Gender.Female);
        fstN.put("Мария", Gender.Female);
        fstN.put("Оксана", Gender.Female);
        fstNames=fstN.keySet().toArray(new String[0]);
    }

    public List<Person> create(int count) {
        var persons = new ArrayList<Person>(count);
        for (var i = 0; i < count; i++) {
            var f = createFio();
            var g = fstN.get(f.getFirstName()); // Пол определяется через ключ элемента массива
            var p = new Person(f, g);
            p.setCountry(getRandomCountry());
            var birthdate = createBirthDate();
            p.setBirthDate(birthdate);
            persons.add(p);
        }
        return persons;
    }

    private DateTime createBirthDate() {
        var fd = 1921 + (int)Math.floor(random()*100);
        var sd = 1 + (int)Math.floor(random()*12);
        var td = 1 + (int)Math.floor(random()*27);
        var d = new LocalDate(fd,sd,td);
        return d.toDateTimeAtStartOfDay();
    }

    private FIO createFio() {
        var n1 = (int)Math.floor(random() * fstNames.length);
        var n2 = (int)Math.floor(random() * mleNames.length);
        var n3 = (int)Math.floor(random() * lstNames.length);
        return new FIO (fstNames[n1],mleNames[n2],lstNames[n3]);
    }

    private Country getRandomCountry(){
        var countries = Country.values();
        var k = (int)Math.floor(random()*countries.length);
        return countries[k];
    }
}
