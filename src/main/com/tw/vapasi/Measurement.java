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

    static Measurement cms(double magnitude) {
        return new Measurement(Unit.CM, magnitude);
    }

    static Measurement km(double magnitude) {
        return new Measurement(Unit.KM, magnitude);
    }

    static Measurement meter(double magnitude) {
        return new Measurement(Unit.M, magnitude);
    }

    static Measurement kg(double magnitude) {
        return new Measurement(Unit.KG, magnitude);
    }

    static Measurement gm(double magnitude) {
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
        if (!this.isSameMeasurementType(otherMeasurement)) {
            return false;
        }
        return convertToBaseUnit() == otherMeasurement.convertToBaseUnit();
    }

    private boolean isSameMeasurementType(Measurement otherMeasurement) {
        return unit.isUnitTypeEqualTo(otherMeasurement.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.unit.hashCode(), this.value);
    }

    private double convertToBaseUnit() {
        return unit.convertToBase(value);
    }

    Measurement add(Measurement otherMeasurement) throws Exception {
        if(!this.unit.isUnitTypeEqualTo(otherMeasurement.unit)){
            throw new Exception("Cannot perform addition on different unit types");
        }
        double result = this.value +
                otherMeasurement.unit.converTo(otherMeasurement.value, this.unit);

return new Measurement(this.unit, result);
    }

    @Override
    public String toString() {
        return "" + this.unit + ":"+this.value;
    }
}
