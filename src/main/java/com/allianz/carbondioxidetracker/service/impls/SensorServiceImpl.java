package com.allianz.carbondioxidetracker.service.impls;

import com.allianz.carbondioxidetracker.common.ErrorCode;
import com.allianz.carbondioxidetracker.common.ErrorMessage;
import com.allianz.carbondioxidetracker.common.IEmptyValidation;
import com.allianz.carbondioxidetracker.common.IValidationException;
import com.allianz.carbondioxidetracker.entity.Reading;
import com.allianz.carbondioxidetracker.entity.Sensor;
import com.allianz.carbondioxidetracker.repository.SensorRepository;
import com.allianz.carbondioxidetracker.service.ReadingInputCommand;
import com.allianz.carbondioxidetracker.service.ReadingInputResult;
import com.allianz.carbondioxidetracker.service.SensorService;
import com.allianz.carbondioxidetracker.service.adaptors.ReadingInputCommandAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class SensorServiceImpl implements SensorService {
	
	private SensorRepository sensorRepository;
	
	private ReadingInputCommandAdaptor readingInputCommandAdaptor;
	
	@Override
	public ReadingInputResult addReading(ReadingInputCommand command) {

		final Reading reading = readingInputCommandAdaptor.adopt(command) ;

		if (IEmptyValidation.isEmpty(reading))
			throw IValidationException.of(ErrorCode.NULL_COMMAND, ErrorMessage.NULL_COMMAND.getValue()) ;

		final Optional<Sensor> sensorWrapper = sensorRepository.findById(command.getSensorId()) ;

		if (!sensorWrapper.isPresent())
			throw IValidationException.of(ErrorCode.SENSOR_NOT_FOUND, ErrorMessage.SENSOR_NOT_FOUND.getValue()) ;

		final Sensor sensor = sensorWrapper.get() ;

		sensor.getSensorReadings().add(reading);

		sensorRepository.save(sensor) ;

		return ReadingInputResult.builder()
				.setReadingId(reading.getId())
				.setSensorId(command.getSensorId())
				.setDate(reading.getTime())
				.setReadingValue(reading.getReadingValue())
				.build() ;
	}

	@Override
	public List<Sensor> retrieveSensors() {
		List<Sensor> sensorList = sensorRepository.findAll();
		return sensorList;
	}

	@Override
	public Sensor getSensorById(String sensorId) {
		Optional<Sensor> optSensor = sensorRepository.findById(sensorId);
		return optSensor.get();
	}

	@Override
	public void saveSensor(Sensor sensor) {
		sensorRepository.save(sensor);
		
	}

	@Override
	public List<Sensor> getSensorReadingsByCity(String city) {
		List<Sensor> sensorReadings = sensorRepository.findSensorByCity(city);
		return sensorReadings;
		
	}

	@Override
	public List<Sensor> getSensorReadingsByDistrict(String district) {
		List<Sensor> sensorReadings = sensorRepository.findSensorByDistrict(district);
		return sensorReadings;
	}

	@Autowired
	void setSensorRepository(SensorRepository sensorRepository) {
		this.sensorRepository = sensorRepository;
	}

	@Autowired
	void setReadingInputCommandAdaptor(ReadingInputCommandAdaptor adaptor) {
		this.readingInputCommandAdaptor = adaptor;
	}

}
