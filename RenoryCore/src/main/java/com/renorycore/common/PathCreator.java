package com.renorycore.common;

import com.renorycore.common.model.text.Alias;
import java.io.File;

/**
 *
 * @author smit
 */
public class PathCreator {

    public String createUniqeFolderName(File dest, Alias alias) {
        return PathCreator.this.createUniqeFolderName(dest.getAbsolutePath(), alias);
    }

    public String createUniqeFolderName(String dest, Alias alias) {
        String prefix = "";
        int step = 1;

        while (true) {
            File categoryPath = new File(dest + File.separator + alias.getValue() + prefix);
            if (!categoryPath.exists()) {
                return categoryPath.getName();
            }
            step++;
            prefix = "_" + String.valueOf(step);
        }

    }
}
