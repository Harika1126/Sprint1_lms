package com.capgemini.lms.dto;

public class DamagedBooksDto 
{
	private int quantity;
	private String description;
	private int bookId;
	public DamagedBooksDto(int quantity, String description, int bookId) {
		super();
		this.quantity = quantity;
		this.description = description;
		this.bookId = bookId;
	}
	public DamagedBooksDto() {
		super();
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
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "DamagedBooksDto [quantity=" + quantity + ", description=" + description + ", bookId=" + bookId + "]";
	}
	

}
