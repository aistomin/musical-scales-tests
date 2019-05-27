package com.github.aistomin.mst.domain;

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
     * Ctor.
     *
     * @param tonic The tonic note of the scale.
     */
    public MajorScale(final Note tonic) {
        this.tonic = tonic;
    }

    @Override
    public String name() {
        return String.format("%s Major", this.tonic.helmholtzName());
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
}
