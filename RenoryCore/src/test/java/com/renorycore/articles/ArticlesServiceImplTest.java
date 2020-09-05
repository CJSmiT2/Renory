package com.renorycore.articles;

import com.renorycore.main.config.Config;
import com.renorycore.common.interfaces.ArticlesService;
import com.renorycore.common.model.filesystem.FolderCms;
import com.renorycore.common.model.filesystem.TxtFile;
import com.renorycore.common.model.text.Alias;
import com.renorycore.common.model.text.Text;
import com.renorycore.common.model.text.Title;
import java.io.File;
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
        Category category = articlesService.createCategory(title);

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
        Category category = articlesService.createCategory(categoryTitle);

        Article article = articlesService.createArticle(category, articleTitle, text);

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
        Category category = articlesService.createCategory(categoryTitle);

        Article article = articlesService.createArticle(category, articleTitle, text);

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
        Category category = articlesService.createCategory(categoryTitle);

        Article article = articlesService.createArticle(category, articleTitle, text);

        String expectedArticleTextPath = Config.ROOT_DIRECTORY
                + "articles_service" + File.separator
                + "categories" + File.separator
                + "category_unnecessary" + File.separator
                + "title_unnecessary" + File.separator
                + "creation_time.txt";

        File textFile = new File(expectedArticleTextPath);
        assertTrue(textFile.exists());

        TxtFile creationTimeFile = new TxtFile(textFile);
        String actualCreationTime = article.getCreationTime().getYyyyMMddHHmmss();
        assertEquals(actualCreationTime, creationTimeFile.readString());
    }

    @Test
    public void findCategory() {
        Title categoryTitle = new Title("Test category");
        Alias categoryAlias = categoryTitle.createAlias();
        Category categoryExpected = articlesService.createCategory(categoryTitle);

        Category categoryActual = articlesService.findCategory(categoryAlias);

        assertEquals(categoryExpected.getAbsolutePath(), categoryActual.getAbsolutePath());
    }

    @Test
    public void findArticle() {
        Title categoryTitle = new Title("category unnecessary");
        Title articleTitle = new Title("title unnecessary");
        Text text = new Text("text unnecessary");
        Category category = articlesService.createCategory(categoryTitle);
        Article articleExpected = articlesService.createArticle(category, articleTitle, text);

        Article articleActual = articlesService.findArticle(category.getAlias(), articleTitle.createAlias());

        assertEquals(articleExpected.getAbsolutePath(), articleActual.getAbsolutePath());
    }
}
