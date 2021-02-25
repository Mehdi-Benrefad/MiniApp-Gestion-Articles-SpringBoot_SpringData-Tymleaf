package com.example.demo.metier;

import java.util.List;

import com.example.demo.entities.Article;

public interface IArticleMetier {

	public void AjouterArticle(Article Art);
	public List<Article> ConsulterArticles();
	//public List<Article> ArticlesParMotCle();
	public void SupprimerArticle(int Art);
	public Article ConsulterArticle(int id);
	List<Article> ArticlesParMotCle(String mot);
	
}
