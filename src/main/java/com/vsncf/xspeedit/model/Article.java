package com.vsncf.xspeedit.model;

import java.util.Objects;

public class Article {

	private final int size;
	private final int hash;

	public Article(int size) {
		this.size = size;
		this.hash = Objects.hash(size);
	}

	public int getSize() {
		return size;
	}

	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Article other = (Article) obj;
		return Objects.equals(this.size, other.size);
	}

	@Override
	public String toString() {
		return String.join("", Class.class.getSimpleName(), "[", "size=" + size, "]");
	}
}
