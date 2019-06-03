package com.github.aistomin.mst.simple;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * Created by aistomin on 2019-01-03.
 * <p>
 * The test for {@link SimpleResult}
 */
final class SimpleResultTest {

    /**
     * Check that we can correctly create the simple test result if we provide
     * correct arguments.
     */
    @Test
    void testConstructor() {
        final String nulls = "All the constructor parameters must be provided.";
        assertEquals(
            nulls, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(null, 0, 0, 0)
            ).getMessage()
        );
        assertEquals(
            nulls,
            assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(0, null, 0, 0)
            ).getMessage()
        );
        assertEquals(
            nulls, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(0, 0, null, 0)
            ).getMessage()
        );
        assertEquals(
            nulls, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(0, 0, 0, null)
            ).getMessage()
        );
        assertEquals(
            nulls,
            assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(1, 1, 1, 0, null)
            ).getMessage()
        );
        final String positives = "All the constructor parameters must be positive.";
        assertEquals(
            positives, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(-1, 0, 0, 0)
            ).getMessage()
        );
        assertEquals(
            positives, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(0, -1, 0, 0)
            ).getMessage()
        );
        assertEquals(
            positives, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(0, 0, -1, 0)
            ).getMessage()
        );
        assertEquals(
            positives, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(0, 0, 0, -1)
            ).getMessage()
        );
        final String common = "Constructor parameters must not contradict the common sense.";
        assertEquals(
            common, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(6, 7, 4, 3)
            ).getMessage()
        );
        assertEquals(
            common, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(7, 6, 4, 3)
            ).getMessage()
        );
        assertNotNull(
            new SimpleResult(7, 6, 4, 2).toDisplayableString()
        );
        final String percentage =
            "'percentage' parameter must be between 0 and 100.";
        assertEquals(
            percentage, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(1, 1, 1, 0, -1)
            ).getMessage()
        );
        assertEquals(
            percentage, assertThrows(
                IllegalArgumentException.class,
                () -> new SimpleResult(1, 1, 1, 0, 101)
            ).getMessage()
        );
    }

    /**
     * Check that we correctly detect if the test is finished.
     */
    @Test
    void testIsFinished() {
        assertTrue(
            new SimpleResult(2, 2, 1, 1, 60)
                .isFinished()
        );
        assertFalse(
            new SimpleResult(3, 1, 1, 0, 50)
                .isFinished()
        );
    }

    /**
     * Check that we correctly detect if the test is passed.
     */
    @Test
    void testIsPassed() {
        assertFalse(
            new SimpleResult(3, 2, 2, 0, 50)
                .isPassed()
        );
        assertFalse(
            new SimpleResult(4, 4, 2, 2, 60)
                .isPassed()
        );
        assertTrue(
            new SimpleResult(5, 5, 3, 2, 50)
                .isPassed()
        );
        assertTrue(
            new SimpleResult(6, 6, 6, 0, 50)
                .isPassed()
        );
    }

    /**
     * Check that we correctly convert the result to JSON string.
     */
    @Test
    void toJsonString() {
        final int total = 7;
        final int answered = 6;
        final int correct = 4;
        final int wrong = 2;
        final int percentage = 50;
        final JSONObject json = new SimpleResult(
            total, answered, correct, wrong, percentage
        ).toJson();
        assertEquals(total, Integer.parseInt(json.get("total").toString()));
        assertEquals(
            answered, Integer.parseInt(json.get("answered").toString())
        );
        assertEquals(correct, Integer.parseInt(json.get("correct").toString()));
        assertEquals(wrong, Integer.parseInt(json.get("wrong").toString()));
        assertEquals(
            percentage, Integer.parseInt(json.get("percentage").toString())
        );
    }

    @Test
    void toDisplayableString() {
        final String partial = new SimpleResult(7, 6, 4, 2, 90)
            .toDisplayableString();
        assertTrue(partial.contains("YOU TEST IS NOT FINISHED."));
        assertTrue(partial.contains("TOTAL: 7"));
        assertTrue(partial.contains("ANSWERED: 6"));
        assertTrue(partial.contains("CORRECT: 4"));
        assertTrue(partial.contains("WRONG: 2"));
        assertTrue(partial.contains("PASSING PERCENTAGE: 90"));
        assertTrue(partial.contains("PLEASE CONTINUE."));
        final String failed = new SimpleResult(7, 7, 5, 2, 90)
            .toDisplayableString();
        assertTrue(failed.contains("YOUR TEST IS FINISHED."));
        assertTrue(failed.contains("CORRECT: 5"));
        assertTrue(failed.contains("WRONG: 2"));
        assertTrue(failed.contains("PASSING PERCENTAGE: 90"));
        assertTrue(failed.contains("PREPARE AND TRY AGAIN LATER"));
        final String success = new SimpleResult(7, 7, 5, 2, 50)
            .toDisplayableString();
        assertTrue(success.contains("YOUR TEST IS FINISHED."));
        assertTrue(success.contains("CORRECT: 5"));
        assertTrue(success.contains("WRONG: 2"));
        assertTrue(success.contains("PASSING PERCENTAGE: 50"));
        assertTrue(success.contains("CONGRATULATIONS!!!"));
    }
}
