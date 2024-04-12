package com.smk627751.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smk627751.dto.Post;
import com.smk627751.dto.User;

public class Repository {
	private static Repository repo;
	private User currentUser;
	private Map<String,User> users;
	private List<Post> posts;
	private List<Post> customPosts;
	private Map<String,List<String>> groups;
	
	private Repository(){
		this.users = new HashMap<>();
		this.posts = new ArrayList<>();
		this.groups =new HashMap<>();
	}
	
	public static Repository getInstance()
	{
		if(repo == null)
		{
			repo = new Repository();
		}
		return repo;
	}
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public Map<String,User> getUsers() {
		return users;
	}

	public void setUsers(Map<String,User> users) {
		this.users = users;
	}
	public List<Post> getAllPosts()
	{
		return posts;
	}
	public List<Post> getPosts() {
		customPosts = posts.stream().filter((post) -> (
				post.getGroup().equals("0") || 
				repo.getCurrentUser().getGroups().contains(post.getGroup()) ||
				post.getAuthor().equals(repo.getCurrentUser().getUsername())
		)).toList();
		
		return customPosts;
	}
	
	public Post getPost(int index)
	{
		if(index > 0 && index <= customPosts.size())
		{
			return customPosts.get(index - 1);
		}
		return null;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Map<String,List<String>> getGroups() {
		return groups;
	}

	public void setGroups(Map<String,List<String>> groups) {
		this.groups = groups;
	}
}
