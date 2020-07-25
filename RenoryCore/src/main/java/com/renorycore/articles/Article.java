package com.renorycore.articles;

import com.renorycore.common.PathCreator;
import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.text.Alias;
import com.renorycore.common.model.text.Text;
import com.renorycore.common.model.text.Title;
import java.io.File;

/**
 *
 * @author smit
 */
public class Article {

    private final Title title;
    private final Text text;

    Article(Title title, Text text) {
        this.title = title;
        this.text = text;
    }

    void serialization(Category category) {
        Alias alias = title.createAlias();
        String uniqeFolderName = new PathCreator().createUniqeFolderName(category.getAbsolutePath(), alias);
        FolderCms articleFolder = new FolderCms(category.getAbsolutePath() + File.separator + uniqeFolderName);
        title.serialization(articleFolder);
        text.serialization(articleFolder);
    }

}
