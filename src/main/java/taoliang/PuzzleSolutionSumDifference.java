package taoliang;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;


/**
 * running through the series. the difference between each productOfProceeding is
 * the division of the old product and the new product.
 * example the product to sum for c=5 across the first n=10 range between 10 .. 5.
 *
 * <pre>
 * 10> 9 8 7 6 5
 *  9>   8 7 6 5 4      <= diff is div 9 * 4
 *  8>     7 6 5 4 3    <= diff is div 8 * 3
 *  7>       6 5 4 3 2
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

        if (n<=1) {
            return BigInteger.ZERO;
        }

        BigInteger resultSums = BigInteger.ZERO;
        PuzzleSolutionNaive puzzleNaive = new PuzzleSolutionNaive();
        BigInteger previousProduct = puzzleNaive.productOfProceeding(c, n);

        // immutable
        resultSums = previousProduct;

        // loop entire range from last to first number
        for (int currentPosition = n-1; currentPosition > 1; currentPosition--) {

            previousProduct = productDifference(c, currentPosition, previousProduct);
            resultSums = resultSums.add(previousProduct);

            logger.info("Processing position " + currentPosition );
            logger.debug( "new product=" + previousProduct);
        }


        return resultSums;

    }

    /**
     * calculate product difference by taking the previous product and working out
     * the number to divide and multiply based on product difference between the number 1 more than the
     * current number required
     *
     * @param c number of preceding elements to product
     * @param currentPosition is the position of the number to calculate
     * @param previousProduct
     * @return
     */
    private BigInteger productDifference(int c, int currentPosition, BigInteger previousProduct) {

        final int toMultiply = Math.max(1, currentPosition - c);

        logger.debug("divide=" + currentPosition + " multiply=" + toMultiply);
        return previousProduct.divide(BigInteger.valueOf( currentPosition )).multiply(BigInteger.valueOf(toMultiply));
    }


}
