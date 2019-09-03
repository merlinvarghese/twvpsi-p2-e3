package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static com.tw.vapasi.Measurement.*;
import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

  @Test
  void expect100CmEquals100cm() {
    assertEquals(cms(100), cms(100));
  }

  @Test
  void expectNotEqualsWhenObjectsAreDifferent() {
    assertNotEquals(cms(30),new String("Apple"));
  }

  @Test
  void expectNotEqualsWhenOneObjectIsNull() {
    assertNotEquals(cms(100),null);
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

  @Test
  void expect1KgEquals1000Gms() {
      assertTrue(kg(1).equals(gm(1000)));
  }
  @Test
  void expect1KgNotEquals1Km() {
      assertFalse(meter(10).equals(gm(1000)));
  }
}