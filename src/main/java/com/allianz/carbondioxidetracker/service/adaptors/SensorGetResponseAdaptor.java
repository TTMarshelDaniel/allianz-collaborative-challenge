/*
 * This is only for an interview purpose in Allianz Technology,
 * This code is developed by 4 interview candidates.
 * This is written in free version Java 8 .
 * This is written in spring boot version 2.4.2 .
 * This is an open source .
 * This code meets most of the SOLID principles.
 * No Copyrights or no rights reserved .
 * Any one can use this code for their organization, personal or learning purposes.
 * ANY ONE CAN ALTER THIS CODE OR THIS FILE.
 * @author Team Player-1
 * @author Team Player-2
 * @author Team Player-3
 * @author Team Player-4
 */
package com.allianz.carbondioxidetracker.service.adaptors;

import com.allianz.carbondioxidetracker.common.IAdaptor;
import com.allianz.carbondioxidetracker.repository.entity.Sensor;
import com.allianz.carbondioxidetracker.service.SensorGetResponse;
/**
 * This interface is a Adaptor interface extends from IAdaptor to adopt Sensor to SensorGetResponse
 * <p>
 * See {@link Sensor}
 * See {@link SensorGetResponse}
 * See {@link IAdaptor}
 * </p>
 * @version v1
 * @since 1.0
 */
public interface SensorGetResponseAdaptor extends IAdaptor<Sensor, SensorGetResponse> {

}
