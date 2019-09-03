package com.tw.vapasi;

import java.util.Objects;

//Understands length in various units
class Measurement {

    private final Unit unit;
    private final double value;
    private final MeasurementType measurementType;

    enum MeasurementType {
        WEIGHT,
        LENGTH;
    }

    private Measurement(Unit unit, double value, MeasurementType measurementType) {
        this.unit = unit;
        this.value = value;
        this.measurementType = measurementType;
    }


    static Measurement cms(int magnitude) {
        return new Measurement(Unit.CM, magnitude, MeasurementType.LENGTH);
    }

    static Measurement km(int magnitude) {
        return new Measurement(Unit.KM, magnitude, MeasurementType.LENGTH);
    }

    static Measurement meter(int magnitude) {
        return new Measurement(Unit.M, magnitude, MeasurementType.LENGTH);
    }

    static Measurement kg(int magnitude) {
        return new Measurement(Unit.KG, magnitude, MeasurementType.WEIGHT);
    }

    static Measurement gm(int magnitude) {
        return new Measurement(Unit.GM, magnitude, MeasurementType.WEIGHT);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if ((otherObject == null) || (this.getClass() != otherObject.getClass())) {
            return false;
        }
        Measurement otherMeasurement = (Measurement) otherObject;
        if (isDifferentMeasurementType(otherMeasurement)) {
            return false;
        }
        return this.unit.convertToBase(this.value) == otherMeasurement.unit.convertToBase(otherMeasurement.value);
    }

    private boolean isDifferentMeasurementType(Measurement otherMeasurement) {
        return !this.measurementType.equals(otherMeasurement.measurementType);
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.unit.hashCode(), this.value);
    }
}
