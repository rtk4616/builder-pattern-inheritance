package com.metabroadcast.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat extends Animal {

    private final Boolean pet;
    private final String owner;
    private final String name;

    public Cat(
            @JsonProperty("numberOfLegs") Integer numberOfLegs,
            @JsonProperty("domestic") Boolean domestic,
            @JsonProperty("pet") Boolean pet,
            @JsonProperty("owner") String owner,
            @JsonProperty("name") String name) {
        super(numberOfLegs, domestic);
        this.pet = pet;
        this.owner = owner;
        this.name = name;
    }

    public static CatBuilder builder() {
        return new CatBuilder();
    }

    public Boolean getPet() {
        return pet;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public static class CatBuilder extends Builder<CatBuilder> {

        private Boolean pet;
        private String owner;
        private String name;

        protected CatBuilder() {
            super(CatBuilder.class);
        }

        public CatBuilder withPet(Boolean pet) {
            this.pet = pet;
            return this;
        }

        public CatBuilder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public CatBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Cat build() {
            return new Cat(
                    this.numberOfLegs,
                    this.domestic,
                    this.pet,
                    this.owner,
                    this.name
            );
        }
    }
}
