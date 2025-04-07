package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

/**
 * Klasa testująca działanie metod z klasy DefaultCountingOutRhymer.
 *
 * Metody:
 * - testCountIn()
 *      testuje działanie metody countIn(int)
 * - testCallCheck()
 *      testuje działanie metody callCheck()
 *  - testIsFull()
 *      testuje działanie metody isFull()
 * - testPeekaboo()
 *      testuje działanie metody peekaboo()
 * - testCountOut()
 *      testuje działanie metody countOut()
 */
public class RhymersJUnitTest {

    /**
     * testuje działanie metody countIn(int)
     */
    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    /**
     * testuje działanie metody callCheck()
     */
    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertTrue(result);

        rhymer.countIn(888);

        result = rhymer.callCheck();
        Assert.assertFalse(result);
    }

    /**
     * testuje działanie metody isFull()
     */
    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertFalse(result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertTrue(result);
    }

    /**
     * testuje działanie metody peekaboo()
     */
    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    /**
     * testuje działanie metody countOut()
     */
    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

}