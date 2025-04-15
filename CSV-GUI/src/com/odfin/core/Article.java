package com.odfin.core;

public class Article {

	private String articleNumber;
	private String articleName;
	private String description;
	private double price;

	public Article() {

	}

	public Article(String articleNumber, String articleName, String description, double price) {
		this.articleNumber = articleNumber;
		this.articleName = articleName;
		this.description = description;
		this.price = price;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
