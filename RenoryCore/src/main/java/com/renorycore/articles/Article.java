package com.renorycore.articles;

import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.text.Text;
import com.renorycore.common.model.text.Title;
import com.renorycore.common.model.timestamps.CreationTime;

/**
 *
 * @author smit
 */
public class Article extends FolderCms {

    private final Title title;
    private final Text text;
    private final CreationTime creationTime;

    Article(Title title, Text text, FolderCms folder) {
        super(folder);
        this.title = title;
        this.text = text;
        creationTime = new CreationTime();
    }

    Article(FolderCms folder) {
        super(folder);
        title = new Title();
        text = new Text();
        creationTime = new CreationTime();
        deserialization();
    }

    void serialization() {
        title.serialization(this);
        text.serialization(this);
        creationTime.serialization(this);
    }

    private void deserialization() {
        title.deserialization(this);
        text.deserialization(this);
        creationTime.deserialization(this);
    }

    public Title getTitle() {
        return title;
    }

    public Text getText() {
        return text;
    }

    public CreationTime getCreationTime() {
        return creationTime;
    }

}
