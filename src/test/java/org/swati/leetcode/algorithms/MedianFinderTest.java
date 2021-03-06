package org.swati.leetcode.algorithms;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

/**
 * Median finder test case
 *
 * @author Swati Kumar
 * @since 1.0.0
 */
public class MedianFinderTest {
    MedianFinder mf = new MedianFinder();

    @Test
    public void testMedianFinder() {
        mf.addNum(1);
        mf.addNum(2);
        assertEquals(1.5, mf.findMedian());
        mf.addNum(3);
        assertEquals(2.0, mf.findMedian());
        mf.addNum(4);
        assertEquals(2.5, mf.findMedian());
        mf.addNum(5);
        assertEquals(3.0, mf.findMedian());
    }

    @Test
    public void testWhenInputNotInOrder() {
        mf.addNum(5);
        mf.addNum(3);
        mf.addNum(1);
        mf.addNum(3);
        mf.addNum(4);
        assertEquals(3.0, mf.findMedian());
    }
}
