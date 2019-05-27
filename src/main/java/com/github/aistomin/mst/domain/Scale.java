package com.github.aistomin.mst.domain;

import com.github.aistomin.mst.Displayable;

/**
 * Created by aistomin on 2019-05-27.
 *
 * The musical scale interface.
 */
public interface Scale extends Displayable {

    /**
     * The scale's name.
     * @return The scale's name.
     */
    String name();
}
