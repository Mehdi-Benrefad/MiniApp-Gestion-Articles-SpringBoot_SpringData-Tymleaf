package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Article;


@Component
public class IArticleImpl implements IArticleDAO{
	
	@Autowired
	private EntityManager entity;

	@Override
	@Transactional
	public void AjouterArticle(Article Art) {
		entity.persist(Art);
		
	}

	@Override
	@Transactional
	public List<Article> ConsulterArticles() {
		Query arr =entity.createQuery("from Article");
		List<Article> ar=arr.getResultList();
		
		return ar;
	}

	@Override
	@Transactional
	public List<Article> ArticlesParMotCle(String mot) {
		List<Article> lst=ConsulterArticles();
		List<Article> lst2=new ArrayList<Article>();
		//for(int i=0;i<lst.size();i++) {
		for(Article variable :lst) {
		
			if(variable.getNomArticle().toLowerCase().contains(mot.toLowerCase())) {
				lst2.add(variable);
			}
		}
		
		
		return lst2;
		
		
	}

	@Override
	@Transactional
	public void SupprimerArticle(int Art) {

		Article art = entity.find(Article.class, Art);
		entity.remove(art);
		
	}
	

	@Override
	@Transactional
	public Article ConsulterArticle(int id) {
		
		Article art = entity.find(Article.class, id);
		return art;
	}

}
