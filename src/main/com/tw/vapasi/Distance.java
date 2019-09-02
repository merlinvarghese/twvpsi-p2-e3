package com.tw.vapasi;

import java.util.Objects;

//Understands length in various units
 class Distance {
  private String unitName;
  private int unitValue;
  private final static String BASE_UNIT = "m";

  public Distance(int unitValue, String unitName) {
    this.unitName = unitName;
    this.unitValue = unitValue;

  }

  private boolean compare(Distance obj) {

    switch (obj.unitName) {
      case "m":
        if ((obj.unitName == "m") && (this.unitName == "cm")) {

          if (obj.unitValue == 1 && this.unitValue == 100) {
            return true;

          }
          break;
        }

    }

    return false;

  }

  private void convertToBaseUnit(Distance obj) {
    double convertedValue = 0;
    double convertedOther = 0;

    if (this.unitName != "m") {

      this.unitName = "m";

      if (this.unitName == "cm")
        this.unitValue = this.unitValue / 100;
      if (this.unitName == "km")
        this.unitValue = this.unitValue * 1000;

    }

  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Distance other = (Distance) o;

    if (this.unitName != "m") {

      convertToBaseUnit(this);
    }
    if (other.unitName != "m") {

      convertToBaseUnit(other);

    }

    // return compare(other);
    return unitName == other.unitName &&
        Objects.equals(unitValue, other.unitValue);


  }

  @Override
  public int hashCode() {
    return Objects.hash(unitName, unitValue);
  }
}
