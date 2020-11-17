package com.cg.ps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ps.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	public Profile findByProfileEmail(String profileEmail);
}
