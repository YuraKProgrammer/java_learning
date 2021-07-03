package ru.yura.people;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class PeopleFactory {
    private final String[] mleNames = new String[]{"Мазилов(а)","Иванов(а)","Петров(а)","Кот","Сергеев(а)","Сидоров(а)"};
    private final String[] lstNames = new String[]{"Сергеевич(на)","Валентинович(на)","Борисович(на)","Александрович(на)","Васильевич(на)","Иванович(на)","Валерьевич(на)"};
    private final HashMap<String, Gender> fstN;
    private final String[] fstNames;

    private final String[] ieSecNames = new String[]{"Бхат","Хаттаб","Хафс"};
    private final String[] ieThirNames = new String[]{"ибн","аль","абу"};
    private final String[] ieFourNames = new String[]{"Умар","Раджа","Синдхи"};
    private final String[] ieFifNames = new String[]{"Мангешкар","Гандхи","Алуру"};
    private final String[] ieSixNames = new String[]{"Шеной","Адавий","Каур"};
    private final HashMap<String,Gender> ieFstN;
    private final String[] ieFstNames;

    private final HashMap<String,Gender> eeN;
    private final String[] eeNames;

    private Random random=new Random();

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

        ieFstN = new HashMap<>();
        ieFstN.put("Аббат",Gender.Male);
        ieFstN.put("Ратна",Gender.Female);
        ieFstN.put("Вимала",Gender.Female);
        ieFstN.put("Махатма",Gender.Male);
        ieFstN.put("Асим",Gender.Male);
        ieFstNames=ieFstN.keySet().toArray(new String[0]);

        eeN = new HashMap<>();
        eeN.put("Острый коготь",Gender.Male);
        eeN.put("Быстрый олень",Gender.Male);
        eeN.put("Могучая река",Gender.Female);
        eeN.put("Большая гора",Gender.Female);
        eeN.put("Меткий орёл",Gender.Male);
        eeN.put("Хитрая рысь",Gender.Female);
        eeNames=eeN.keySet().toArray(new String[0]);
    }

    public List<Person> create(int count) {
        var persons = new ArrayList<Person>(count);
        for (var i = 0; i < count; i++) {
            var f = createFio();
            Gender g = Gender.Male;
            if (f.getClass()==FIO.class) {
                g = fstN.get(f.getFirstName()); // Пол определяется через ключ элемента массива
            }
            if (f.getClass()==IndiecName.class){
                g = ieFstN.get(f.getFirstName());
            }
            if (f.getClass()==IndeecName.class){
                g = eeN.get(f.getFirstName());
            }
            var p = new Person(f, g);
            p.setCountry(getRandomCountry());
            var birthdate = createBirthDate();
            p.setBirthDate(birthdate);
            persons.add(p);
        }
        return persons;
    }

    private DateTime createBirthDate() {
        var fd = 1921 + random.nextInt(100);
        var sd = 1 + random.nextInt(12);
        var td = 1 + random.nextInt(27);
        var d = new LocalDate(fd,sd,td);
        return d.toDateTimeAtStartOfDay();
    }


    private PersonName createFio() {
        switch (random.nextInt(4)){
            case 0:
            case 1:
                return new FIO(getRandom(fstNames), getRandom(mleNames), getRandom(lstNames));
            case 2:
                var n1 = getRandom(ieFstNames);
                var n2 = getRandom(ieSecNames);
                var n3 = getRandom(ieThirNames);
                var n4 = getRandom(ieFourNames);
                var n5 = getRandom(ieFifNames);
                var n6 = getRandom(ieSixNames);
                return new IndiecName(n1,n2,n3,n4,n5,n6);
            case 3:
                return new IndeecName(getRandom(eeNames));
            default:
                throw new RuntimeException();
        }
    }

    private Country getRandomCountry(){
        var countries = Country.values();
        return getRandom(countries);
    }

    private <T> T getRandom(T[] values){
        var k = random.nextInt(values.length);
        return values[k];
    }
}
