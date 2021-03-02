package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 

import com.example.demo.dao.IArticleImpl;
import com.example.demo.entities.Article;
import com.example.demo.metier.IArticleMetierImpl;

@Controller
public class ControllerApp {

	@Autowired
	IArticleMetierImpl article;
	
	@Autowired
	IArticleImpl art;
	
	@RequestMapping(value = "/home")
    public String Home(Model mode) {
		
		List<Article> lsmc=(List<Article>)mode.getAttribute("articlesmotCle");
		if(lsmc!=null) {
			
			mode.addAttribute("articles",lsmc);

		}else {
			List<Article> lst= article.ConsulterArticles();
			mode.addAttribute("articles",lst);
			mode.addAttribute("isactive",true);
		}
		
	return "liste"; 
	}
	
	
	@RequestMapping(value = "/ajouter", method = RequestMethod.GET)
	public String ajouter() {
		return "ajouter";
	}
	
	
	@RequestMapping(value = "/ajouterArticle", method = RequestMethod.POST)
	public String requestMethodName( Article arti ) {
		
		arti.setDatePub(new Date());
	
		article.AjouterArticle(arti);
		
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/supprimer", method = RequestMethod.POST)
	public String supprimer(int identifiant) {
		
		article.SupprimerArticle(identifiant);
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/parmotcle", method = RequestMethod.POST)
    public String MotCle(Model mode,String mot) {
		
		if(mot.equals("")) {
			return "redirect:/home";

		}
		
		List<Article> lst= art.ArticlesParMotCle(mot);
		mode.addAttribute("articles",lst);
		mode.addAttribute("isactive",true);
	return "liste"; 
	
	}
	
	@RequestMapping(value = "/parid", method = RequestMethod.POST)
    public String ID(Model mode,String id) {
		
		if(id.equals("")) {
			return "redirect:/home";

		}
		List<Article>lst=new ArrayList();
		Article arti= (Article) article.ConsulterArticle(Integer.valueOf(id));
		
		if(arti != null) {
		lst.add(arti);
		mode.addAttribute("isactive",true);
		}
		
			mode.addAttribute("articles",lst);
			
		
		
		
	return "liste"; 
	
	}
	
	
	
	
}
