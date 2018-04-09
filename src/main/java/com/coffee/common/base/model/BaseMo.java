package com.coffee.common.base.model;

import java.io.Serializable;

public class BaseMo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 943039841866602259L;

	private long id;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}
}
