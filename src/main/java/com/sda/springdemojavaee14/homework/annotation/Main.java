package com.sda.springdemojavaee14.homework.annotation;

public class Main {
    public static void main(String[] args) {

        PersonWithAllSourceCode me = new PersonWithAllSourceCode("Kristaps", "Sebris", 31);

        System.out.println("Me: " + me);

        PersonWithAllSourceCode anotherMe = new PersonWithAllSourceCode("Kristaps", "Sebris", 31);
        System.out.println("Me: " + anotherMe);

        System.out.println("is this the same person? - " + me.equals(anotherMe));
    }
}
