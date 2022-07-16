package com.sda.springdemojavaee14.homework.optional;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalExerciseMain {
    public static void main(String[] args) {
        int nickLengt = personNick() != null ? personNick().length() : 0;

        System.out.println("Nick Length is: " + nickLengt);

        Optional<String> maybeNick = personNickIfPresent();

        if (maybeNick.isPresent()) {
            System.out.println(maybeNick.get());
        } else {
            System.out.println("sry, there is no Nick");
        }

        if (maybeNick.isEmpty()) {
            System.out.println("sry, empty");
        } else {
            System.out.println();
        }

        System.out.println("Better usage of Optional");
        System.out.println("nick: " + maybeNick.orElse("no Nick"));

        System.out.println("Optional with Lambda");
        maybeNick.ifPresent(new MyNickConsumer());

        System.out.println("Now with my own Lambda");
        // lambda is about reducing ceremony
        // lambda is for shorter way of providing interface implementations
        // lambda is just content of missing interface method
        // we don't need argument type in lambda, because we know which method we implement
        // -> (arrow) is separator of arguments and method body
        maybeNick.ifPresent(nick -> System.out.println("Nick is " + nick) );
        maybeNick.ifPresent((String nick) -> System.out.println("Nick " + nick));
    }

    public static String personNick() {
        return null;
    }

    // Optional is bag for just one item
    // we're using "factory methods" for creating instances of this class
    // factory method - is static method which is able to produce instances
    public static Optional<String> personNickIfPresent() {
        return Optional.of("Chris");
    }
}



// generic interface consumer - T will be replaced with String in our case
class MyNickConsumer implements Consumer<String> {

    @Override
    public void accept(String t) {
        System.out.println("Nick is: " + t);
    }
}