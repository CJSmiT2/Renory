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
    private TxtFileName fileName;

    public StringWrap(String value, TxtFileName fileName) {
        this.value = value;
        this.fileName = fileName;
    }

    public StringWrap() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void serialization(FolderCms folder) {
        String filePath = folder + File.separator + fileName.getNameWithExtension();
        new TxtFile(filePath).write(value);
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
        return true;
    }

    @Override
    public String toString() {
        return "StringWrap{" + "value=" + value + '}';
    }

}
