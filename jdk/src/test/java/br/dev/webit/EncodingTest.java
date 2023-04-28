package br.dev.webit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EncodingTest {

    @ParameterizedTest
    @ValueSource(ints = { 0x1f310, 0x1f64c })
    public void unicodeToUft16Encoding(final int unicode) {
        /**
         * https://www.unicode.org/glossary/#high_surrogate_code_point
         *
         * A 16-bit code unit in the range D800 to DBFF, used in UTF-16 as the
         * leading code unit of a surrogate pair
         */
        final int highSurrogate = 0xd800;
        /**
         * https://www.unicode.org/glossary/#low_surrogate_code_point
         *
         * A 16-bit code unit in the range DC00 to DFFF, used in UTF-16 as the
         * trailing code unit of a surrogate pair
         */
        final int lowSurrogate = 0xdc00;

        /**
         * [D800 .. DBFF] = [DC00 .. DFFF] = 0400
         *
         * The range size of the surrogates
         */
        final int range = 0x0400;

        /**
         * https://www.unicode.org/glossary/#supplementary_code_point
         *
         * A Unicode code point between U+10000 and U+10FFFF
         */
        final int supplementary = Character.MIN_SUPPLEMENTARY_CODE_POINT;

        if (unicode >= supplementary) {
            final int diff = unicode - supplementary;
            final int[] pair = {
                    highSurrogate + (diff / range),
                    lowSurrogate + (diff % range)
            };

            final char[] chararray = Character.toChars(unicode);

            assertEquals((int) chararray[0], pair[0]);
            assertEquals((int) chararray[1], pair[1]);

            byte[] bytearray = {
                    (byte) (pair[0] >> 8 & 0xff),
                    (byte) (pair[0] & 0xff),
                    (byte) (pair[1] >> 8 & 0xff),
                    (byte) (pair[1] & 0xff)
            };

            var buffer = ByteBuffer.allocate(chararray.length * 2);
            for (char c : chararray) {
                buffer.putChar(c);
            }

            assertArrayEquals(buffer.array(), bytearray);

            assertEquals(new String(new int[] { unicode }, 0, 1), new String(bytearray, StandardCharsets.UTF_16));
            // System.out.println(new String(bytearray, StandardCharsets.UTF_16));
        }
    }
}
