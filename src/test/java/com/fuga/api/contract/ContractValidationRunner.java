package com.fuga.api.contract;


import com.fuga.karate.reporter.markdown.FreemarkerTemplateRenderer;
import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import cucumber.api.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertTrue;

/**
 * Verifies whether the exposed APIs are compliant to their contract
 */
//@RunWith(Karate.class)
@KarateOptions(tags = {"~@ignore"})
@CucumberOptions(
        plugin = {"com.fuga.karate.reporter.markdown.FreemarkerFormatter"}
)
public class ContractValidationRunner {

    @Test
    public void testParallel() {
        //System.setProperty("karate.env", "demo"); // ensure reset if other tests (e.g. mock) had set env in CI
        Results results = Runner.parallel(getClass(), 5);
        generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));

        // Determine location where generated contract documentation is persisted
        if(System.getProperty("ENDPOINTS_SERVICE_NAME") == null) {
            throw new RuntimeException("Missing parameter `ENDPOINTS_SERVICE_NAME`");
        }
        final File file = new File(System.getProperty("ENDPOINTS_SERVICE_NAME"), "contract.md");

        FreemarkerTemplateRenderer renderer = new FreemarkerTemplateRenderer();
        for(String result : jsonPaths) {

            try(Stream<String> lines = Files.lines(Paths.get(result))) {
                String content = lines.collect(Collectors.joining(System.lineSeparator()));
                String report = renderer.render(content, "contract.ftl");
                FileUtils.write(file, report);
            } catch(IOException error) {
                error.printStackTrace();
            }
        }
//        Configuration config = new Configuration(new File("target"), "demo");
//        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
//        reportBuilder.generateReports();
    }

}
