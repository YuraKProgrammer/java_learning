package ru.yura.people.tests;
import org.junit.Assert;
import org.junit.Test;
import ru.yura.people.IndeecName;

public class Indeec {
    @Test
    public void toString_Test(){
        var ee1 = new IndeecName("Острый коготь");
        Assert.assertEquals("Острый коготь", ee1.toString());
        var ee2 = new IndeecName("Быстрый олень");
        Assert.assertEquals("Быстрый олень", ee2.toString());
        Assert.assertThrows(IllegalArgumentException.class, () -> new IndeecName(null));
    }
}
