package com.tw.vapasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TestMeasurement {

    @Test
   void expect100CmEquals1m()
    {
       Measurement centimeter100 = new Measurement(100,"cm");
       Measurement meter1 = new Measurement(1,"m");
       Assertions.assertEquals(true,centimeter100.equals(meter1));


    }
}