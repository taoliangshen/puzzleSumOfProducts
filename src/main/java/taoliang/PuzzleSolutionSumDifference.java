package taoliang;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;


/**
 * PuzzleSolutionSumDifference uses the difference between each product value in the number range to trivialise
 * the calculation
 * <p>
 * Running through the N number series. the difference between each productOfProceeding is
 * the division of the old product and the new product.
 * <p>
 * for Example the product to sum for c=5 across the first n=10 range between 10 .. 5 is
 * <p/>
 * <pre>
 * 10> <em>9</em> 8 7 6 5
 *  9>   8 7 6 5 <em>4</em>      <= diff from product value of 10 is div 9 * 4
 *  8>     7 6 5 4 <em>3</em>    <= diff from product value of 9 is div 8 * 3
 *  7>       6 5 4 3 <em>2</em>
 *        ...so on
 * </pre>
 * the previous product is always guaranteed to be a divisor
 */
public class PuzzleSolutionSumDifference {

    static final Logger logger = LogManager.getLogger(PuzzleSolutionSumDifference.class.getName());


    /**
     * calculate final sum of a function across the entire range
     *
     * @param n the maximum size of the series. starting from 1. i.e. 1..n
     * @param c number of preceding elements to product
     * @return the sum of the function across the entire range
     */
    public BigInteger result(final int n, final int c) {

        if (n <= 1) {
            return BigInteger.ZERO;
        }

        BigInteger resultSums = BigInteger.ZERO;
        PuzzleSolutionNaive puzzleNaive = new PuzzleSolutionNaive();
        BigInteger previousProduct = puzzleNaive.productOfProceeding(c, n);

        // immutable
        resultSums = previousProduct;

        // loop entire range from last to first number
        for (int currentPosition = n - 1; currentPosition > 1; currentPosition--) {

            previousProduct = productDifference(c, currentPosition, previousProduct);
            resultSums = resultSums.add(previousProduct);

            logger.info("Processing position " + currentPosition);
            logger.debug("new product=" + previousProduct);
        }


        return resultSums;

    }

    /**
     * calculate product difference by taking the previous product and working out
     * the number to divide and multiply based on product difference between the number 1 more than the
     * current number required
     *
     * @param c               number of preceding elements to product
     * @param currentPosition is the position of the number to calculate
     * @param previousProduct
     * @return
     */
    private BigInteger productDifference(int c, int currentPosition, BigInteger previousProduct) {

        final int toMultiply = Math.max(1, currentPosition - c);

        logger.debug("divide=" + currentPosition + " multiply=" + toMultiply);
        return previousProduct.divide(BigInteger.valueOf(currentPosition)).multiply(BigInteger.valueOf(toMultiply));
    }


}
