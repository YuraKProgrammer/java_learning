package ru.yura.people;

import java.rmi.server.RMIClassLoader;

public class FIO extends PersonName{
    public FIO(String firstName, String middleName, String lastName) {
        if (firstName==null && middleName==null && lastName==null)
            throw new IllegalArgumentException("Должна быть хотя бы одна часть имени");
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;
    private String middleName;
    private String lastName;

    @Override
    public String toString(){
        int count=0;
        String n1=null;
        String n2=null;
        String n3=null;
        if (firstName!=null) {
            count++;
            if (n1 == null)
                n1 = firstName;
        }
        if (middleName!=null) {
            count++;
            if (n1 == null)
                n1 = middleName;
            if (n2 == null)
                n2 = middleName;
        }
        if (lastName!=null){
            count++;
            if (n1==null)
                n1=lastName;
            if(n2==null)
                n2=lastName;
            if(n3==null)
                n3=lastName;
        }
        if (count==1)
            return n1;
        if (count==2)
            return n1+" "+n2;
        if (count==3)
            return n1+" "+n2+" "+n3;
        return null;
    }
}
