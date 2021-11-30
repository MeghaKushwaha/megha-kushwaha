package com.monefy.automation.fe.helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Helpers {

    /**
     * Get value from environment variable
     *
     * @param key to get value
     * @return value from environment variable
     */
    public static String getEnvironmentVariable(String key) {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        return environmentVariables.getProperty(key);
    }

    public String getBaseURL() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        String baseURL = ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(environmentVariables);
        return baseURL;
    }

}

