package org.storage.demo.dao;

import java.util.List;

import org.storage.demo.domain.ImageRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ImageRecordDao extends CrudRepository<ImageRecord, Long> {
	
	List<ImageRecord> findImageRecordById(Long id);
	
}
