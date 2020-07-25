package com.renorycore.articles;

import com.renorycore.common.PathCreator;
import com.renorycore.common.interfaces.ArticlesService;
import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.text.Alias;
import com.renorycore.common.model.text.Text;
import com.renorycore.common.model.text.Title;
import java.io.File;

/**
 *
 * @author smit
 */
public class ArticlesServiceImpl extends FolderCms implements ArticlesService {

    private static final String SERVICE_FOLDER = "articles_service";
    private static final String CATEGORIES_FOLDER_NAME = "categories";
    private final FolderCms categoriesFolder;

    public ArticlesServiceImpl(File file) {
        super(new File(file + File.separator + SERVICE_FOLDER));
        this.categoriesFolder = new FolderCms(this.getAbsolutePath() + File.separator + CATEGORIES_FOLDER_NAME);
    }

    public ArticlesServiceImpl(String path) {
        super(path + File.separator + SERVICE_FOLDER);
        this.categoriesFolder = new FolderCms(this.getAbsolutePath() + File.separator + CATEGORIES_FOLDER_NAME);
    }

    @Override
    public Category create(Title title) {
        Alias alias = title.createAlias();
        String uniqeFolderName = new PathCreator().createUniqeFolderName(categoriesFolder, alias);
        return new Category(categoriesFolder + File.separator + uniqeFolderName, title);
    }

    @Override
    public Article create(Category category, Title title, Text text) {
        Article article = new Article(title, text);
        article.serialization(category);
        return article;
    }

}
