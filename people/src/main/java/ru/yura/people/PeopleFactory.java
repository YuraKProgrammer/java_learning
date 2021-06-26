package ru.yura.people;

import com.sun.tools.attach.AgentInitializationException;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static java.lang.Math.random;

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

    private int rn;

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
            if(rn==1) {
                g = fstN.get(f.getFirstName()); // Пол определяется через ключ элемента массива
            }
            if (rn==2){
                g = ieFstN.get(f.getFirstName());
            }
            if (rn==3){
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
        var fd = 1921 + (int)Math.floor(random()*100);
        var sd = 1 + (int)Math.floor(random()*12);
        var td = 1 + (int)Math.floor(random()*27);
        var d = new LocalDate(fd,sd,td);
        return d.toDateTimeAtStartOfDay();
    }

    private PersonName createFio() {
        var rnd = (int)Math.floor(random()*4);
        if (rnd==0 || rnd==1) {
            rn=1;
            var n1 = (int) Math.floor(random() * fstNames.length);
            var n2 = (int) Math.floor(random() * mleNames.length);
            var n3 = (int) Math.floor(random() * lstNames.length);
            return new FIO(fstNames[n1], mleNames[n2], lstNames[n3]);
        }
        if (rnd==2){
            rn=2;
            var ie1 = (int)Math.floor(random()*ieFstNames.length);
            var ie2 = (int)Math.floor(random()*ieSecNames.length);
            var ie3 = (int)Math.floor(random()*ieThirNames.length);
            var ie4 = (int)Math.floor(random()*ieFourNames.length);
            var ie5 = (int)Math.floor(random()*ieFifNames.length);
            var ie6 = (int)Math.floor(random()*ieSixNames.length);
            return new IndiecName(ieFstNames[ie1],ieSecNames[ie2],ieThirNames[ie3],ieFourNames[ie4],ieFifNames[ie5],ieSixNames[ie6]);
        }
        if (rnd==3){
            rn=3;
            var ee = (int)Math.floor(random()*eeNames.length);
            return new IndeecName(eeNames[ee]);
        }
        return null;
    }

    private Country getRandomCountry(){
        var countries = Country.values();
        var k = (int)Math.floor(random()*countries.length);
        return countries[k];
    }
}
