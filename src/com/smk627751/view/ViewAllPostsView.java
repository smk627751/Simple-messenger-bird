package com.smk627751.view;

import com.smk627751.Utility;
import com.smk627751.dto.Post;
import com.smk627751.viewmodel.ViewAllPostsViewModel;

public class ViewAllPostsView extends Utility{
	private ViewAllPostsViewModel viewModel;
	
	public ViewAllPostsView()
	{
		this.viewModel = new ViewAllPostsViewModel(this);
	}
	public void init()
	{
		do {
			print("All posts:\n");
			int index = 1;
			for(Post post : viewModel.getPosts())
			{
				print(String.format("%d)%s\n", index++, post.getHeading()));
			}
			print("Option(0 to back): ");
			int choice = getScanner().nextInt();
			if(choice == 0) break;
			Post post = viewModel.getPost(choice);
			boolean isCommentEnabled = true;
			if(post != null)
			{
				print(post.toString());
				switch(post.getComSet())
				{
					case ALLOW_ALL ->{
						print("1)comment 2)like 3)back 4)back to mainmenu\n");
					}
					case BLOCK_ALL ->{
						print("1)like 2)back 3)back to mainmenu\n");
						isCommentEnabled = false;
					}
					case ALLOW_ONCE ->{
						if(viewModel.commented(post))
						{
							print("1)like 2)back 3)back to mainmenu\n");
							isCommentEnabled = false;
						}
						else
						{
							print("1)comment 2)like 3)back 4)back to mainmenu\n");
						}
					}
				}
				print("option: ");
				int sub_choice = getScanner().nextInt();
				getScanner().nextLine();
				if(isCommentEnabled)
				{
					switch(sub_choice)
					{
						case 1 -> {
							print("Enter your comment: ");
							String comment = getScanner().nextLine();
							viewModel.comment(comment, post);
						}
						case 2 -> {
							viewModel.like(post);
						}
						case 3 -> {
							continue;
						}
						case 4 -> {
							return;
						}
						default -> {
							print("Invalid choice\n");
						}
					}
				}
				else
				{
					switch(sub_choice)
					{
						case 1 -> {
							viewModel.like(post);
						}
						case 2 -> {
							continue;
						}
						case 3 -> {
							return;
						}
						default -> {
							print("Invalid choice\n");
						}
					}
				}
			}
			else {
				print("Invalid choice\n");
			}
		}while(true);
	}
}
