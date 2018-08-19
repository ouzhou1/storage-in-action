package org.storage.demo.controller;

import org.storage.demo.dao.ImageRecordDao;
import org.storage.demo.domain.ImageRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author peter
 */

@Controller
public class ImageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);
    private final String localtime = new Date().toString();

    private final ImageRecordDao imgrcDao;

    @Autowired
    public ImageController(ImageRecordDao imgrcDao) {
        this.imgrcDao = imgrcDao;
    }

    @RequestMapping(value = "/v2/{owner}/{project}/manifest/{tag}", method = RequestMethod.GET)
    @ResponseBody
    public ImageRecord detectRequest(@PathVariable String owner, @PathVariable String project,
                                     @PathVariable String tag) {

        LOGGER.info("detectRequest called!");

        ImageRecord imgrc = new ImageRecord();
        imgrc.setOwner(owner);
        imgrc.setProject(project);
        imgrc.setTag(tag);
        imgrc.setUpdateTime(localtime);

        imgrcDao.save(imgrc);
        return imgrc;

    }

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ImageRecord getRecordByID(@PathVariable Long id) {

        ImageRecord imgrc = imgrcDao.findOne(id);
        if (imgrc != null) {
            return imgrc;
        } else {
            return null;
        }
    }

}
