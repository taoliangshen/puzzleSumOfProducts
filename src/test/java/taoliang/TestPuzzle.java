package taoliang;


import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by tao on 20/02/15.
 */
public class TestPuzzle {

    PuzzleSolutionNaive puzzle;

    @Before
    public void setup() {
        puzzle = new PuzzleSolutionNaive();



    }

    @Test
    public void sampleN5C2() {

        final int n=5;
        final int c=2;

        assertEquals("21",puzzle.result(n,c).toString() );

    }

    @Test
    public void productOfSumN100C10() {

        final int n=100;
        final int c=10;

        BigInteger val1 = BigInteger.valueOf(99);
        BigInteger val2 = BigInteger.valueOf(98);
        BigInteger val3 = BigInteger.valueOf(97);
        BigInteger val4 = BigInteger.valueOf(96);
        BigInteger val5 = BigInteger.valueOf(95);
        BigInteger val6 = BigInteger.valueOf(94);
        BigInteger val7 = BigInteger.valueOf(93);
        BigInteger val8 = BigInteger.valueOf(92);
        BigInteger val9 = BigInteger.valueOf(91);
        BigInteger val10 = BigInteger.valueOf(90);
        
        BigInteger expected = val1.multiply(val2.multiply(val3.multiply(val4.multiply(val5.multiply(val6.multiply(val7.multiply(val8.multiply(val9.multiply(val10)))))))));


        assertEquals(expected, puzzle.productOfProceeding(c, n));

    }

    @Test
    public void productOfSmallSumN10C4() {

        final int n=10;
        final int c=4;

        BigInteger val1 = BigInteger.valueOf(9);
        BigInteger val2 = BigInteger.valueOf(8);
        BigInteger val3 = BigInteger.valueOf(7);
        BigInteger val4 = BigInteger.valueOf(6);

        BigInteger expected = val1.multiply(val2.multiply(val3.multiply(val4)));

        assertEquals(expected, puzzle.productOfProceeding(c, n));
    }

    @Test
    public void sumSeriesOneElementN2C10() {

        final int n=2;
        final int c=10;

        assertEquals(1l, puzzle.result(n, c).longValue());
    }

    @Test
    public void sumSeriesSimpleN4C10() {

        final int n=4;
        final int c=10;

        assertEquals((1+2+6), puzzle.result(n, c).longValue());
    }

    @Test
    public void sumSeriesSimpleN5C10() {

        final int n=5;
        final int c=10;

        assertEquals((1+2+6+24), puzzle.result(n, c).longValue());
    }
    @Test
    public void sumSeriesN6C3() {

        final int n=6;
        final int c=3;

        long result = (5*4*3) + (4*3*2) + (3*2*1)+ (2*1)+ (1);

        assertEquals(result, puzzle.result(n, c).longValue());
    }


    @Test
    public void sumProductOfSmallSumN10C4() {

        final int n=10;
        final int c=4;

        int expected =
                (9*8*7*6) +
                (8*7*6*5) +
                (7*6*5*4) +
                (6*5*4*3) +
                (5*4*3*2) +
                (4*3*2*1) +
                (3*2*1) +
                (2) +
                (1);

        assertEquals(expected, puzzle.result(n, c).intValue());
    }

}
