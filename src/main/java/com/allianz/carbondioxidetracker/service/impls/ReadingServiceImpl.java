package com.allianz.carbondioxidetracker.service.impls;

import java.util.List;
import java.util.Optional;

import com.allianz.carbondioxidetracker.common.ErrorMessages;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.dao.ReadingDao;
import com.allianz.carbondioxidetracker.entity.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allianz.carbondioxidetracker.repository.ReadingRepository;
import com.allianz.carbondioxidetracker.service.ReadingService;

@Service
public class ReadingServiceImpl implements ReadingService {
	
	private ReadingRepository readingRepository;

	private ReadingDao readingDao;


	@Override
	public Reading addReading(Reading reading) {

		if (IEmptyValidation.isEmpty(reading)) {
			throw IValidationException.withMessage(ErrorMessages.NULL_COMMAND) ;
		}

		return readingDao.save(reading) ;
	}

	@Override
	public List<Reading> retrieveReadings() {
		List<Reading> readingsList = readingRepository.findAll();
		return readingsList;
	}

	@Override
	public Reading getReading(Long readingId) {
		Optional<Reading> optReading = readingRepository.findById(readingId);
		return optReading.get();
	}

	@Autowired
	void setReadingDao(ReadingDao dao) {
		this.readingDao = dao;
	}

	@Autowired
	void setReadingRepository(ReadingRepository repository) {
		this.readingRepository = repository;
	}


}