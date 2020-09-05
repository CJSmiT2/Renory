package com.renorycore.common.model.text;

import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.filesystem.TxtFileName;
import com.renorycore.common.model.filesystem.TxtFile;
import java.io.File;
import java.util.Objects;

/**
 *
 * @author smit
 */
public class StringWrap {

    private String value;
    private final TxtFileName fileName;

    public StringWrap(String value, TxtFileName fileName) {
        this.value = value;
        this.fileName = fileName;
    }

    public StringWrap(TxtFileName fileName) {
        this.fileName = fileName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void serialization(FolderCms folder) {
        new TxtFile(getFilePath(folder)).write(value);
    }

    public void deserialization(FolderCms folder) {
        value = new TxtFile(getFilePath(folder)).readString();
    }

    private String getFilePath(FolderCms folder) {
        return folder + File.separator + fileName.getNameWithExtension();
    }

    public TxtFileName getFileName() {
        return fileName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.value);
        hash = 37 * hash + Objects.hashCode(this.fileName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StringWrap other = (StringWrap) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StringWrap{" + "value=" + value + '}';
    }

}
