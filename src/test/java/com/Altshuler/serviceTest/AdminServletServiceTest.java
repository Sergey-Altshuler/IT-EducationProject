package com.Altshuler.serviceTest;

import com.Altshuler.H2DataGenerator;
import com.Altshuler.servlce.AdminServletService;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminServletServiceTest extends H2DataGenerator {
    AdminServletService adminServletService = new AdminServletService();

    @Test
    void validate(){
        adminServletService.initialize();
        assertTrue(adminServletService.validate("admin", "password"));
        adminServletService.changeProperties("login", "pass");
        assertTrue(adminServletService.validate("login", "pass"));
    }

}
