package com.niwodai.image.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niwodai.image.dao.ImageRecordDao;
import com.niwodai.image.domain.Image;
import com.niwodai.image.domain.ImageRecord;

@Controller
public class ImageController {
	
	private static final Log logger = LogFactory.getLog(ImageController.class);
	private final AtomicLong counter = new AtomicLong();
	private final String localtime = new Date().toString();

	@Autowired
	private ImageRecordDao imgrcDao;
	
	//Get Image pull request
	@RequestMapping(value = "/v2/{owner}/{project}/manifest/{tag}", method = RequestMethod.GET)
	@ResponseBody
	public ImageRecord detectRequest(@PathVariable String owner, @PathVariable String project,
			@PathVariable String tag) {
		
		logger.info("detectRequest called!");
		
		ImageRecord imgrc = new ImageRecord();
		
		imgrc.setID(counter.incrementAndGet());
		
		imgrc.setOwner(owner);
		
		imgrc.setProject(project);
		
		imgrc.setTag(tag);
		
		imgrc.setAction_time(localtime);
		
		System.out.print(imgrc.toString());
		
		imgrcDao.save(imgrc);
		
		return imgrc;
		
	}
	
	//Query image record by id
	@RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ImageRecord getRecordByID(@PathVariable Long id) {
		
		ImageRecord imgrc = imgrcDao.findOne(id);
		if(imgrc != null) {
			return imgrc;
		}
		else {
			return null;
		}
	}
	
	//Delete image record by id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteImageRecordByID(@PathVariable Long id) {
		
	}
	
	//list all image record
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public List<ImageRecord> listImageRecord(@PathVariable Long id) {
		return null;
	}
}
