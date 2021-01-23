package com.allianz.carbondioxidetracker.boundary.adaptors;

import com.allianz.carbondioxidetracker.common.IAdaptor;
import com.allianz.carbondioxidetracker.controller.AddCarbonReadingRequest;
import com.allianz.carbondioxidetracker.entity.Reading;

public interface AddReadingRequestAdaptor
//        extends IAdaptor<AddCarbonReadingRequest, CarbonDioxideValueAddCommand> {
        extends IAdaptor<AddCarbonReadingRequest, Reading> {
}
