package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    @Test
    public  void testChangeName() {
        Person person = new Person("Bob", 25);
        person.changeName("Mart");
        assertEquals("Mart", person.getName(), "Name should be changed");//testcase1
    }

    @Test
    public void testCelebrateBirthday_1mvn () {
        Person person = new Person("Bob", 25);

        person.celebrateBrithday();
        assertEquals(26, person.getAge(), "Age should be incremented by 1");//testcase1
    }

    @Test
        public void testCelebrateBirthday_2() {
        Person person = new Person("Charle", 35);
        person.celebrateBrithday();
        assertEquals(36, person.getAge(), "Age should be increment by 1");
    }

    }