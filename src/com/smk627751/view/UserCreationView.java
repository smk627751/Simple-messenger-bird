package com.smk627751.view;

import com.smk627751.Utility;

public class UserCreationView extends Utility{
	public void init()
	{
		do {
			print("1)Sign Up\n2)Sign In\n");
			int choice = getScanner().nextInt();
			switch(choice)
			{
				case 1 -> {
					SignUpView view = new SignUpView();
					view.init();
				}
				case 2 -> {
					SignInView view = new SignInView();
					view.init();
				}
				default -> {
					print("Invalid choice");
				}
			}
		}while(true);
	}
}
