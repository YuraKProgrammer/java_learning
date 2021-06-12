package ru.yura.people;

public class FIO extends PersonName{
    public FIO(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

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
        if (middleName==null)
            return firstName+""+lastName;
        return firstName+" "+middleName+" "+lastName;
    }
}
