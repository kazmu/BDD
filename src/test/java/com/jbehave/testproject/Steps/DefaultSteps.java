package com.jbehave.testproject.Steps;



import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.steps.Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;


public abstract class DefaultSteps extends Steps {
    public static WebDriver driver;

    @BeforeStories
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\kamila\\Desktop\\drivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions()
        .addPreference("dom.webnotifications.enabled", false).addPreference("om.webnotifications.serviceworker.enabled", false);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

    }
    //@AfterStories
   // public void tearDown() {driver.quit();}
}