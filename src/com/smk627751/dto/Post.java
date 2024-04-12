package com.smk627751.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Post {
	private String heading;
	private String content;
	private String Author;
	private String group;
	private List<String> likes;
	private CommentSetting comSet;
	private Map<String,List<String>> comments;
	
	public Post(String heading, String content, String author, CommentSetting comSet, String group)
	{
		this.heading = heading;
		this.content = content;
		this.Author = author;
		this.comSet = comSet;
		this.group = group;
		this.likes = new ArrayList<>();
		this.comments = new HashMap<>();
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public List<String> getLikes() {
		return likes;
	}
	public void setLikes(List<String> likes) {
		this.likes = likes;
	}
	public CommentSetting getComSet() {
		return comSet;
	}
	public void setComSet(CommentSetting comSet) {
		this.comSet = comSet;
	}
	public Map<String,List<String>> getComments() {
		return comments;
	}
	public void setComments(Map<String,List<String>> comments) {
		this.comments = comments;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder(heading+"\n\t"+content+"\nAuthor: "+Author+"\nlikes: "+likes.size()+"\n");
		if(comments.size() > 0)
		{
			str.append("comments: \n");
			for(Map.Entry<String, List<String>> e : comments.entrySet())
			{
				for(String comment : e.getValue())
				{
					str.append(e.getKey()+":"+comment+"\n");
				}
			}
		}
		if(comSet == CommentSetting.BLOCK_ALL)
		{
			str.append("------Author BLOCKED all new comments------\n");
		}
		return str.toString();
	}
}
