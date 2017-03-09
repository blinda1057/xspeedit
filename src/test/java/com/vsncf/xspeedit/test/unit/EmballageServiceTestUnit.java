package com.vsncf.xspeedit.test.unit;

import static com.vsncf.xspeedit.utils.PackingUtils.convertStringToArticles;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.vsncf.xspeedit.api.PackingService;
import com.vsncf.xspeedit.impl.PackingServiceImpl;
import com.vsncf.xspeedit.model.Article;
import com.vsncf.xspeedit.model.Box;

public class EmballageServiceTestUnit {

	/**
	 * Articles : 163841689525773 Robot optimisé: 163/82/46/19/8/55/73/7 => 8
	 * packs used
	 */
	@Test
	public void testRoboOptimise() {
		String in = "163841689525773";
		PackingService packingService = new PackingServiceImpl();
		final Article[] articles = convertStringToArticles(in);
		List<Box> packs = packingService.pack(articles);
		System.out.println(packs);
		Assert.assertEquals(packs.size(), 8);
	}
}
