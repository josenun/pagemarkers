package com.jnh.pagemarkers.api.provider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jnh.pagemarkers.api.BaseController;

/**
 * @author José Núñez Herrero.
 * 
 *         Provider Controller API.
 */
@Controller
@RequestMapping(value = "/provider")
public class ProviderController extends BaseController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProviderController.class);

    /**
     * Create pagemarker API.
     * 
     * @param provider
     * @param body
     * @param request
     * @param response
     */
    @RequestMapping(value = "/{provider}/pagemarkers", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public void createPagemarker(@PathVariable String provider,
            @RequestBody String body, HttpServletRequest request,
            HttpServletResponse response) {

        // CardInstance bodyRequest = checkBody(body, CardInstance.class);
        StringBuffer root = request.getRequestURL();
        String rootStr = root != null ? root.toString() : "";
        if (rootStr != null && rootStr.endsWith("/")) {
            rootStr = rootStr.substring(0, rootStr.length() - 1);
        }
        String location = String.format("%s/%s", rootStr, provider);
        response.setHeader("Location", location);
    }

}
