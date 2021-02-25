package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Article {
	
	public  Article() {
		//
	}
	public Article(String nomArticle, String nomAuteur, Date datePub, String texte, String photo) {
		super();
		this.idArticle = idArticle;
		NomArticle = nomArticle;
		NomAuteur = nomAuteur;
		DatePub = datePub;
		Texte = texte;
		Photo = photo;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ARTICLE")
	int idArticle;
	String NomArticle;
	String NomAuteur;
	Date DatePub;
	String Texte;
	String Photo;
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getNomArticle() {
		return NomArticle;
	}
	public void setNomArticle(String nomArticle) {
		NomArticle = nomArticle;
	}
	public String getNomAuteur() {
		return NomAuteur;
	}
	public void setNomAuteur(String nomAuteur) {
		NomAuteur = nomAuteur;
	}
	public Date getDatePub() {
		return DatePub;
	}
	public void setDatePub(Date datePub) {
		DatePub = datePub;
	}
	public String getTexte() {
		return Texte;
	}
	public void setTexte(String texte) {
		Texte = texte;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", NomArticle=" + NomArticle + ", NomAuteur=" + NomAuteur
				+ ", DatePub=" + DatePub + ", Texte=" + Texte + ", Photo=" + Photo + "]";
	}
	
}
