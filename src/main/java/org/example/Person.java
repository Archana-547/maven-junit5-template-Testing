package org.example;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

public  void celebrateBrithday() {
    age++;
}
public void changeName(String newName){
    name = newName;
    }
    public String getName(){
        return name;

    }
    public int getAge(){
        return age;

    }
}