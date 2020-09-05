package com.renorycore.common.interfaces;

import com.renorycore.articles.Article;
import com.renorycore.articles.Category;
import com.renorycore.common.model.text.Alias;
import com.renorycore.common.model.text.Text;
import com.renorycore.common.model.text.Title;

/**
 *
 * @author smit
 */
public interface ArticlesService {

    Category createCategory(Title title);

    Category findCategory(Alias alias);

    Article createArticle(Category category, Title title, Text text);

    Article findArticle(Alias categoryAlias, Alias articleAlias);

}
