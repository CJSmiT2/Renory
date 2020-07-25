package com.renorycore.common.interfaces;

import com.renorycore.articles.Article;
import com.renorycore.articles.Category;
import com.renorycore.common.model.text.Text;
import com.renorycore.common.model.text.Title;

/**
 *
 * @author smit
 */
public interface ArticlesService {

    Category create(Title title);

    Article create(Category category, Title title, Text text);

}
