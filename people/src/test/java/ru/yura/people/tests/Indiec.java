package ru.yura.people.tests;
import org.junit.Assert;
import org.junit.Test;
import ru.yura.people.IndiecName;

public class Indiec {
    @Test
    public void toString_Test(){
        var ie1 = new IndiecName(null,"Хаттаб",null,null,"ибн","Умар");
        Assert.assertEquals("Хаттаб ибн Умар", ie1.toString());
        var ie2 = new IndiecName("Абу","Хафс","Умар","ибн","аль-Хаттаб","аль-Адавий");
        Assert.assertEquals("Абу Хафс Умар ибн аль-Хаттаб аль-Адавий", ie2.toString());
        Assert.assertThrows(IllegalArgumentException.class, () -> new IndiecName(null,null,null,null,null,null));
    }
}
