package com.cg.ps.service;

import java.util.stream.Stream;

import com.cg.ps.entity.Profile;
import com.cg.ps.exception.ProfileException;

public interface ProfileService {

	public Profile createProfile(Profile profile) throws ProfileException; 
	public Profile getProfile(Integer id) throws ProfileException; 
	public Stream<Profile> getAllProfiles();
}
