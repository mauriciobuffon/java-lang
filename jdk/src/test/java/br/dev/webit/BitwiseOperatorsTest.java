package br.dev.webit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BitwiseOperatorsTest {

    @ParameterizedTest
    @CsvSource(value = { "123, -123", "-654, 654" })
    public void twosComplement(final int initial, final int expected) {
        final int mask = 0xffff_ffff;
        final int actual = (initial ^ mask) + 1;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = { "10000000000000000000000000000000, 11000000000000000000000000000000",
            "11111111111111111111111111111110, 11111111111111111111111111111111" })
    public void signedRightShift(final String initial, final String expected) {
        assertEquals(Integer.parseUnsignedInt(expected, 2), Integer.parseUnsignedInt(initial, 2) >> 1);
    }

    @ParameterizedTest
    @CsvSource(value = { "11111111111111111111111111111111, 01111111111111111111111111111111",
            "11111111111111111111111111111110, 01111111111111111111111111111111" })
    public void unsignedRightShift(final String initial, final String expected) {
        assertEquals(Integer.parseUnsignedInt(expected, 2), Integer.parseUnsignedInt(initial, 2) >>> 1);
    }

    @ParameterizedTest
    @CsvSource(value = { "01111111111111111111111111111111, 11111111111111111111111111111110",
            "11111111111111111111111111111111, 11111111111111111111111111111110",
            "01000000000000000000000000000000, 10000000000000000000000000000000",
            "10000000000000000000000000000000, 00000000000000000000000000000000" })
    public void unsignedLeftShift(final String initial, final String expected) {
        assertEquals(Integer.parseUnsignedInt(expected, 2), Integer.parseUnsignedInt(initial, 2) << 1);
    }
}
