package taoliang;

import com.google.common.base.Stopwatch;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.Assert.assertEquals;

/**
 * Created by tao on 21/02/15.
 */
public class TestSolutions {

    PuzzleSolutionNaive naiveSolution;
    PuzzleSolutionSumDifference sumDiffSolution;
    NumberFormat formatter;
    @Before
    public void setup() {
        naiveSolution = new PuzzleSolutionNaive();
        sumDiffSolution = new PuzzleSolutionSumDifference();

        formatter = new DecimalFormat("0.0E0");
        formatter.setRoundingMode(RoundingMode.HALF_UP);
        formatter.setMinimumFractionDigits(10);

    }

    @Test
    public void solutionSumDiffN100C10() {

        final int n=100;
        final int c=10;

        assertEquals("513946235090696089113", sumDiffSolution.result(n, c).toString());

    }

    @Ignore ("solutionSumDiffN1000000C200 time: 53.90 s")
    @Test
    public void solutionSumDiffN1000000C200() {

        final int n=1000000;
        final int c=200;

        Stopwatch stopwatch = Stopwatch.createStarted();

        BigInteger answer = sumDiffSolution.result(n, c);

        System.out.println("solutionSumDiffN1000000C200 time: " + stopwatch);
        assertEquals("4.8761161273E1203", formatter.format(answer));

    }

    @Ignore ("solutionSumDiffN1000000C200 time: 29.72 min")
    @Test
    public void solutionSumDiffN10000000C200() {

        final int n=10000000;
        final int c=200;

        Stopwatch stopwatch = Stopwatch.createStarted();

        BigInteger answer = sumDiffSolution.result(n, c);

        System.out.println("solutionSumDiffN1000000C200 time: " + stopwatch);
        assertEquals("4.9651343547E1404", formatter.format(answer));

    }

    @Test
    public void solutionNaiveN100C10() {

        final int n=100;
        final int c=10;

        assertEquals("513946235090696089113", naiveSolution.result(n, c).toString());

    }


    @Ignore ("solutionNaiveN1000000C200 time: 1.163 min")
    @Test
    public void solutionNaiveN1000000C200() {

        final int n=1000000;
        final int c=200;

        Stopwatch stopwatch = Stopwatch.createStarted();

        BigInteger answer = naiveSolution.result(n, c);

        System.out.println("solutionNaiveN1000000C200 time: " + stopwatch);
        assertEquals("4.8761161273E1203", formatter.format(answer));

    }


}
