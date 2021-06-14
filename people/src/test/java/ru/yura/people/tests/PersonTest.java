package ru.yura.people.tests;
import org.junit.Assert;
import org.junit.Test;
import ru.yura.people.*;

public class PersonTest {
    @Test
    public void toString_Test(){
        var p1=new Person(new IndeecName("Большая гора"), Gender.Male);
        Assert.assertEquals("Большая гора",p1.toString());
        var p2 = new Person(new IndeecName("Большая гора"), Gender.Male);
        p2.setCountry(Country.USA);
        Assert.assertEquals("Большая гора, USA",p2.toString());
    }
}
