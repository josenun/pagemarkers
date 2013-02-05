package com.jnh.pagemarkers.api.exceptions;


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
        super("Parameter not found '" + parameterName + "'.");
    }

    /**
     * Constructor.
     * 
     * @param parameterName
     * @param e
     */
    public ParameterNotFoundException(String parameterName, Exception e) {
        super("Parameter not found '" + parameterName + "'.", e);
    }

}
