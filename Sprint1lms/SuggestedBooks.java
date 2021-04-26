package com.capgemini.lms.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name= "SuggestedBooks1")

public class SuggestedBooks 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Users users;
	private String title;
	private String subject;
	private String author;
	private String publications;
	private String description;
	private Date suggested_date;
	private String status;
	
	public SuggestedBooks() {
		super();
	}
	
	public SuggestedBooks(int id, Users users, String title, String subject, String author, String publications,
			String description, Date suggested_date, String status) {
		super();
		this.id = id;
		this.users = users;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publications = publications;
		this.description = description;
		this.suggested_date = suggested_date;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublications() {
		return publications;
	}
	public void setPublications(String publications) {
		this.publications = publications;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getSuggested_date() {
		return suggested_date;
	}
	public void setSuggested_date(Date suggested_date) {
		this.suggested_date = suggested_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SuggestedBooks [id=" + id + ", users=" + users + ", title=" + title + ", subject=" + subject
				+ ", author=" + author + ", publications=" + publications + ", description=" + description
				+ ", suggested_date=" + suggested_date + ", status=" + status + "]";
	}
	

}
