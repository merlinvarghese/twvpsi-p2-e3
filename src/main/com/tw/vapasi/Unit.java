package com.tw.vapasi;

// Understands various measurement unit types with cm and gm as base measurement values for respective types
class Unit {
    static final Unit KM = new Unit(100000, UnitType.LENGTH, 0);
    static final Unit CM = new Unit(1, UnitType.LENGTH, 0);
    static final Unit M = new Unit(100, UnitType.LENGTH, 0);
    static final Unit KG = new Unit(1000, UnitType.WEIGHT, 0);
    static final Unit GM = new Unit(1, UnitType.WEIGHT, 0);

    static final Unit C = new Unit(1, UnitType.TEMPERATURE, 0);
    static final Unit K = new Unit(1, UnitType.TEMPERATURE, 273.15);
    static final Unit F = new Unit(5.0 / 9, UnitType.TEMPERATURE, 32);

    private final double baseConversionValue;
    private final UnitType type;
    private final double offsetValue;

    enum UnitType {
        LENGTH,
        WEIGHT,
        TEMPERATURE
    }

    private Unit(double baseConversionValue, UnitType type, double offsetValue) {
        this.baseConversionValue = baseConversionValue;
        this.type = type;
        this.offsetValue = offsetValue;
    }

    double convertToBase(double value) {
        return baseConversionValue * (value - offsetValue);
    }

    double convertTo(double value, Unit otherUnit) throws Exception {
        if (isUnitTypeEqualTo(otherUnit)) {
            return value * (this.baseConversionValue / otherUnit.baseConversionValue);
        }
        throw new Exception("can not convert");
    }

    boolean isUnitTypeEqualTo(Unit other) {
        return this.type.equals(other.type);
    }
}
