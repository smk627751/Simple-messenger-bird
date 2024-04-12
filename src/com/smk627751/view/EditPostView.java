package com.smk627751.view;

import com.smk627751.Utility;
import com.smk627751.dao.Repository;
import com.smk627751.dto.CommentSetting;
import com.smk627751.dto.Post;
import com.smk627751.viewmodel.EditPostViewModel;

public class EditPostView extends Utility{
	private EditPostViewModel viewModel;
	private Repository repo;
	public EditPostView()
	{
		this.viewModel = new EditPostViewModel(this);
		this.repo = Repository.getInstance();
	}
	
	public void init()
	{
		loop : do {
			print("All posts:\n");
			int index = 1;
			for(Post post : viewModel.getPosts())
			{
				print(String.format("%d)%s\n", index++, post.getHeading()));
			}
			print("Option(0 to back): ");
			int choice = getScanner().nextInt();
			Post post = repo.getPost(choice);
			if(post != null)
			{
				print(post.toString());
				print("1)Allow all comments\n2)Block all comments\n3)Allow once comment\n");
				print("option(0 to Mainmenu): ");
				int sub_choice = getScanner().nextInt();
				switch(sub_choice)
				{
					case 1 -> {
						post.setComSet(CommentSetting.ALLOW_ALL);
						break loop;
					}
					case 2 -> {
						post.setComSet(CommentSetting.BLOCK_ALL);
						break loop;
					}
					case 3 -> {
						post.setComSet(CommentSetting.ALLOW_ONCE);
						break loop;
					}
					case 0 -> {
						return;
					}
					default -> {
						print("Invalid choice\n");
					}
				}
			}
			else print("Invalid choice\n");
		}while(true);
	}
}
