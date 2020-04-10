package com.book.pojo;

import java.util.List;

public class Category {
	private Integer id;
	private String category;
	private List<Info> infos;
	public Category(Integer id, String category) {
		super();
		this.id = id;
		this.category = category;
	}
	public List<Info> getInfos() {
		return infos;
	}
	public void setInfos(List<Info> infos) {
		this.infos = infos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
