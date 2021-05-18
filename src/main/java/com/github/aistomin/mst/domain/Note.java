package com.github.aistomin.mst.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aistomin on 08.10.18.
 * <p>
 * All the notes available on the 6-strings guitar in the standard
 * tuning (E-A-D-G-B-E). 1-12 frets. Plus notes C-D#.
 * The notes are named according to Helmholtz pitch notation.
 * http://egalo.com/2012/05/03/notes-on-the-guitar-fretboard-introduction/
 */
public enum Note {
    C,
    Csharp,
    D,
    Dsharp,
    E,
    F,
    Fsharp,
    G,
    Gsharp,
    A,
    Asharp,
    B,
    c,
    csharp,
    d,
    dsharp,
    e,
    f,
    fsharp,
    g,
    gsharp,
    a,
    asharp,
    b,
    c_,
    c_sharp,
    d_,
    d_sharp,
    e_,
    f_,
    f_sharp,
    g_,
    g_sharp,
    a_,
    a_sharp,
    b_,
    c__,
    c__sharp,
    d__,
    d__sharp,
    e__;

    /**
     * The name of the note in the Helmholtz pitch notation.
     *
     * @return The name.
     */
    public String helmholtzName() {
        return name().replace("_", "'").replace("sharp", "#");
    }

    /**
     * Get the list of the simple 12 halftones.
     *
     * @return The simple notes.
     */
    public static List<Note> simpleNotes() {
        return Arrays.asList(
            C,
            Csharp,
            D,
            Dsharp,
            E,
            F,
            Fsharp,
            G,
            Gsharp,
            A,
            Asharp,
            B
        );
    }

    /**
     * Scroll through the the notes from current note.
     */
    public static class Scroll {

        /**
         * The current note.
         */
        private final Note current;

        /**
         * The notes.
         */
        private final List<Note> notes;

        /**
         * Ctor.
         *
         * @param current The current note.
         * @param notes   The notes.
         */
        public Scroll(Note current, List<Note> notes) {
            this.current = current;
            this.notes = notes;
        }

        /**
         * Scroll certain amount of semitones from the current position.
         *
         * @param semitones The amount of semitones.
         * @return The new position.
         */
        public Note scrollTo(final Integer semitones) {
            final int next = notes.indexOf(current) + semitones;
            final int size = notes.size();
            final int loops = next / size;
            return notes.get(next - size * loops);
        }
    }
}
