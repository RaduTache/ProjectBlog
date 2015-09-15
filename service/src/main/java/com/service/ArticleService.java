package com.service;

import facade.IArticleFacade;
import model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 9/10/15.
 */
@Controller
@RequestMapping("/article")
public class ArticleService {

    @Autowired
    private IArticleFacade articleFacade;

    @RequestMapping(value="", method= RequestMethod.GET)
    @ResponseBody
    public List<Article> getAllArticles() {
        return this.articleFacade.getArticles();
    }
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    @ResponseBody
    public Article getArticle(@PathVariable("id") Long id) {
        return this.articleFacade.getArticle(id);
    }

    @RequestMapping(value="", method= RequestMethod.POST)
    @ResponseBody
    public void saveArticle(@RequestBody Article article) {
        this.articleFacade.saveArticle(article);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    @ResponseBody
    public void updateArticle(@PathVariable("id") Long id, @RequestBody Article article) {
        article.setId(id);
        this.articleFacade.updateArticle(article);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    @ResponseBody
    public void deleteArticle(@PathVariable("id") Long id){
        this.articleFacade.deleteArticle(id);
    }

    public IArticleFacade getArticleFacade() {
        return articleFacade;
    }

    public void setArticleFacade(IArticleFacade articleFacade) {
        this.articleFacade = articleFacade;
    }
}
