package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TestDistance {

    @Test
    void expect100CmEquals1m() {
        Distance centimeter100 = new Distance(100, "cm");
        Distance meter1 = new Distance(1, "m");
        assertEquals(true, centimeter100.equals(meter1));


    }

    @Test
    void expect90CmNotEquals1m() {
        Distance centimeter90 = new Distance(90, "cm");
        Distance meter1 = new Distance(1, "m");
        assertFalse(centimeter90.equals(meter1));

    }

    @Test
    void expect1KmCmEquals1000m() {
        Distance kilometer1 = new Distance(1, "km");
        Distance meter1000 = new Distance(1000, "m");
        assertTrue(kilometer1.equals(meter1000));

    }


}