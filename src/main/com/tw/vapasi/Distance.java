package com.tw.vapasi;

import java.util.Objects;

//Understands length in various units
class Distance {

  private final Unit unit;
  private final double value;

  private static final double M_IN_CMS = 100;
  private static final double KM_IN_CMS = 100000;

  enum Unit {
    KM,
    CM,
    M
  }

  private Distance(Unit unit, double value) {
    this.unit = unit;
    this.value = value;
  }


  static Distance cms(int magnitude) {
    return new Distance(Unit.CM, magnitude);
  }

  static Distance km(int magnitude) {
    return new Distance(Unit.KM, magnitude);
  }

  static Distance meter(int magnitude) {
    return new Distance(Unit.M, magnitude);
  }


  private double convertToCms() {
    switch (this.unit) {
      case M:
        return this.value * M_IN_CMS;
      case KM:
        return this.value * KM_IN_CMS;
      default:
        return this.value;
    }
  }

  @Override
  public boolean equals(Object otherObject) {
    if (this == otherObject) {
      return true;
    }
    if ((otherObject == null) || (this.getClass() != otherObject.getClass())) {
      return false;
    }
    Distance otherDistance = (Distance) otherObject;
    return this.convertToCms() == otherDistance.convertToCms();
  }


  @Override
  public int hashCode() {
    return Objects.hash(this.unit.hashCode(), this.value);
  }
}
