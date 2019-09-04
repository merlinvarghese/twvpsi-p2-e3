package com.tw.vapasi;

import java.util.HashMap;
import java.util.Map;

// Understands various measurement unit types with cm and gm as base measurement values for respective types
class Unit {
    private static final String LENGTH = "LENGTH";
    private static final String WEIGHT = "WEIGHT";

    static final Unit KM = new Unit(100000, UnitType.LENGTH);
    static final Unit CM = new Unit(1, UnitType.LENGTH);
    static final Unit M = new Unit(100, UnitType.LENGTH);
    static final Unit KG = new Unit(1000, UnitType.WEIGHT);
    static final Unit GM = new Unit(1, UnitType.WEIGHT);

    private final double baseConversionValue;
    private final UnitType type;

    enum UnitType {
      LENGTH,
      WEIGHT
    }
    private Unit(double baseConversionValue, UnitType type) {
        this.baseConversionValue = baseConversionValue;
        this.type = type;
    }

    double convertToBase(double value) {
        return value * baseConversionValue;
    }

    double converTo(double value, Unit otherUnit) throws Exception {
        if (isUnitTypeEqualTo(otherUnit)) {
            return value * (this.baseConversionValue / otherUnit.baseConversionValue);
        }
        throw new Exception("can not convert");
    }

    boolean isUnitTypeEqualTo(Unit other) {
        return this.type.equals(other.type);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
