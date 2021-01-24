package com.allianz.carbondioxidetracker.service;

import com.allianz.carbondioxidetracker.controller.ReadingGetRequest;
import com.allianz.carbondioxidetracker.entity.Sensor;

import java.text.ParseException;
import java.util.List;

/**
 * This service class is used to expose relevant CRUD operation on Sensor entity. @see SensorServiceImpl
 *
 */
public interface SensorService {
	
	 public ReadingInputResult addReading(ReadingInputCommand command);

	 public List<Sensor> retrieveSensors();
	  
	 public Sensor getSensorById(String sensorId);
	  
	 public void saveSensor(Sensor sensor);
	 
	 public List<SensorGetResponse> search(ReadingGetRequest readingGetRequest) throws ParseException;
	 
}
