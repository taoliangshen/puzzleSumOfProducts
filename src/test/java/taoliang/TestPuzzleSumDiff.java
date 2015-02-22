package taoliang;


import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by tao on 20/02/15.
 *
 * // TODO create interface and pass class as configuration
 */
public class TestPuzzleSumDiff {

    PuzzleSolutionSumDifference puzzle;

    @Before
    public void setup() {
        puzzle = new PuzzleSolutionSumDifference();



    }

    @Test
    public void sampleN5C2() {

        final int n=5;
        final int c=2;

        assertEquals("21",puzzle.result(n,c).toString() );

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
