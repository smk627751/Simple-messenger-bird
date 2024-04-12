package com.smk627751.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.smk627751.dao.Repository;
import com.smk627751.dto.Post;
import com.smk627751.view.ViewAllPostsView;

public class ViewAllPostsViewModel {
	private ViewAllPostsView view;
	private Repository repo;
	private List<Post> posts;
	public ViewAllPostsViewModel(ViewAllPostsView viewAllPostsView) {
		this.view = viewAllPostsView;
		this.repo = Repository.getInstance();
	}
	
	public List<Post> getPosts()
	{
		posts = repo.getPosts();
		return posts;
	}

	public Post getPost(int choice) {
		return repo.getPost(choice);
	}
	
	public boolean commented(Post post)
	{
		return post.getComments().containsKey(repo.getCurrentUser().getUsername());
	}
	
	public void comment(String comment,Post post) {
		List<String> comments = post.getComments().getOrDefault(repo.getCurrentUser().getUsername(), new ArrayList<>());
		comments.add(comment);
		post.getComments().put(repo.getCurrentUser().getUsername(), comments);
	}

	public void like(Post post) {
		if(!post.getLikes().contains(repo.getCurrentUser().getUsername()))
		{
			post.getLikes().add(repo.getCurrentUser().getUsername());
		}
		else
		{
			post.getLikes().remove(repo.getCurrentUser().getUsername());
		}
	}
}
