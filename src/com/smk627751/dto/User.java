package com.smk627751.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String password;
	private List<String> groups;
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
		this.groups = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}
	public String toString()
	{
		return username;
	}
}
