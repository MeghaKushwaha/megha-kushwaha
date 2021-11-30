package com.monefy.automation.fe.browserstack;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Manage the creation of the WebDriver for BrowserStack executions
 */
public class BrowserStackSerenityDriver implements DriverSource {

    /**
     * Creates a new WebDriver Get the desired capabilities using the SystemEnvironmentVariables class
     * That capabilities are loaded from one properties file
     *
     * @return WebDriver
     */
    public WebDriver newDriver() {

        EnvironmentVariables environmentVariables = SystemEnvironmentVariables
                .createEnvironmentVariables();
        //BrowserStack Credentials
        String user = environmentVariables.getProperty("browserstack.user");
        String key = environmentVariables.getProperty("browserstack.key");
        //BrowserStack Server
        String server = environmentVariables.getProperty("browserstack.server");
        //BrowserStack Capabilities
        String build = environmentVariables.getProperty("browserstack.build");
        String project = environmentVariables.getProperty("browserstack.project");
        //BrowserStack Browser
        String browser = environmentVariables.getProperty("browserstack.browser");
        String browserVersion = environmentVariables.getProperty("browserstack.browser_version");
        String resolution = environmentVariables.getProperty("browserstack.resolution");
        //BrowserStack Platform
        String os = environmentVariables.getProperty("browserstack.os");
        String osVersion = environmentVariables.getProperty("browserstack.os_version");
        //BrowserStack Options
        Boolean debug = Boolean.valueOf(environmentVariables.getProperty("browserstack.debug"));
        Boolean local = Boolean.valueOf(environmentVariables.getProperty("browserstack.local"));

        //Defining defaults
        if (StringUtils.isEmpty(browser)) {
            browser = "IE";
        }
        if (StringUtils.isEmpty(browserVersion)) {
            browserVersion = "11.0";
        }
        if (StringUtils.isEmpty(os)) {
            os = "Windows";
        }
        if (StringUtils.isEmpty(osVersion)) {
            osVersion = "7";
        }

        if (StringUtils.isEmpty(resolution)) {
            resolution = "1920x1080";
        }

        //BrowserStack capabilities -> https://www.browserstack.com/automate/capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", build);
        capabilities.setCapability("project", project);
        //Desired Browser
        capabilities.setCapability("browser", browser);
        capabilities.setCapability("browser_version", browserVersion);
        capabilities.setCapability("resolution", resolution);
        //Desired Platform
        capabilities.setCapability("os", os);
        capabilities.setCapability("os_version", osVersion);
        //BrowserStack Options
        capabilities.setCapability("browserstack.debug", debug);
        capabilities.setCapability("browserstack.local", local);

        //Uncomment if you want to use browserstack-local in your local executions
        //You will also need browserstack-local-java dependency in your pom.xml
    /*
    if (local) {
      Local bsLocal = new Local();
      HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
      bsLocalArgs.put("key", key);
      try {
        bsLocal.start(bsLocalArgs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    */

        try {
            return new RemoteWebDriver(new URL("http://" + user + ":" + key + "@" + server + "/wd/hub"),
                    capabilities);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Return true if the driver is configured to take screenshots
     */
    public boolean takesScreenshots() {
        return false;
    }
}
