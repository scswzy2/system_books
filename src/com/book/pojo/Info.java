package com.book.pojo;

public class Info {
	private Integer id;
	private String bookName;
	private String author;
	private Category categoryId;
	private String publisher;
	private Double price;
	private String bphoto;
	public Info() {}
	public Info(Integer id, String bookName, String author, Category categoryId, String publisher, Double price,
			String bphoto) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.categoryId = categoryId;
		this.publisher = publisher;
		this.price = price;
		this.bphoto = bphoto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Category getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBphoto() {
		return bphoto;
	}
	public void setBphoto(String bphoto) {
		this.bphoto = bphoto;
	}
}
