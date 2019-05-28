package com.github.aistomin.mst.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
        this.degrees.add(this.tonic);
        // T–T–S–T–T–T–S
        this.degrees.add(scroll.scrollTo(2));
        this.degrees.add(scroll.scrollTo(4));
        this.degrees.add(scroll.scrollTo(5));
        this.degrees.add(scroll.scrollTo(7));
        this.degrees.add(scroll.scrollTo(9));
        this.degrees.add(scroll.scrollTo(11));
        this.degrees.add(scroll.scrollTo(12));
    }

    @Override
    public String name() {
        return String.format("%s Major Scale", this.tonic.helmholtzName());
    }

    @Override
    public List<Note> notes() {
        return this.degrees;
    }

    @Override
    public String toDisplayableString() {
        return String.format(
            "%s: %s",
            this.name(),
            this.degrees
                .stream()
                .map(Note::helmholtzName)
                .collect(Collectors.joining(", "))
        );
    }

    @Override
    public JSONObject toJson() {
        final HashMap<String, Object> json = new HashMap<>();
        json.put("name", this.name());
        final JSONArray notes = new JSONArray();
        for (final Note note : this.degrees) {
            notes.add(note.helmholtzName());
        }
        json.put("notes", notes);
        return new JSONObject(json);
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
