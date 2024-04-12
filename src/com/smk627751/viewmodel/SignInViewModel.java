package com.smk627751.viewmodel;

import com.smk627751.dao.Repository;
import com.smk627751.dto.User;
import com.smk627751.view.SignInView;

public class SignInViewModel {
	private SignInView view;
	private Repository repo;
	
	public SignInViewModel(SignInView signInView) {
		this.view = signInView;
		this.repo = Repository.getInstance();
	}

	public boolean checkUser(String username, String password) {
		if(repo.getUsers().containsKey(username))
		{
			User user = repo.getUsers().get(username);
			if(user.getPassword().equals(password))
			{
				repo.setCurrentUser(user);
				return true;
			}
			else
			{
				view.print("Incorrect password\n");
			}
		}
		else view.print("Invalid user\n");
		return false;
	}	
}
