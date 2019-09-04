package com.tw.vapasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitTest {
    @Test
    void expect0CentigradeEquals32F() {
        double celsius = 0.0;
        double farenheit = 32.0;
        Assertions.assertEquals(farenheit, Unit.C.convertToBase(celsius), Unit.F.convertToBase(farenheit));
    }
}
