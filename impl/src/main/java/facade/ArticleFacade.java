package facade;

import dao.IArticleDao;
import model.Article;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by root on 9/11/15.
 */
public class ArticleFacade implements IArticleFacade{

    @Autowired
    private IArticleDao articleDao;

    public List<Article> getArticles(){
        return this.articleDao.getAll();
    }

    public IArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(IArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public Article getArticle(long id)
    {
        return this.articleDao.getArticle(id);
    }

    public void saveArticle(Article article)
    {
        this.articleDao.saveArticle(article);
    }

    public void updateArticle(Article article)
    {
        this.articleDao.updateArticle(article);
    }

    public void deleteArticle(long id)
    {
        this.articleDao.deleteArticle(id);
    }
}
