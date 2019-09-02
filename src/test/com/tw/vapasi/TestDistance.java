package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static com.tw.vapasi.Distance.*;
import static org.junit.jupiter.api.Assertions.*;

class TestDistance {

  @Test
  void expect100CmEquals100cm() {
    assertEquals(cms(100), cms(100));
  }

  @Test
  void expectFalseWhenOneObjectIsNull() {
    assertNotEquals(cms(30),null);
  }

  @Test
  void expectFalseWhenObjectsAreDifferent() {
    assertNotEquals(cms(30),new String("Apple"));
  }

  @Test
  void expect100CmEquals1M() {
    assertEquals(cms(100), meter(1));
  }

  @Test
  void expect90CmNotEquals1m() {
    assertNotEquals(cms(90), meter(1));
  }

  @Test
  void expect100000CmEquals1Kilometer() {
    assertEquals(cms(100000), km(1));
  }

  @Test
  void expect90000CmEquals1Kilometer() {
    assertNotEquals(cms(90000), km(1));
  }

  @Test
  void expect5mEquals500Centimeter() {
    assertEquals(meter(5), cms(500));
  }

  @Test
  void expect7000MeterEquals8Kilometer() {
    assertNotEquals(meter(7000), km(8));
  }

}