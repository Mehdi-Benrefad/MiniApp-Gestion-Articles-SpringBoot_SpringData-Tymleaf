package com.example.demo.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IArticleDAO;
import com.example.demo.entities.Article;

@Service
public class IArticleMetierImpl implements IArticleMetier{

	@Autowired
	IArticleDAO art;
	
	@Override
	public void AjouterArticle(Article Art) {
		art.AjouterArticle(Art);
		
	}

	@Override
	public List<Article> ConsulterArticles() {
		List<Article>lst=art.ConsulterArticles();
		return lst;
	}

	@Override
	public void SupprimerArticle(int Art) {
		// TODO Auto-generated method stub
		art.SupprimerArticle(Art);
	}

	@Override
	public Article ConsulterArticle(int id) {
		Article article=art.ConsulterArticle(id);
		return article;
	}

	@Override
	public List<Article> ArticlesParMotCle(String mot) {
		List<Article> lst=art.ArticlesParMotCle(mot);
		return null;
	}

}
