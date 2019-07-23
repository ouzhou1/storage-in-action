package org.peterpark.storage.dao;

import java.util.List;

import org.peterpark.storage.domain.ImageRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ImageRecordDao extends CrudRepository<ImageRecord, Long> {
	
	List<ImageRecord> findImageRecordById(Long id);
	
}
