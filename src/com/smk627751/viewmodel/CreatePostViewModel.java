package com.smk627751.viewmodel;

import com.smk627751.dao.Repository;
import com.smk627751.dto.CommentSetting;
import com.smk627751.dto.Post;
import com.smk627751.view.CreatePostView;

public class CreatePostViewModel {
	private CreatePostView view;
	private Repository repo;
	
	public CreatePostViewModel(CreatePostView createPostView) {
		this.view = createPostView;
		this.repo = Repository.getInstance();
	}

	public void createPost(String heading, String content, CommentSetting comset, String group) {
		repo.getAllPosts().add(new Post(heading, content, repo.getCurrentUser().getUsername(), comset, group));
		view.print("post created successfully...\n");
	}

}
