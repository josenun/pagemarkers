package com.jnh.pagemarkers.api.provider;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class ProviderControllerTest {
    private ProviderController providerController;

    public ProviderControllerTest() {
        providerController = new ProviderController();
    }

    @Test
    public void checkCreatePagemarkersMethodUrlWithEndSlash() {
        String provider = "provider";
        String body = "body";
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setServerName("rooturl");
        request.setServerPort(80);
        request.setRequestURI("/");
        MockHttpServletResponse response = new MockHttpServletResponse();
        providerController.createPagemarker(provider, body, request, response);
        Assert.assertEquals("http://rooturl:80/" + provider,
                response.getHeader("Location"));
    }

    @Test
    public void checkCreatePagemarkersMethodUrlWithoutEndSlash() {
        String provider = "provider";
        String body = "body";
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setServerName("rooturl");
        request.setServerPort(80);
        request.setRequestURI("");
        MockHttpServletResponse response = new MockHttpServletResponse();
        providerController.createPagemarker(provider, body, request, response);
        Assert.assertEquals("http://rooturl:80/" + provider,
                response.getHeader("Location"));
    }
}
