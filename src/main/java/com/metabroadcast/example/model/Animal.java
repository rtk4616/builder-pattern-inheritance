package com.metabroadcast.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Animal {

    private final Integer numberOfLegs;
    private final Boolean domestic;

    @JsonCreator
    public Animal(
            @JsonProperty("numberOfLegs") Integer numberOfLegs,
            @JsonProperty("domestic") Boolean domestic
    ) {
        this.numberOfLegs = numberOfLegs;
        this.domestic = domestic;
    }

    public static Builder<?> builder() {
        return new AnimalBuilder();
    }

    public Integer getNumberOfLegs() {
        return numberOfLegs;
    }

    public Boolean isDomestic() {
        return domestic;
    }

    protected static class Builder<T> {

        protected final Class<T> builderClass;
        protected Integer numberOfLegs;
        protected Boolean domestic;

        protected Builder(Class<T> builderClass) {
            this.builderClass = builderClass;
        }

        public T withNumberOfLegs(Integer numberOfLegs) {
            this.numberOfLegs = numberOfLegs;
            return builderClass.cast(this);
        }

        public T withDomestic(Boolean domestic) {
            this.domestic = domestic;
            return builderClass.cast(this);
        }

        public Animal build() {
            return new Animal(numberOfLegs, domestic);
        }

    }

    public static class AnimalBuilder extends Builder<AnimalBuilder> {

        protected AnimalBuilder() {
            super(AnimalBuilder.class);
        }
    }
}
