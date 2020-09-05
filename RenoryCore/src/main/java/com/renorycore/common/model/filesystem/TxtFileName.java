package com.renorycore.common.model.filesystem;

/**
 *
 * @author smit
 */
public class TxtFileName {

    private final String value;

    public TxtFileName(String value) {
        this.value = value;
    }

    public String getNameWithExtension() {
        return value + ".txt";
    }

}
