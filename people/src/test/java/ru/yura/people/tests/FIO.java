package ru.yura.people.tests;

import org.junit.Assert;
import org.junit.Test;

public class FIO {
    @Test
    public void toString_Test(){
        var f = new ru.yura.people.FIO("Иван","Иванович","Иванов");
        Assert.assertEquals("Иван Иванович Иванов", f.toString());

        var f2 = new ru.yura.people.FIO("Иван",null,"Иванов");
        Assert.assertEquals("Иван Иванов", f2.toString());

        var f3 = new ru.yura.people.FIO("Иван","Иванович",null);
        Assert.assertEquals("Иван Иванович", f3.toString());

        var f4 = new ru.yura.people.FIO("Иван",null,null);
        Assert.assertEquals("Иван", f4.toString());
    }
}
