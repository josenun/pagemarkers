package com.jnh.pagemarkers;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;

/**
 * Pojo Tester.
 */
public abstract class AbstractPojoTester {

    @SuppressWarnings("rawtypes")
    private Map testValues = new HashMap();

    /**
     * Add a Test Value into the map testValues.
     */
    @SuppressWarnings("unchecked")
    protected void addTestValue(
            @SuppressWarnings("rawtypes") Class propertyType, Object testValue) {
        testValues.put(propertyType, testValue);
    }

    /**
     * Set up a defined values for each type to test the methods.
     */
    @SuppressWarnings("rawtypes")
    @Before
    public void setUpTestValues() throws Exception {
        // add in further test values here.
        addTestValue(String.class, "foo");
        addTestValue(int.class, 123);
        addTestValue(Integer.class, 123);
        addTestValue(double.class, 123.0);
        addTestValue(long.class, 123L);
        addTestValue(Long.class, 123L);
        addTestValue(Double.class, 123.0);
        addTestValue(boolean.class, true);
        addTestValue(Boolean.class, true);
        addTestValue(java.util.Date.class, new java.util.Date(1342040626000L));
        addTestValue(List.class, new ArrayList());
        addTestValue(Map.class, new HashMap());
    }

    /**
     * Call from subclass.
     */
    protected void testPojo(@SuppressWarnings("rawtypes") Class pojoClass) {
        try {
            Object pojo = pojoClass.newInstance();
            BeanInfo pojoInfo = Introspector.getBeanInfo(pojoClass);
            for (PropertyDescriptor propertyDescriptor : pojoInfo
                    .getPropertyDescriptors()) {
                testProperty(pojo, propertyDescriptor);
            }
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            ;
        }
    }

    private void testProperty(Object pojo, PropertyDescriptor propertyDescriptor) {
        try {
            @SuppressWarnings("rawtypes")
            Class propertyType = propertyDescriptor.getPropertyType();
            Object testValue = testValues.get(propertyType);
            if (testValue == null) {
                return;
            }
            Method writeMethod = propertyDescriptor.getWriteMethod();
            Method readMethod = propertyDescriptor.getReadMethod();
            if (readMethod != null && writeMethod != null) {
                writeMethod.invoke(pojo, testValue);
                Assert.assertEquals(readMethod.invoke(pojo), testValue);
            }
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            ;
        }
    }
}
