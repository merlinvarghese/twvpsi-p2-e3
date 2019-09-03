package com.tw.vapasi;

import java.util.HashMap;
import java.util.Map;

enum Unit {

  KM(100000),
  CM(1),
  M(100),
  KG(1000),
  GM(1);

  private final double baseConversionValue;

  Unit(double baseConversionValue) {
    this.baseConversionValue = baseConversionValue;
  }

  double convertToBase(double value) {
    return value * baseConversionValue;
  }

}
