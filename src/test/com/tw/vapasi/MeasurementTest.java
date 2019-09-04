package com.tw.vapasi;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.tw.vapasi.Measurement.*;
import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    @Nested
    class LengthTest {
        @Test
        void expect100CmEquals100cm() {
            assertEquals(cms(100), cms(100));
        }

        @Test
        void expectNotEqualsWhenObjectsAreDifferent() {
            assertNotEquals(cms(30), new String("Apple"));
        }

        @Test
        void expectNotEqualsWhenOneObjectIsNull() {
            assertNotEquals(cms(100), null);
        }

        @Test
        void expect100CmEquals1M() {
            assertEquals(cms(100), meter(1));
        }

        @Test
        void expect90CmNotEquals1M() {
            assertNotEquals(cms(90), meter(1));
        }

        @Test
        void expect100000CmEquals1Km() {
            assertEquals(cms(100000), km(1));
        }

        @Test
        void expect90000CmNotEquals1Km() {
            assertNotEquals(cms(90000), km(1));
        }

        @Test
        void expect5mEquals500Cm() {
            assertEquals(meter(5), cms(500));
        }

        @Test
        void expect7000MeterNotEquals8Km() {
            assertNotEquals(meter(7000), km(8));
        }
    }

    @Nested
    class WeightTest {

        @Test
        void expect1KgEquals1000Gms() {
            assertEquals(kg(1), gm(1000));
        }

        @Test
        void expect1KgNotEquals1Km() {
            assertNotEquals(meter(10), gm(1000));
        }
    }

    @Nested
    class AdditionTest {

        @Test
        void expect2KgPlus200gmEquals2_2kg() throws Exception {
            assertEquals(kg(2.2), kg(2).add(gm(200)));
        }

        @Test
        void expectCanNotAdd200gmAnd100cm() {
            try {
                gm(200).add(cms(100));
                fail("It has Thrown Exception");
            } catch (Exception e) {

            }
        }

      @Test
      void expect3meterFor2meterPlus100cm() throws Exception {
        Measurement result = meter(2).add(cms(100));
        assertEquals(meter(3.0), result);
      }

    }
}