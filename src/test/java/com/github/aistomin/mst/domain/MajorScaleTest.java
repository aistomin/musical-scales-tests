package com.github.aistomin.mst.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * Created by aistomin on 2019-05-27.
 */
final class MajorScaleTest {

    /**
     * Check that we properly construct the scale.
     */
    @Test
    void testCtor() {
        assertEquals(
            "C Major Scale: C, D, E, F, G, A, B, C",
            new MajorScale(Note.C).toDisplayableString()
        );
        assertEquals(
            "C# Major Scale: C#, D#, F, F#, G#, A#, C, C#",
            new MajorScale(Note.Csharp).toDisplayableString()
        );
        assertEquals(
            "D Major Scale: D, E, F#, G, A, B, C#, D",
            new MajorScale(Note.D).toDisplayableString()
        );
        assertEquals(
            "D# Major Scale: D#, F, G, G#, A#, C, D, D#",
            new MajorScale(Note.Dsharp).toDisplayableString()
        );
        assertEquals(
            "E Major Scale: E, F#, G#, A, B, C#, D#, E",
            new MajorScale(Note.E).toDisplayableString()
        );
        assertEquals(
            "F Major Scale: F, G, A, A#, C, D, E, F",
            new MajorScale(Note.F).toDisplayableString()
        );
        assertEquals(
            "F Major Scale: F, G, A, A#, C, D, E, F",
            new MajorScale(Note.F).toDisplayableString()
        );
        assertEquals(
            "F# Major Scale: F#, G#, A#, B, C#, D#, F, F#",
            new MajorScale(Note.Fsharp).toDisplayableString()
        );
        assertEquals(
            "G Major Scale: G, A, B, C, D, E, F#, G",
            new MajorScale(Note.G).toDisplayableString()
        );
        assertEquals(
            "G# Major Scale: G#, A#, C, C#, D#, F, G, G#",
            new MajorScale(Note.Gsharp).toDisplayableString()
        );
        assertEquals(
            "A Major Scale: A, B, C#, D, E, F#, G#, A",
            new MajorScale(Note.A).toDisplayableString()
        );
        assertEquals(
            "A# Major Scale: A#, C, D, D#, F, G, A, A#",
            new MajorScale(Note.Asharp).toDisplayableString()
        );
        assertEquals(
            "B Major Scale: B, C#, D#, E, F#, G#, A#, B",
            new MajorScale(Note.B).toDisplayableString()
        );
        assertThrows(IllegalStateException.class, () -> new MajorScale(Note.c));
    }

    /**
     * Check that we correctly return the name of the scale.
     */
    @Test
    void testName() {
        assertEquals("C Major Scale", new MajorScale(Note.C).name());
    }

    /**
     * Check that the scale contains correct list of notes.
     */
    @Test
    void testNotes() {
        final List<Note> notes = new MajorScale(Note.C).notes();
        assertEquals(Note.C, notes.get(0));
        assertEquals(Note.D, notes.get(1));
        assertEquals(Note.E, notes.get(2));
        assertEquals(Note.F, notes.get(3));
        assertEquals(Note.G, notes.get(4));
        assertEquals(Note.A, notes.get(5));
        assertEquals(Note.B, notes.get(6));
        assertEquals(Note.C, notes.get(7));
    }

    /**
     * Check that we correctly identify the major scale's degrees.
     */
    @Test
    void testMajorScaleDegrees() {
        final MajorScale scale = new MajorScale(Note.C);
        assertEquals(Note.C, scale.tonic());
        assertEquals(Note.D, scale.supertonic());
        assertEquals(Note.E, scale.mediant());
        assertEquals(Note.F, scale.subdominant());
        assertEquals(Note.G, scale.dominant());
        assertEquals(Note.A, scale.submediant());
        assertEquals(Note.B, scale.leadingTone());
    }

    /**
     * Check that we correctly convert the scale to the JSON.
     */
    @Test
    void testToJson() {
        final JSONObject json = new MajorScale(Note.C).toJson();
        assertEquals("C Major Scale", json.get("name"));
        final JSONArray notes = (JSONArray) json.get("notes");
        assertEquals(8, notes.size());
        assertEquals(Note.C.helmholtzName(), notes.get(0));
        assertEquals(Note.D.helmholtzName(), notes.get(1));
        assertEquals(Note.E.helmholtzName(), notes.get(2));
        assertEquals(Note.F.helmholtzName(), notes.get(3));
        assertEquals(Note.G.helmholtzName(), notes.get(4));
        assertEquals(Note.A.helmholtzName(), notes.get(5));
        assertEquals(Note.B.helmholtzName(), notes.get(6));
        assertEquals(Note.C.helmholtzName(), notes.get(7));
    }
}
