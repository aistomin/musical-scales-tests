package com.github.aistomin.mst.domain;

import com.github.aistomin.mst.Displayable;
import java.util.List;

/**
 * Created by aistomin on 2019-05-27.
 * <p>
 * The musical scale interface.
 */
public interface Scale extends Displayable {

    /**
     * The scale's name.
     *
     * @return The scale's name.
     */
    String name();

    /**
     * All the notes of the scale.
     *
     * @return The notes.
     */
    List<Note> notes();
}
