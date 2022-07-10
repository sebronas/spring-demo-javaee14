package com.sda.springdemojavaee14.homework.annotation;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        PersonWithAllSourceCode me = new PersonWithAllSourceCode("Kristaps", "S", 31);

        System.out.println("Me: " + me);

        PersonWithAllSourceCode anotherMe = new PersonWithAllSourceCode("Kristaps", "S", 31);
        System.out.println("Me: " + anotherMe);

        PersonWithAnnotation meAgain = new PersonWithAnnotation("Kristaps", "S", 31);

        //builder is better than all args constructor - because You can see more:
        PersonWithAnnotation meAgainWithBuilder = PersonWithAnnotation.builder()
                .name("Chris")
                .surname("SS")
                .age(31)
                .build();

        Set<PersonWithAllSourceCode> uniquePersons = new HashSet<>();
        uniquePersons.add(me);
        uniquePersons.add(anotherMe);

        System.out.println(uniquePersons.size());
    }
}
