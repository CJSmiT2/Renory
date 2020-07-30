package com.renorycore.articles;

import com.renorycore.main.config.Config;
import com.renorycore.common.interfaces.ArticlesService;
import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.filesystem.TxtFile;
import com.renorycore.common.model.text.CreationTime;
import com.renorycore.common.model.text.Text;
import com.renorycore.common.model.text.Title;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author smit
 */
public class ArticlesServiceImplTest {

    ArticlesService articlesService = new ArticlesServiceImpl(Config.ROOT_DIRECTORY);

    @After
    public void delete() {
        new FolderCms(Config.ROOT_DIRECTORY).deleteRecursive();
    }

    @Test
    public void createCategiryTest() {
        Title title = new Title("Category title!");
        Category category = articlesService.create(title);

        String actualPath = category.getAbsolutePath();

        String expectedPath = Config.ROOT_DIRECTORY
                + "articles_service" + File.separator
                + "categories" + File.separator
                + "category_title";
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void create_ArticleTest_check_title() {
        Title categoryTitle = new Title("category unnecessary");
        Title articleTitle = new Title("Article title!");
        Text text = new Text("unnecessary");
        Category category = articlesService.create(categoryTitle);

        Article article = articlesService.create(category, articleTitle, text);

        String expectedArticleTitlePath = Config.ROOT_DIRECTORY
                + "articles_service" + File.separator
                + "categories" + File.separator
                + "category_unnecessary" + File.separator
                + "article_title" + File.separator
                + "title.txt";

        File titleFile = new File(expectedArticleTitlePath);
        assertTrue(titleFile.exists());

        TxtFile articleTxtFile = new TxtFile(titleFile);
        assertEquals("Article title!", articleTxtFile.readString());
    }

    @Test
    public void create_ArticleTest_check_text() {
        Title categoryTitle = new Title("category unnecessary");
        Title articleTitle = new Title("title unnecessary");
        Text text = new Text("My test text!..");
        Category category = articlesService.create(categoryTitle);

        Article article = articlesService.create(category, articleTitle, text);

        String expectedArticleTextPath = Config.ROOT_DIRECTORY
                + "articles_service" + File.separator
                + "categories" + File.separator
                + "category_unnecessary" + File.separator
                + "title_unnecessary" + File.separator
                + "text.txt";

        File textFile = new File(expectedArticleTextPath);
        assertTrue(textFile.exists());

        TxtFile textTxtFile = new TxtFile(textFile);
        assertEquals("My test text!..", textTxtFile.readString());
    }
    
    @Test
    public void create_ArticleTest_check_creation_time() {
        Title categoryTitle = new Title("category unnecessary");
        Title articleTitle = new Title("title unnecessary");
        Text text = new Text("My test text!..");
        Category category = articlesService.create(categoryTitle);

        Article article = articlesService.create(category, articleTitle, text);

        String expectedArticleTextPath = Config.ROOT_DIRECTORY
                + "articles_service" + File.separator
                + "categories" + File.separator
                + "category_unnecessary" + File.separator
                + "title_unnecessary" + File.separator
                + "creation_time.txt";

        File textFile = new File(expectedArticleTextPath);
        assertTrue(textFile.exists());

        TxtFile textTxtFile = new TxtFile(textFile);
        String currentTimeString = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date(System.currentTimeMillis()));
        String savedTimeString = textTxtFile.readString();
        assertEquals(savedTimeString, currentTimeString);
    }
}
