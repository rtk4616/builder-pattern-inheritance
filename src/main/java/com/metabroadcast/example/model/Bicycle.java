package com.metabroadcast.example.model;

public class Bicycle extends Vehicle {

    private final Integer speed;

    private Bicycle(Builder<?, ?> builder) {
        super(builder);
        this.speed = builder.speed;

    }

    public static BicycleBuilder builder() {
        return new BicycleBuilder();
    }

    public Integer getSpeed() {
        return speed;
    }

    public abstract static class Builder<T extends Vehicle, B extends Builder<T, B>>
            extends Vehicle.Builder<T, B> {

        private Integer speed;

        protected Builder() {

        }

        public B withSpeed(Integer speed) {
            this.speed = speed;
            return self();
        }

    }

    public static class BicycleBuilder extends Builder<Bicycle, BicycleBuilder> {

        public Bicycle build() {
            return new Bicycle(this);
        }

        public BicycleBuilder self() {
            return this;
        }
    }

}
