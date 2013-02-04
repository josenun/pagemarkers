package com.jnh.pagemarkers.api.dto;

import org.junit.Assert;
import org.junit.Test;

import com.jnh.pagemarkers.AbstractPojoTester;

/**
 * Generic Wallet Response Test.
 */
public class GenericResponseTest extends AbstractPojoTester {

    /**
     * Constructor.
     */
    public GenericResponseTest() {
    }

    /**
     * Test getter and setter methods from a class.
     */
    @Test
    public void testGettersAndSetters() {
        testPojo(GenericResponse.class);
    }

    @Test
    public void checkConstructor() {
        String identifier = "Identifier";
        String category = "Category";
        String description = "Description";
        String details = "Details";
        GenericResponse genericResponse = new GenericResponse(identifier,
                category, description, details);
        Assert.assertEquals(identifier, genericResponse.getId());
        Assert.assertEquals(category, genericResponse.getCategory());
        Assert.assertEquals(description, genericResponse.getDescription());
        Assert.assertEquals(details, genericResponse.getDetails());
    }

    @Test
    public void checkToStringMethod() {
        GenericResponse genericResponse = new GenericResponse("Identifier",
                "Category", "Description", "Details");
        Assert.assertEquals(
                "GenericResponse [id=Identifier, category=Category, description=Description, details=Details",
                genericResponse.toString());
    }

}
