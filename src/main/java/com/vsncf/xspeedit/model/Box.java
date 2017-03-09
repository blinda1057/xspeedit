package com.vsncf.xspeedit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Box {

	public final static int CAPACITE_MAX = 10;

	private final List<Article> articles;

	public Box() {
		super();
		this.articles = new ArrayList<>();
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void add(Article article) {
		articles.add(article);
	}

	public int getFreeSpace() {
		int sizeUsed = articles.stream().mapToInt(Article::getSize).sum();
		return CAPACITE_MAX - sizeUsed;
	}

	@Override
	public String toString() {
		return String
				.join("", Class.class.getSimpleName(), "[",
						"articles=", String.join(",", this.articles.stream()
								.map(article -> Integer.toString(article.getSize())).collect(Collectors.toList())),
						"]");
	}
}
