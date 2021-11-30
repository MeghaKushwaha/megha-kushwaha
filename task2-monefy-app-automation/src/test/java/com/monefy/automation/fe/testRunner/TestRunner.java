package com.monefy.automation.fe.testRunner;

import com.epam.ta.reportportal.ws.model.log.SaveLogRQ;
import com.github.invictum.reportportal.LogsPreset;
import com.github.invictum.reportportal.ReportIntegrationConfig;
import com.github.invictum.reportportal.Utils;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.model.TestResult;
import net.thucydides.core.model.TestStep;
import net.thucydides.core.screenshots.ScreenshotAndHtmlSource;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.function.Function;

/**
 * TestRunner class
 *
 * Cucumber options default set, change according to your needs
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        features={"src/test/resources/features/fe/HomeScreen.feature"},
        glue = {"com.monefy.automation"}
)
public class TestRunner {

    /**
     * Setup your test configuration here
     *
     * Serenity integration with Reporting Portal offers 3 logs output configurations
     * DEFAULT      - recommended
     * FULL
     * CUSTOM       - recommended if you need to customize the output
     *                For example: save screenshots testing desktop applications
     *
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @BeforeClass
    public static void setup() throws Exception {
        try {
            ReportIntegrationConfig reportIntegrationConfig = ReportIntegrationConfig.get();
            //DEFAULT preset
            LogsPreset preset = LogsPreset.DEFAULT;

            reportIntegrationConfig.usePreset(preset);

            //Activated to avoid errors while testing very long scenarios
            reportIntegrationConfig.truncateNames(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * Customized logging of steps and screenshots in Reporting Portal
     *
     * Change according to your needs
     */
    static Function<TestStep, Collection<SaveLogRQ>> myCustomizedPreset = step -> {
        SaveLogRQ log = new SaveLogRQ();
        try {
            Date startDate = Utils.stepStartDate(step);
            Date startEnd = Utils.stepEndDate(step);
            attachScreenShot(step, log);
            if (TestResult.FAILURE.equals(step.getResult())) {
                log.setMessage(step.getResult() + " " + step.getDescription() + "\n\n"
                        + ExceptionUtils.getStackTrace(step.getException().toException()) + "\n\nStep Start Date: "
                        + startDate.toInstant() + "\nStep End Date: " + startEnd.toInstant());
            } else {
                log.setMessage(step.getResult() + " " + step.getDescription() + "\n\nStep Start Date: "
                        + startDate.toInstant() + "\nStep End Date: " + startEnd.toInstant());
            }
            log.setLogTime(startDate);
            log.setLevel(Utils.logLevel(step.getResult()));
        } catch (Exception t) {
            log.setMessage(t.getMessage());
            log.setLevel(Utils.logLevel(TestResult.ERROR));
        }
        return Collections.singleton(log);
    };

    /**
     * Attach screenshot to the current log
     *
     * @param step
     * @param log
     */
    private static void attachScreenShot(TestStep step, SaveLogRQ log){
        for (ScreenshotAndHtmlSource screenshotAndHtmlSource : step.getScreenshots()) {
            System.out.println("Screenshot "  + screenshotAndHtmlSource);
            File screenshot = screenshotAndHtmlSource.getScreenshot();
            if (screenshot != null) {
                SaveLogRQ.File attachedF = new SaveLogRQ.File();
                try {
                    attachedF.setContent(Files.readAllBytes(screenshot.toPath()));
                    attachedF.setContentType("image/png");
                    attachedF.setName(screenshot.getName());
                } catch (Exception t) {
                    t.printStackTrace();
                }
                log.setFile(attachedF);
            }
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {}

}
