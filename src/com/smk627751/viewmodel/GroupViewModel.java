package com.smk627751.viewmodel;

import java.util.List;

import com.smk627751.dao.Repository;
import com.smk627751.view.GroupView;

public class GroupViewModel {
	private GroupView view;
	private Repository repo;
	
	public GroupViewModel(GroupView groupView) {
		this.view = groupView;
		this.repo = Repository.getInstance();
	}
	public void createGroup(String name, List<String> members) {
		if(!repo.getGroups().containsKey(name))
		{
			members.add(repo.getCurrentUser().getUsername());
			for(String member : members)
			{
				if(repo.getUsers().containsKey(member))
				{
					repo.getUsers().get(member).getGroups().add(name);
				}
			}
			repo.getGroups().put(name, members);
			view.print("Group created successfully...\n");
		}
		else view.print("Group with this name already exists\n");
	}

}
