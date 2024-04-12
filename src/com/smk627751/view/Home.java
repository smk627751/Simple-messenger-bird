package com.smk627751.view;

import com.smk627751.Utility;
import com.smk627751.dao.Repository;

public class Home extends Utility{
	private Repository repo;
	public Home()
	{
		this.repo = Repository.getInstance();
	}
	public void init()
	{
		do {
			print(String.format("Welcome %s\n", repo.getCurrentUser()));
			print("1)Create post\n2)View all post\n"
					+ "3)Edit post setting\n4)Create group\n5)Logout\n");
			print("Select any option: ");
			int choice = getScanner().nextInt();
			switch(choice)
			{
				case 1 ->{
					CreatePostView view = new CreatePostView();
					view.init();
				}
				case 2 ->{
					ViewAllPostsView view = new ViewAllPostsView();
					view.init();
				}
				case 3 ->{
					EditPostView view = new EditPostView();
					view.init();
				}
				case 4 ->{
					GroupView view = new GroupView();
					view.init();
				}
				case 5 ->{
					repo.setCurrentUser(null);
					return;
				}
			}
		}while(true);
	}
}
