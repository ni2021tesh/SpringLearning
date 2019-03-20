// Copyright (c) 2018 Travelex Ltd

package spring_lifeCycle;

public class Student {
    private String name;
    private String lastname;
    private String mesage;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }


    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", lastname='" + lastname + '\'' + ", mesage='" + mesage + '\'' + '}';
    }
}
