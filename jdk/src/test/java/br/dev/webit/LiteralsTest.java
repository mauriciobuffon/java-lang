package br.dev.webit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LiteralsTest {

    @Test
    public void byteLiterals() {
        // binary form "byte literals"
        assertEquals(Byte.MIN_VALUE, (byte) 0b1000_0000);
        assertEquals((byte) -1, (byte) 0b1111_1111);
        assertEquals((byte) 0, (byte) 0b0000_0000);
        assertEquals(Byte.MAX_VALUE, (byte) 0b0111_1111);

        // octal form "byte literals"
        assertEquals(Byte.MIN_VALUE, (byte) 0_200);
        assertEquals((byte) -1, (byte) 0_377);
        assertEquals((byte) 0, (byte) 0_000);
        assertEquals(Byte.MAX_VALUE, (byte) 0_177);

        // hexadecimal form "byte literals"
        assertEquals(Byte.MIN_VALUE, (byte) 0x80);
        assertEquals((byte) -1, (byte) 0xff);
        assertEquals((byte) 0, (byte) 0x00);
        assertEquals(Byte.MAX_VALUE, (byte) 0x7f);
    }

    @Test
    public void shortLiterals() {
        // binary form "short literals"
        assertEquals(Short.MIN_VALUE, (short) 0b1000_0000_0000_0000);
        assertEquals((short) -1, (short) 0b1111_1111_1111_1111);
        assertEquals((short) 0, (short) 0b0000_0000_0000_0000);
        assertEquals(Short.MAX_VALUE, (short) 0b0111_1111_1111_1111);

        // octal form "short literals"
        assertEquals(Short.MIN_VALUE, (short) 0_100_000);
        assertEquals((short) -1, (short) 0_177_777);
        assertEquals((short) 0, (short) 0_000_000);
        assertEquals(Short.MAX_VALUE, (short) 0_077_777);

        // hexadecimal form "short literals"
        assertEquals(Short.MIN_VALUE, (short) 0x8000);
        assertEquals((short) -1, (short) 0xffff);
        assertEquals((short) 0, (short) 0x0000);
        assertEquals(Short.MAX_VALUE, (short) 0x7fff);
    }

    @Test
    public void integerLiterals() {
        // binary form integer literals
        assertEquals(Integer.MIN_VALUE, 0b1000_0000_0000_0000_0000_0000_0000_0000);
        assertEquals(-1, 0b1111_1111_1111_1111_1111_1111_1111_1111);
        assertEquals(0, 0b0000_0000_0000_0000_0000_0000_0000_0000);
        assertEquals(Integer.MAX_VALUE, 0b0111_1111_1111_1111_1111_1111_1111_1111);

        // octal form integer literals
        assertEquals(Integer.MIN_VALUE, 020_000_000_000);
        assertEquals(-1, 037_777_777_777);
        assertEquals(0, 000_000_000_000);
        assertEquals(Integer.MAX_VALUE, 017_777_777_777);

        // hexadecimal form integer literals
        assertEquals(Integer.MIN_VALUE, 0x8000_0000);
        assertEquals(-1, 0xffff_ffff);
        assertEquals(0, 0x0000_0000);
        assertEquals(Integer.MAX_VALUE, 0x7fff_ffff);
    }

    @Test
    public void longLiterals() {
        // binary form long literals
        assertEquals(Long.MIN_VALUE,
                0b1000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L);
        assertEquals(-1L,
                0b1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L);
        assertEquals(0L,
                0b0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L);
        assertEquals(Long.MAX_VALUE,
                0b0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L);

        // octal form long literals
        assertEquals(Long.MIN_VALUE, 01_000_000_000_000_000_000_000L);
        assertEquals(-1L, 01_777_777_777_777_777_777_777L);
        assertEquals(0L, 00_000_000_000_000_000_000_000L);
        assertEquals(Long.MAX_VALUE, 00_777_777_777_777_777_777_777L);

        // hexadecimal form long literals
        assertEquals(Long.MIN_VALUE, 0x8000_0000_0000_0000L);
        assertEquals(-1L, 0xffff_ffff_ffff_ffffL);
        assertEquals(0L, 0x0000_0000_0000_0000L);
        assertEquals(Long.MAX_VALUE, 0x7fff_ffff_ffff_ffffL);
    }

    @Test
    public void characterLiterals() {
        final char c0 = 'm';
        final char c1 = '\u006d';
        final char c2 = 0b0000_0000_0110_1101;
        final char c3 = 0155;
        final char c4 = 109;
        final char c5 = 0x006d;
        final char c6 = '\155';

        assertEquals(c0, c1);
        assertEquals(c1, c2);
        assertEquals(c2, c3);
        assertEquals(c3, c4);
        assertEquals(c4, c5);
        assertEquals(c5, c6);
        assertEquals(c6, c0);
    }
}
