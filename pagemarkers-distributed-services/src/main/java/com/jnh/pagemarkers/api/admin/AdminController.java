package com.jnh.pagemarkers.api.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author José Núñez Herrero.
 * 
 *         Administrator controller API.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AdminController.class);

    /**
     * Ping API.
     * 
     * @param locale
     * @param model
     * @return view
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        LOGGER.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

}
