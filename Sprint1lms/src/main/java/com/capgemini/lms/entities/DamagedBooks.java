package com.capgemini.lms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/*********************************************************************************************
 * 
 * @author SriHarika
 * Description: This class is used for entity mapping and for generating getters and setter for Damaged Books
 * Version: v1.1
 * Created date: 16 April 2021
 *
 *********************************************************************************************/
@Entity
@Table(name= "DamagedBooks1")
public class DamagedBooks 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bookid")
	private Books book;
	private int quantity;
	private String description;
	
	public DamagedBooks() {
		super();
	}

	public DamagedBooks(int id, Books book, int quantity, String description) {
		super();
		this.id = id;
		this.book = book;
		this.quantity = quantity;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DamagedBooks [id=" + id + ", book=" + book + ", quantity=" + quantity + ", description=" + description
				+ "]";
	}
	

}