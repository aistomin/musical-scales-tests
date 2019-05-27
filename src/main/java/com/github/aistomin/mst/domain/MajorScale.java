package com.github.aistomin.mst.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.json.simple.JSONObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by aistomin on 2019-05-27.
 * <p>
 * The major scale (or Ionian scale) is one of the most commonly used musical
 * scales, especially in Western music. It is one of the diatonic scales. Like
 * many musical scales, it is made up of seven notes: the eighth duplicates the
 * first at double its frequency so that it is called a higher octave of the
 * same note (from Latin "octavus", the eighth).
 */
public final class MajorScale implements Scale {

    /**
     * The tonic note of the scale.
     */
    private final Note tonic;

    /**
     * Major scale's degrees.
     */
    private final List<Note> degrees;

    /**
     * Ctor.
     *
     * @param tonic The tonic(key note) of the scale.
     */
    public MajorScale(final Note tonic) {
        final List<Note> notes = Note.simpleNotes();
        if (!notes.contains(tonic)) {
            throw new IllegalStateException(
                String.format(
                    "%s is not in list %s",
                    tonic.helmholtzName(),
                    notes
                        .stream()
                        .map(Note::helmholtzName)
                        .collect(Collectors.toList())
                )
            );
        }
        this.tonic = tonic;
        final Note.Scroll scroll = new Note.Scroll(this.tonic, notes);
        this.degrees = new ArrayList<>(8);
        this.degrees.set(0, this.tonic);
        // T–T–S–T–T–T–S
        this.degrees.set(1, scroll.scroll(2));
        this.degrees.set(2, scroll.scroll(4));
        this.degrees.set(3, scroll.scroll(5));
        this.degrees.set(4, scroll.scroll(7));
        this.degrees.set(5, scroll.scroll(9));
        this.degrees.set(6, scroll.scroll(11));
        this.degrees.set(7, scroll.scroll(12));
    }

    @Override
    public String name() {
        return String.format("%s Major Scale", this.tonic.helmholtzName());
    }

    @Override
    public String toDisplayableString() {
        // TODO: solve in scope of Issue #5
        throw new NotImplementedException();
    }

    @Override
    public JSONObject toJson() {
        // TODO: solve in scope of Issue #5
        throw new NotImplementedException();
    }

    /**
     * The tonic(key note) of the major scale.
     *
     * @return The tonic.
     */
    Note tonic() {
        return this.tonic;
    }

    /**
     * The supertonic of the major scale.
     *
     * @return The supertonic.
     */
    Note supertonic() {
        return this.degrees.get(1);
    }

    /**
     * The mediant of the major scale.
     *
     * @return The mediant.
     */
    Note mediant() {
        return this.degrees.get(2);
    }

    /**
     * The subdominant of the major scale.
     *
     * @return The subdominant.
     */
    Note subdominant() {
        return this.degrees.get(3);
    }

    /**
     * The dominant of the major scale.
     *
     * @return The dominant.
     */
    Note dominant() {
        return this.degrees.get(4);
    }

    /**
     * The submediant of the major scale.
     *
     * @return The submediant.
     */
    Note submediant() {
        return this.degrees.get(5);
    }

    /**
     * The leading tone of the major scale.
     *
     * @return The leading tone.
     */
    Note leadingTone() {
        return this.degrees.get(6);
    }
}
