package com.sda.springdemojavaee14.homework.ex1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
//Singleton creates only one instance, but to create four wheel, we have to use @Scope annotation and change from
// singleton scope to scope prototype
@Component("ritenis")
@Scope(SCOPE_PROTOTYPE)
public class Wheel {

    //constructor
    public Wheel() {
        System.out.println("Creating new wheel");
    }
}
