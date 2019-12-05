package com.entity;

public class Article {
	private int id;
	private String title;
	private String content;
	private String tag;
	private String writerName;

	public Article(){}
	
	public Article(int id, String title, String content, String tag, String writerName) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.tag = tag;
		this.writerName = writerName;
	}
	
	
	public String getWriteName() {
		return writerName;
	}

	public void setWritename(String writerName) {
		this.writerName = writerName;
	}

	public int getId() {
		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content=" + content + ", tag=" + tag + ", writeName="
				+ writerName + "]";
	}
	
	

}
