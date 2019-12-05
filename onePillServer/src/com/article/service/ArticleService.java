package com.article.service;

import java.util.List;

import com.article.dao.ArticleDao;
import com.entity.Article;

public class ArticleService {
	public List<Article> ArticleFindAllService(){
		return new ArticleDao().findAllArticle();
	}
}
