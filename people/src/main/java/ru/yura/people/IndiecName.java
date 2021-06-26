package ru.yura.people;

public class IndiecName extends PersonName {
    public IndiecName(String firstName, String secondName, String thirdName, String fourthName, String fifthName, String sixthName) {
        if (firstName==null && secondName==null && thirdName==null && fourthName==null && fifthName==null && fifthName==null && sixthName == null)
            throw new IllegalArgumentException("Должна быть хотя бы одна часть имени");
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.fourthName = fourthName;
        this.fifthName = fifthName;
        this.sixthName = sixthName;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getFourthName() {
        return fourthName;
    }

    public void setFourthName(String fourthName) {
        this.fourthName = fourthName;
    }

    public String getFifthName() {
        return fifthName;
    }

    public void setFifthName(String fifthName) {
        this.fifthName = fifthName;
    }

    public String getSixthName() {
        return sixthName;
    }

    public void setSixthName(String sixthName) {
        this.sixthName = sixthName;
    }

    private String firstName;
    private String secondName;
    private String thirdName;
    private String fourthName;
    private String fifthName;
    private String sixthName;

    @Override
    public String toString(){
        int count=0;
        String n1=null;
        String n2=null;
        String n3=null;
        String n4=null;
        String n5=null;
        String n6=null;
        int log2=0;
        int log3=0;
        int log4=0;
        int log5=0;
        int log6=0;
        if (firstName!=null) {
            count++;
            if (n1 == null)
                n1 = firstName;
        }
        if (secondName!=null) {
            count++;
            if (n1 == null) {
                n1 = secondName;
                log2 = 1;
            }
            if (n2 == null && log2==0) {
                n2 = secondName;
                log2 = 1;
            }
        }
        if (thirdName!=null){
            count++;
            if (n1==null) {
                n1 = thirdName;
                log3 = 1;
            }
            if (n2==null && log3==0) {
                n2 = thirdName;
                log3 = 1;
            }
            if (n3==null && log3==0) {
                n3 = thirdName;
                log3 = 1;
            }
        }
        if (fourthName!=null){
            count++;
            if (n1==null) {
                n1 = fourthName;
                log4 = 1;
            }
            if (n2==null && log4==0) {
                n2 = fourthName;
                log4=1;
            }
            if (n3==null && log4==0) {
                n3 = fourthName;
                log4 = 1;
            }
            if (n4==null && log4==0) {
                n4 = fourthName;
                log4 = 1;
            }
        }
        if (fifthName!=null) {
            count++;
            if (n1 == null) {
                n1 = fifthName;
                log5 = 1;
            }
            if (n2 == null && log5==0) {
                n2 = fifthName;
                log5 = 1;
            }
            if (n3 == null && log5==0) {
                n3 = fifthName;
                log5 = 1;
            }
            if (n4 == null && log5==0) {
                n4 = fifthName;
                log5 = 1;
            }
            if (n5 == null && log5==0) {
                n5 = fifthName;
                log5 = 1;
            }
        }
        if (sixthName!=null) {
            count++;
            if (n1 == null) {
                n1 = sixthName;
                log6=1;
            }
            if (n2 == null && log6==0) {
                n2 = sixthName;
                log6=1;
            }
            if (n3 == null && log6==0) {
                n3 = sixthName;
                log6=1;
            }
            if (n4 == null && log6==0) {
                n4 = sixthName;
                log6=1;
            }
            if (n5 == null && log6==0) {
                n5 = sixthName;
                log6=1;
            }
            if (n6 == null && log6==0) {
                n6 = sixthName;
                log6=1;
            }
        }
        if (count==1)
            return n1;
        if (count==2)
            return n1+" "+n2;
        if (count==3)
            return n1+" "+n2+" "+n3;
        if (count==4)
            return n1+" "+n2+" "+n3+" "+n4;
        if (count==5)
            return n1+" "+n2+" "+n3+" "+n4+" "+n5;
        if (count==6)
            return n1+" "+n2+" "+n3+" "+n4+" "+n5+" "+n6;
        return null;
    }
}
