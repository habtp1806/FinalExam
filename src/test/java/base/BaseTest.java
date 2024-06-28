package base;


import org.testng.annotations.*;

import java.net.MalformedURLException;


public class BaseTest {
    protected static String email = "nhldxvtv@guerrillamail.com";
    protected static String password = "123456789";
    protected static String confirmPassword = "123456789";
    protected static String pid = "123456789";


    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (DriverManager.driver != null) {
            DriverManager.driver.quit();
        }
    }
}
