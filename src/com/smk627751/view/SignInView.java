package com.smk627751.view;

import com.smk627751.Utility;
import com.smk627751.viewmodel.SignInViewModel;

public class SignInView extends Utility{
	private SignInViewModel viewModel;
	
	public SignInView()
	{
		this.viewModel = new SignInViewModel(this);
	}

	public void init() {
		print("Enter the Username: ");
		String username = getScanner().nextLine();
		print("Enter the password: ");
		String password = getScanner().nextLine();
		if(viewModel.checkUser(username, password))
		{
			Home home = new Home();
			home.init();
		}
	}
}
