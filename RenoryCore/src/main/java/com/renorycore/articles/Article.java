package com.renorycore.articles;

import com.renorycore.common.PathCreator;
import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.text.Alias;
import com.renorycore.common.model.text.Text;
import com.renorycore.common.model.text.Title;
import com.renorycore.common.model.timestamps.CreationTime;
import java.io.File;

/**
 *
 * @author smit
 */
public class Article {

    private final Title title;
    private final Text text;
    private final CreationTime creationTime;

    Article(Title title, Text text) {
        this.title = title;
        this.text = text;
        creationTime = new CreationTime();
    }

    void serialization(Category category) {
        Alias alias = title.createAlias();
        String uniqueFolderName = new PathCreator().createUniqueFolderName(category.getAbsolutePath(), alias);
        FolderCms articleFolder = new FolderCms(category.getAbsolutePath() + File.separator + uniqueFolderName);
        title.serialization(articleFolder);
        text.serialization(articleFolder);
        creationTime.serialization(articleFolder);
    }

    public Title getTitle() {
        return title;
    }

    public Text getText() {
        return text;
    }

}
