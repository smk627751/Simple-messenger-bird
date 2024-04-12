package com.smk627751.view;

import com.smk627751.Utility;
import com.smk627751.viewmodel.SignUpViewModel;

public class SignUpView extends Utility {
	private SignUpViewModel viewModel;
	
	public SignUpView()
	{
		this.viewModel = new SignUpViewModel(this);
	}
	
	public void init()
	{
		print("Enter the username: ");
		String username = getScanner().nextLine();
		print("Enter the password: ");
		String password = getScanner().nextLine();
		viewModel.addUser(username, password);
	}
}
