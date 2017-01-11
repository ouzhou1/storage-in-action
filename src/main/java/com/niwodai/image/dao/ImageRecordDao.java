package com.niwodai.image.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.niwodai.image.domain.ImageRecord;

@Component
public interface ImageRecordDao extends CrudRepository<ImageRecord, Long> {
	
	List<ImageRecord> findImageRecordByID(Long id);
	
}
