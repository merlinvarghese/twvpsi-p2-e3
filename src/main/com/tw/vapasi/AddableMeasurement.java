package com.tw.vapasi;

//Understands quantifiable property of object in various units that can be added
class AddableMeasurement extends Measurement {
    private AddableMeasurement(Unit unit, double value) {
        super(unit, value);

    }

    static AddableMeasurement cms(double magnitude) {
        return new AddableMeasurement(Unit.CM, magnitude);
    }

    static AddableMeasurement km(double magnitude) {
        return new AddableMeasurement(Unit.KM, magnitude);
    }

    static AddableMeasurement meter(double magnitude) {
        return new AddableMeasurement(Unit.M, magnitude);
    }

    static AddableMeasurement kg(double magnitude) {
        return new AddableMeasurement(Unit.KG, magnitude);
    }

    static AddableMeasurement gm(double magnitude) {
        return new AddableMeasurement(Unit.GM, magnitude);
    }

    AddableMeasurement add(AddableMeasurement otherAddableMeasurement) throws Exception {
        if (!this.unit.isUnitTypeEqualTo(otherAddableMeasurement.unit)) {
            throw new Exception("Cannot perform addition on different unit types");
        }
        double result = this.value +
                otherAddableMeasurement.unit.convertTo(otherAddableMeasurement.value, this.unit);

        return new AddableMeasurement(this.unit, result);
    }

}
