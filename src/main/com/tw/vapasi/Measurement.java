package com.tw.vapasi;

import java.util.Objects;

//Understands quantifiable property of object in various units
class Measurement {
    private final Unit unit;
    private final double value;

    private Measurement(Unit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    static Measurement cms(int magnitude) {
        return new Measurement(Unit.CM, magnitude);
    }

    static Measurement km(int magnitude) {
        return new Measurement(Unit.KM, magnitude);
    }

    static Measurement meter(int magnitude) {
        return new Measurement(Unit.M, magnitude);
    }

    static Measurement kg(int magnitude) {
        return new Measurement(Unit.KG, magnitude);
    }

    static Measurement gm(int magnitude) {
        return new Measurement(Unit.GM, magnitude);
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
        if (this.isDifferentMeasurementType(otherMeasurement)) {
            return false;
        }
        return convertToBaseUnit() == otherMeasurement.convertToBaseUnit();    }

    private boolean isDifferentMeasurementType(Measurement otherMeasurement) {
        return !this.unit.isUnitTypeEqualTo(otherMeasurement.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unit.hashCode(), this.value);
    }

    private double convertToBaseUnit() {
        return unit.convertToBase(value);
    }
}
