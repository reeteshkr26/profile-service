package com.cg.ps.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ps.entity.Profile;
import com.cg.ps.exception.ProfileException;
import com.cg.ps.repo.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{


	@Autowired
	private ProfileRepository repo;

	@Override
	public Profile createProfile(Profile profile) throws ProfileException {
	
		
		return repo.save(profile);
	}

	@Override
	public Profile getProfile(Integer id) throws ProfileException {
		Profile profile=null;
		profile=repo.findById(id).orElse(null);
		if(profile==null) {
		  throw new ProfileException("Profile does not exist!");	
		}
		
		return profile;
	}

	@Override
	public Stream<Profile> getAllProfiles() {
		return repo.findAll().stream();
	}
}
