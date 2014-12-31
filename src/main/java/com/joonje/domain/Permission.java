package com.joonje.domain;

public class Permission extends IdEntity {
	/**
	 * 显示顺序
	 */
	private int priority;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 描述
	 */
	private String description;

}
