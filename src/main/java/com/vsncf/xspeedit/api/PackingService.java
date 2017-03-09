package com.vsncf.xspeedit.api;

import java.util.List;

import com.vsncf.xspeedit.model.Article;
import com.vsncf.xspeedit.model.Box;

public interface PackingService {

	/**
	 * @param articles
	 * @return
	 */
	List<Box> pack(Article[] articles);

}
