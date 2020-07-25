package com.renorycore.articles;

import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.text.Title;

/**
 *
 * @author smit
 */
public class Category extends FolderCms {

    private final Title title;

    Category(String path, Title title) {
        super(path);
        this.title = title;
    }

}
