package com.smk627751.viewmodel;

import com.smk627751.dao.Repository;
import com.smk627751.dto.User;
import com.smk627751.view.SignUpView;

public class SignUpViewModel {
	private SignUpView view;
	private Repository repo;
	public SignUpViewModel(SignUpView signUpView) {
		this.view = signUpView;
		this.repo = Repository.getInstance();
	}

	public void addUser(String username, String password) {
		if(!repo.getUsers().containsKey(username))
		{
			repo.getUsers().put(username, new User(username, password));
			view.print("User created successfully..\n");
		}
		else view.print("User Already exists..\n");
	}
}
