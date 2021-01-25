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
package com.allianz.carbondioxidetracker.common;

public final class IValidationException extends IServiceRuntimeException {


    public IValidationException(ErrorCode errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public static IValidationException of(ErrorCode errorCode, String errorMessage) {
        return new IValidationException(errorCode, errorMessage) ;
    }
}
