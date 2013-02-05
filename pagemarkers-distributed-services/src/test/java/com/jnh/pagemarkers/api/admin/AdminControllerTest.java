package com.jnh.pagemarkers.api.admin;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

public class AdminControllerTest {
    private AdminController adminController;

    public AdminControllerTest() {
        adminController = new AdminController();
    }

    @Test
    public void checkPingMethod() {
        Locale locale = Locale.ENGLISH;
        Model model = Mockito.mock(Model.class);
        Assert.assertEquals("home", adminController.home(locale, model));
    }

}
