package com.cg.ps.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.cg.ps.exception.ProfileException;
import com.cg.ps.model.ResponseMessage;


@RestControllerAdvice
public class ProfileExceptionHandler {
	
	 @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
	  }
	 @ExceptionHandler(ProfileException.class)
	  public ResponseEntity<String> manageProfileException(ProfileException exc) {
	    return new ResponseEntity<>(exc.getMessage(),HttpStatus.EXPECTATION_FAILED);
	  }


}
