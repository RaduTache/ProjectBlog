package dao;

import model.Article;
import model.Article;

import java.util.List;

/**
 * Created by root on 9/11/15.
 */
public interface IArticleDao {
    public List<Article> getAll();

    Article getArticle(long id);

    void saveArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(long id);
}
