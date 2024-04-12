package com.smk627751.view;

import com.smk627751.Utility;
import com.smk627751.dto.CommentSetting;
import com.smk627751.viewmodel.CreatePostViewModel;

public class CreatePostView extends Utility{
	private CreatePostViewModel viewModel;
	
	public CreatePostView()
	{
		this.viewModel = new CreatePostViewModel(this);
	}
	public void init() {
		print("Enter the heading: ");
		String heading = getScanner().nextLine();
		print("Enter the content: ");
		String content = getScanner().nextLine();
		print("1)Allow all comments\n2)Block all comments\n3)Allow once comment\n");
		print("option(0 to Mainmenu): ");
		CommentSetting comset = null;
		loop : do {
			int choice = getScanner().nextInt();
			getScanner().nextLine();
			switch(choice)
			{
				case 1 -> {
					comset = CommentSetting.ALLOW_ALL;
					break loop;
				}
				case 2 -> {
					comset = CommentSetting.BLOCK_ALL;
					break loop;
				}
				case 3 -> {
					comset = CommentSetting.ALLOW_ONCE;
					break loop;
				}
				case 0 -> {
					return;
				}
				default -> {
					print("Invalid choice\n");
				}
			}
		}while(true);
		System.out.println("Enter the group name(0 to post public): ");
		String group = getScanner().nextLine();
		viewModel.createPost(heading,content,comset,group);
	}
}
