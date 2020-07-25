package com.renorycore.common.model.text;

import com.renorycore.common.model.filesystem.TxtFileName;

/**
 *
 * @author smit
 */
public class Title extends StringWrap {

    public static final String NAME = "title";

    public Title(String value) {
        super(value, new TxtFileName(NAME));
    }

    public Alias createAlias() {
        Alias alias = new Alias();
        alias.createAlias(super.getValue());
        return alias;
    }

}
