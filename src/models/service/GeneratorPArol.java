package models.service;

import java.util.LinkedList;

public class GeneratorPArol {
    private String name;
    private String lastName;
    private int age;

    public GeneratorPArol() {
    }

    public GeneratorPArol(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GeneratorPArol{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
    public String generatorParol(GeneratorPArol generatorPArol){
        String name = generatorPArol.getName();
        String lastname = generatorPArol.getLastName();
        int age = generatorPArol.getAge();
        char c = name.charAt(0);
        String agee = String.valueOf(age);
        String rrr = "";
        for (int i = agee.length()-1; i >= 0; i--) {
            rrr += agee.charAt(i);
        }
        return lastname + c + rrr;
    }
}
