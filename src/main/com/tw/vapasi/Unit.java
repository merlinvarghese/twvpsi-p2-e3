package com.tw.vapasi;

import java.util.HashMap;
import java.util.Map;

// Understands various measurement unit types with cm and gm as base measurement values for respective types
class Unit {
    private static final String LENGTH = "LENGTH";
    private static final String WEIGHT = "WEIGHT";

    static final Unit KM = new Unit(100000, LENGTH);
    static final Unit CM = new Unit(1, LENGTH);
    static final Unit M = new Unit(100, LENGTH);
    static final Unit KG = new Unit(1000, WEIGHT);
    static final Unit GM = new Unit(1, WEIGHT);

    private final double baseConversionValue;
    private final String type;

    private Unit(double baseConversionValue, String type) {
        this.baseConversionValue = baseConversionValue;
        this.type = type;
    }

    double convertToBase(double value) {
        return value * baseConversionValue;
    }

    double converTo(double value, Unit otherUnit) throws Exception{
        if (isUnitTypeEqualTo(otherUnit)) {
//            switch (otherUnit):
//            case Unit.CM:
//
//                break;
//            case Unit.M:
//                break;
          return value * (this.baseConversionValue/otherUnit.baseConversionValue);
        }
        throw new Exception("can not convert");
    }

    boolean isUnitTypeEqualTo(Unit other) {
        return this.type.equals(other.type);
    }


    Unit getBaseMeasurementType() {
        if (type.equals(Unit.LENGTH)) {
            return Unit.CM;
        }
        return Unit.GM;
    }

  @Override
  public String toString() {
    return super.toString();
  }
}
