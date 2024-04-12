package com.smk627751.view;

import java.util.ArrayList;
import java.util.List;

import com.smk627751.Utility;
import com.smk627751.viewmodel.GroupViewModel;

public class GroupView extends Utility{
	private GroupViewModel viewModel;
	public GroupView()
	{
		this.viewModel = new GroupViewModel(this);
	}
	public void init() {
		print("Enter the group name: ");
		String name = getScanner().nextLine();
		print("Enter the members in the group(stop to end): ");
		List<String> members = new ArrayList<>();
		String member;
		while(!(member = getScanner().nextLine()).equals("stop"))
		{
			members.add(member);
		}
		viewModel.createGroup(name,members);
	}

}
