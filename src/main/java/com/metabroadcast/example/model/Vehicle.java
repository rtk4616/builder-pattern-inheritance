package com.metabroadcast.example.model;

public class Vehicle {

    private final Integer numberOfWheels;

    protected Vehicle(Builder<?, ?> builder) {
        this.numberOfWheels = builder.numberOfWheels;
    }

    public static Builder<?, ?> builder() {
        return new VehicleBuilder();
    }

    public Integer getNumberOfWheels() {
        return numberOfWheels;
    }

    public abstract static class Builder<T extends Vehicle, B extends Builder<T, B>> {

        private Integer numberOfWheels;

        protected Builder() {
        }

        public B withNumberOfWheels(Integer numberOfWheels) {
            this.numberOfWheels = numberOfWheels;
            return self();
        }

        protected abstract B self();

        public abstract T build();
    }

    public static class VehicleBuilder extends Builder<Vehicle, VehicleBuilder> {

        private VehicleBuilder() {

        }

        public Vehicle build() {
            return new Vehicle(this);
        }

        public VehicleBuilder self() {
            return this;
        }
    }
}
