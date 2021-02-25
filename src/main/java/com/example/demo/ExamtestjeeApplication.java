package com.example.demo;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.dao.IArticleImpl;
import com.example.demo.entities.Article;
import com.example.demo.metier.IArticleMetierImpl;
 
@SpringBootApplication
public class ExamtestjeeApplication {
	 
	@Autowired
	IArticleImpl article;
	
	@Autowired
	IArticleMetierImpl article2;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamtestjeeApplication.class, args);
	}

	@PostConstruct
	public void LoadOneFinished() {
		System.out.println("***************hello Mehdi********************");
		
		//article.AjouterArticle(new Article("Quantum Programming", "MEHDI BENREFAD", new Date(), "hello", "not found"));
		//article.SupprimerarticleArticle(2);
		//System.out.println(article.ArticlesParMotCle("Q").toString());
		//article2.AjouterArticle(new Article("Quantum Programming", "MEHDI BENREFAD", new Date(), "hello", "not found"));
	}
}
