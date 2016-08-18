package com.metabroadcast.example;

import com.metabroadcast.example.model.Bicycle;
import com.metabroadcast.example.model.Cat;

public class BuilderMain {

    public static void main(String[] args) {

        Cat toothless = Cat.builder()
                .withName("Toothless")
                .withOwner("Lavanya")
                .withPet(Boolean.TRUE)
                .withDomestic(Boolean.TRUE)
                .withNumberOfLegs(4)
                .build();

        System.out.println(toothless.getName());

        Bicycle bicycle = Bicycle.builder()
                .withNumberOfWheels(2)
                .withSpeed(15)
                .build();

        System.out.println(bicycle.getSpeed());
    }
}
