package example;

import com.intuit.karate.Results;
import net.masterthought.cucumber.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 class runTest {
    @Test
    void testParallel() {
        Results results = Runner.path("classpath:example").outputCucumberJson(true)
                .parallel(5);
        generateReport(results.getReportDir());
        //assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }


     public static void generateReport(String karateOutputPath) {
         Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
         List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
         jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
         Configuration config = new Configuration(new File("target"), "demo");
         ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
         reportBuilder.generateReports();
     }
    }

