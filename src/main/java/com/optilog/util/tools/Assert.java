package com.optilog.util.tools;

import java.util.Objects;

public class Assert {
    public static void assertTrue(boolean astTrue) {
        if (!astTrue) {
            throw new AssertionError("Assert failed:" + false);
        }
    }

    public static void assertFalse(boolean astFalse) {
        if (astFalse) {
            throw new AssertionError("Assert failed:" + true);
        }
    }

    public static void assertEquals(Object value, Object assertValue) {
        if (!Objects.equals(value, assertValue)) {
            throw new AssertionError("Assert failed:expect " + assertValue + " but actually " + value);
        }
    }
}
