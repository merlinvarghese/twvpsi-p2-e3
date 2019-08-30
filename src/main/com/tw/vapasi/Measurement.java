package com.tw.vapasi;

import java.util.Objects;

//Understands measurement
public class Measurement {
    private final String unitName;
    private final int unitValue;

    public Measurement(int unitValue, String unitName) {
        this.unitName = unitName;
        this.unitValue = unitValue;

    }

    private boolean compare(Measurement obj) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;

        return compare(that);
        /*return unitName == that.unitName &&
                Objects.equals(unitValue, that.unitValue);*/


    }

    @Override
    public int hashCode() {
        return Objects.hash(unitName, unitValue);
    }
}
