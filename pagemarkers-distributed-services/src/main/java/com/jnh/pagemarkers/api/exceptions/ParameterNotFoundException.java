package com.jnh.pagemarkers.api.exceptions;

import java.io.IOException;

/**
 * @author José Núñez Herrero
 * 
 *         Parameter Not Found Exception class.
 */
public class ParameterNotFoundException extends Exception {

    private static final long serialVersionUID = -4260131071780669388L;

    /**
     * Constructor.
     * 
     * @param parameterName
     */
    public ParameterNotFoundException(String parameterName) {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor.
     * 
     * @param parameterName
     * @param e
     */
    public ParameterNotFoundException(String parameterName, IOException e) {
        // TODO Auto-generated constructor stub
    }

}
