package org.peterpark.storage.controller;

import org.peterpark.storage.dao.ImageRecordDao;
import org.peterpark.storage.domain.ImageRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author peter
 */
@RestController
@RequestMapping(value = "/image")
public class ImageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);
    private final String localtime = new Date().toString();

    private final ImageRecordDao imgrcDao;

    @Autowired
    public ImageController(ImageRecordDao imgrcDao) {
        this.imgrcDao = imgrcDao;
    }

    @GetMapping(value = "/v2/{owner}/{project}/manifest/{tag}")
    public ImageRecord detectRequest(@PathVariable String owner,
                                     @PathVariable String project,
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

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public ImageRecord getRecordByID(@RequestHeader(name="id", defaultValue = "1") @Param(value = "id")  Long id) {

        ImageRecord imgrc = imgrcDao.findOne(id);
        if (imgrc != null) {
            return imgrc;
        } else {
            return null;
        }
    }

}
