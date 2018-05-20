package com.aproject.portal.pojo;

import com.aproject.pojo.TbItem;

public class PortalItem extends TbItem{

	public String[] getImages() {
		String images =this.getImage();
		if(images != null && images.equals("")) {
			 String[] imgs = images.split(",");
			 return imgs;
		}
		return null;
	}
}
