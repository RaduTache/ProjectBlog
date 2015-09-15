package dao;

import model.Article;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by root on 9/11/15.
 */
public class ArticleDao implements IArticleDao{

    private EntityManager entityManager;

    @PersistenceContext
    private void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Article> getAll(){
        return this.entityManager.createQuery("from Article").getResultList();
    }

    public Article getArticle(long id)
    {
        return entityManager.find(Article.class, id);
    }

    @Transactional
    public void saveArticle(Article article)
    {
        this.entityManager.persist(article);
    }
    @Transactional
    public void updateArticle(Article article)
    {
        Article articleFromDb = this.getArticle(article.getId());
        if (articleFromDb != null) {
            articleFromDb.setContent(article.getContent());
            articleFromDb.setDescription(article.getDescription());
            articleFromDb.setTitle(article.getTitle());
            this.entityManager.persist(articleFromDb);
        }

    }
    @Transactional
    public void deleteArticle(long id)
    {
        Article articleFromDb = this.getArticle(id);
        if (articleFromDb != null ) {
            this.entityManager.remove(articleFromDb);
        }

    }
}
