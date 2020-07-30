package com.renorycore.common;

import com.renorycore.common.model.text.Alias;
import java.io.File;

/**
 *
 * @author smit
 */
public class PathCreator {

    public String createUniqueFolderName(File dest, Alias alias) {
        return PathCreator.this.createUniqueFolderName(dest.getAbsolutePath(), alias);
    }

    public String createUniqueFolderName(String dest, Alias alias) {
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
