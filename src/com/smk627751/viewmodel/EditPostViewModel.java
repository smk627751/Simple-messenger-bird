package com.smk627751.viewmodel;

import java.util.List;

import com.smk627751.dao.Repository;
import com.smk627751.dto.Post;
import com.smk627751.view.EditPostView;

public class EditPostViewModel {
	private EditPostView view;
	private Repository repo;
	
	public EditPostViewModel(EditPostView editPostView) {
		this.view = editPostView;
		this.repo = Repository.getInstance();
	}

	public List<Post> getPosts() {
		return repo.getPosts();
	}
}
