package com.cg.ps.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cg.ps.entity.Image;
import com.cg.ps.entity.Profile;
import com.cg.ps.exception.ProfileException;
import com.cg.ps.model.ProfileModel;
import com.cg.ps.model.ResponseMessage;
import com.cg.ps.service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProfileController {

	@Autowired
	private ProfileService service;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> addProfile(@RequestParam("file") MultipartFile file,@RequestParam("profileInfo") String profileInfo ) {
		    String message = "Success";
		    ObjectMapper mapper=new ObjectMapper();
		    if(profileInfo !=null && file!=null) {
		    	try {
		    	Profile profile=mapper.readValue(profileInfo , Profile.class);
		    	System.out.println(profileInfo );
		    	
		    	 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
				 Image image=new Image(fileName,file.getContentType(),file.getBytes());

				 profile.setProfileImage(image);
		    	 service.createProfile(profile);

		      message = "Uploaded the file successfully: " + file.getOriginalFilename();
		      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		    	 }
		    	  catch (Exception e) {
				      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
				    }
		    }
		    else {
		    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage("Parameter should not be empty"));
		    }

		    
	}
	@GetMapping("/profiles")
	public ResponseEntity<List<ProfileModel>> getAllProfile() {
		   List<ProfileModel> files = service.getAllProfiles().map(dbFile -> {
			      String fileDownloadUri = ServletUriComponentsBuilder
			          .fromCurrentContextPath()
			          .path("/api/files/"+dbFile.getProfileId())
			          .toUriString();

			      return new ProfileModel(
			          dbFile.getProfileName(),
			          dbFile.getProfileImage().getImageName(),
			          fileDownloadUri,
			          dbFile.getProfileImage().getImageType(),
			          dbFile.getProfileImage().getData().length);
			    }).collect(Collectors.toList());

			    return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	
	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable("id") Integer id) throws ProfileException {
	    Profile fileDB = service.getProfile(id);
	    if(fileDB!=null) {
	    	System.out.println(fileDB.getProfileImage().getImageName());
	    	System.out.println(fileDB.getProfileId());
	    	System.out.println(fileDB.getProfileImage().getData());
	    	
	    }
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getProfileImage().getImageName()+ "\"")
	        .body(fileDB.getProfileImage().getData());
	  }
	
}
