package com.renorycore.common.model.filesystem;

import java.io.File;

/**
 *
 * @author smit
 */
public class FileCms extends File {

    public FileCms(File file) {
        super(file.getAbsolutePath());
        validFile();
    }

    public FileCms(String path) {
        super(path);
        validFile();
    }

    public String getExtension() {
        String fileName = super.getName();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public String getNameWithoutExtension() {
        String fileName = super.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private void validFile() {
        if (super.getName().contains("[.]+")) {
            throw new RuntimeException("Extension not found in the file '" + super.getAbsolutePath() + "'");
        }
    }
}
