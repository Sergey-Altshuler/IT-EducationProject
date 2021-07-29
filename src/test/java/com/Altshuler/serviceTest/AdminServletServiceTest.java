package com.Altshuler.serviceTest;

import com.Altshuler.H2DataGenerator;
import com.Altshuler.servlce.AdminServletService;
import org.testng.annotations.Test;

import static com.Altshuler.TestInfo.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminServletServiceTest extends H2DataGenerator {
    AdminServletService adminServletService = new AdminServletService();

    @Test
    void validate() {
        adminServletService.initialize();
        assertTrue(adminServletService.validate(ADMIN_LOGIN, ADMIN_PASSWORD));
        adminServletService.changeProperties(ADMIN_LOGIN_CHANGED, ADMIN_PASSWORD_CHANGED);
        assertTrue(adminServletService.validate(ADMIN_LOGIN_CHANGED, ADMIN_PASSWORD_CHANGED));
    }

}
