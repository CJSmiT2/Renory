package com.renorycore.articles;

import com.renorycore.common.PathCreator;
import com.renorycore.common.exception.ObjectNotFoundException;
import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.text.Alias;
import com.renorycore.common.model.text.Text;
import com.renorycore.common.model.text.Title;
import java.io.File;

/**
 *
 * @author smit
 */
public class Category extends FolderCms {

    private final Title title;

    Category(String path, Title title) {
        super(path);
        this.title = title;
        this.serialization();
    }

    Category(FolderCms folder) {
        super(folder);
        title = new Title();
        this.deserialization();
    }

    Article findArticle(Alias articleAlias) {
        for (FolderCms folder : this.getFolders()) {
            if (folder.getAlias().getValue().equals(articleAlias.getValue())) {
                return new Article(folder);
            }
        }
        throw new ObjectNotFoundException("Cant found Article by alias = '" + articleAlias.getValue() + "'");
    }

    Article createArticle(Title title, Text text) {
        String uniqeFolderName = new PathCreator().createUniqueFolderName(
                this.getAbsolutePath() + File.separator, title.createAlias());
        FolderCms articleFolder = new FolderCms(this.getAbsolutePath() + File.separator + uniqeFolderName);

        Article article = new Article(title, text, articleFolder);
        article.serialization();
        return article;
    }

    private void serialization() {
        this.title.serialization(this);
    }

    private void deserialization() {
        title.deserialization(this);
    }

}
