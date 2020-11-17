package com.cg.ps.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class Image {

	 @Column(name="image_name")
	  private String imageName;
      
	 @Column(name="image_type")
	  private String imageType;

	  @Lob
	  @Column(name="image_data")
	  private byte[] data;

	  public Image() {
		  
	  }
	public Image(String imageName, String imageType, byte[] data) {

		this.imageName = imageName;
		this.imageType = imageType;
		this.data = data;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	  
	
	  
}
