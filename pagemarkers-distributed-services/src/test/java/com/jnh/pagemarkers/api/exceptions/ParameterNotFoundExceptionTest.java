package com.jnh.pagemarkers.api.exceptions;

import org.junit.Test;
import org.mockito.Mockito;

public class ParameterNotFoundExceptionTest {

    @Test(expected = ParameterNotFoundException.class)
    public void checkConstructorWithException()
            throws ParameterNotFoundException {
        String parameter = "parameter";
        Exception e = Mockito.mock(Exception.class);
        throw new ParameterNotFoundException(parameter, e);
    }

    @Test(expected = ParameterNotFoundException.class)
    public void checkConstructorWithoutException()
            throws ParameterNotFoundException {
        String parameter = "parameter";
        throw new ParameterNotFoundException(parameter);
    }
}
