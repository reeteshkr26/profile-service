package com.cg.ps.model;

public class ProfileModel {
	private String profileName;
	private String name;
	private String url;
	private String type;
	private long size;

	public ProfileModel() {
	}

	public ProfileModel(String profileName, String name, String url, String type, long size) {
		this.profileName = profileName;
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
}
