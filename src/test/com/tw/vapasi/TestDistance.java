package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static com.tw.vapasi.Distance.cms;
import static com.tw.vapasi.Distance.meter;
import static org.junit.jupiter.api.Assertions.*;

class TestDistance {

  @Test
  void expect100CmEquals1M() {
    assertEquals(cms(100), meter(1));
  }

  @Test
  void expect90CmNotEquals1m() {
    assertFalse(cms(90).equals(meter(1)));

  }
}