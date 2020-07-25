package com.renorycore.common.model.text;

import com.renorycore.common.model.filesystem.TxtFileName;

/**
 *
 * @author smit
 */
public class Text extends StringWrap {

    public static String NAME = "text";

    public Text(String value) {
        super(value, new TxtFileName(NAME));
    }

    public boolean isEmpty() {
        return super.getValue() == null || super.getValue().isEmpty();
    }

}
