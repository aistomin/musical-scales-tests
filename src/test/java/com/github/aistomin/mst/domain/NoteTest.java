package com.github.aistomin.mst.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Created by aistomin on 09.10.18.
 * <p>
 * The tests for {@link Note}
 */
final class NoteTest {

    /**
     * Check that we correctly display the names of the notes in Helmholtz pitch
     * notation.
     */
    @Test
    void testHelmholtzName() {
        assertEquals("E", Note.E.helmholtzName());
        assertEquals("F#", Note.Fsharp.helmholtzName());
        assertEquals("c", Note.c.helmholtzName());
        assertEquals("d#", Note.dsharp.helmholtzName());
        assertEquals("c'", Note.c_.helmholtzName());
        assertEquals("d'#", Note.d_sharp.helmholtzName());
        assertEquals("c''", Note.c__.helmholtzName());
        assertEquals("d''#", Note.d__sharp.helmholtzName());
    }

    /**
     * Check that we correctly return the list of the simple notes.
     */
    @Test
    void testSimpleNotes() {
        final List<Note> notes = Note.simpleNotes();
        assertEquals(12, notes.size());
        assertEquals(Note.C, notes.get(0));
        assertEquals(Note.Csharp, notes.get(1));
        assertEquals(Note.D, notes.get(2));
        assertEquals(Note.Dsharp, notes.get(3));
        assertEquals(Note.E, notes.get(4));
        assertEquals(Note.F, notes.get(5));
        assertEquals(Note.Fsharp, notes.get(6));
        assertEquals(Note.G, notes.get(7));
        assertEquals(Note.Gsharp, notes.get(8));
        assertEquals(Note.A, notes.get(9));
        assertEquals(Note.Asharp, notes.get(10));
        assertEquals(Note.B, notes.get(11));
    }
}
