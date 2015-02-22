package taoliang;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;


/**
 * Created by tao on 20/02/15.
 * You have a range of consecutive numbers, from 1 to n (inclusive). e.g. [1, 2, 3, 4... n]. We would like to calculate a sum of a function across the entire range, where the function returns the product of the *preceding* C elements.
 * If there are less than C previous elements, just use the available numbers. i.e. if you are processing the fourth number in the range, but C is greater than 3, then you will calculate the product using only the 3 available preceding numbers. In this situation as you move further along in this range more preceding numbers become available.
 */
public class PuzzleSolutionNaive {

    static final Logger logger = LogManager.getLogger(PuzzleSolutionNaive.class.getName());


    /**
     * calculate final sum of a function across the entire range
     *
     * @param n the maximum size of the series. starting from 1. i.e. 1..n
     * @param c number of preceding elements to product
     * @return the sum of the function across the entire range
     */
    public BigInteger result(final int n, final int c) {

        BigInteger resultSums = BigInteger.ZERO;

        // loop entire range from last to second number (first number =0)
        for (int currentPosition = n; currentPosition > 1; currentPosition--) {

            resultSums = resultSums.add(productOfProceeding(c, currentPosition));

            logger.info("Processing position " + currentPosition);
        }


        return resultSums;

    }

    /**
     * calculate proceeding product
     *
     * @param c        number of preceding elements to product
     * @param position current position in the number range
     * @return the product of the preceding c elements
     */
    public BigInteger productOfProceeding(final int c, final int position) {

        if ((c <= 0) || (position <= 1)) {
            return BigInteger.ZERO;
        }

        // initialise product to 1 (to itself)
        BigInteger product = BigInteger.ONE;

        for (int proceedingElement = c; proceedingElement > 0; proceedingElement--) {

            // ignore proceeding element
            if ((position - proceedingElement) > 1) {

                product = product.multiply(BigInteger.valueOf(position - proceedingElement));

                if (logger.isDebugEnabled()) {
                    logger.debug("*" + (position - proceedingElement));
                }
            }

        }

        logger.debug("on " + position + " product=" + product);

        return product;
    }


}
