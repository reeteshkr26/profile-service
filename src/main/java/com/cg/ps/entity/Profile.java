package com.cg.ps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profile_table")
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer profileId;
	
	@Column(name="profile_name")
	private String profileName;
	
	@Column(name="profie_email")
	private String profileEmail;

	private Image profileImage;
	
	public Profile() {
		
	}
	

	public Profile(Integer profileId, String profileName, String profileEmail, Image profileImage) {
		this.profileId = profileId;
		this.profileName = profileName;
		this.profileEmail = profileEmail;
		this.profileImage = profileImage;
	}


	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileEmail() {
		return profileEmail;
	}

	public void setProfileEmail(String profileEmail) {
		this.profileEmail = profileEmail;
	}

	public Image getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(Image profileImage) {
		this.profileImage = profileImage;
	}
	
	
	
}
