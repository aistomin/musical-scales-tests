package com.github.aistomin.mst.domain;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Created by aistomin on 2019-05-27.
 */
final class MajorScaleTest {

    /**
     * Check that we correctly return the name of the scale.
     */
    @Test
    void testName() {
        assertEquals("C Major Scale", new MajorScale(Note.C).name());
    }
}
