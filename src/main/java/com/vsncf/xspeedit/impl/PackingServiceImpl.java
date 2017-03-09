package com.vsncf.xspeedit.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.vsncf.xspeedit.api.PackingService;
import com.vsncf.xspeedit.model.Article;
import com.vsncf.xspeedit.model.Box;

public class PackingServiceImpl implements PackingService {

	@Override
	public List<Box> pack(Article[] articles) {
		List<Box> result = new LinkedList<>();
		if (articles.length > 0) {
			result.add(new Box());
			Stream<Article> articlesStream = Arrays.stream(articles)
					.sorted((a1, a2) -> Objects.compare(a1, a2, (a, b) -> Integer.compare(b.getSize(), a.getSize())));
			articlesStream.forEachOrdered(article -> {
				boolean isArticlePacked = false;
				for (Box box : result) {
					if (box.getFreeSpace() >= article.getSize()) {
						box.add(article);
						isArticlePacked = true;
						break;
					}
				}
				if (!isArticlePacked) {
					Box box = new Box();
					result.add(box);
					box.add(article);
				}
			});
		}
		return result;
	}
}
