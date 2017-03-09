package com.vsncf.xspeedit.utils;

import java.util.Objects;
import java.util.stream.Stream;

import com.vsncf.xspeedit.model.Article;

public class PackingUtils {

	public static Article[] convertStringToArticles(String value) {
		value = Objects.requireNonNull(value, "value is null");
		Stream<Article> articlesStream = value.chars().filter(c -> Boolean.logicalAnd('0' < (char) c, (char) c <= '9'))
				.map(c -> Integer.valueOf("" + (char) c)).mapToObj(Article::new);
		return articlesStream.toArray(size -> new Article[size]);
	}
}
