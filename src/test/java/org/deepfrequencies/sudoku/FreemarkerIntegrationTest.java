package org.deepfrequencies.sudoku;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import org.deepfrequencies.sudoku.ui.SudokuResponseBuilder;
import org.junit.Test;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import junit.framework.TestCase;

@SuppressWarnings("unused")
public class FreemarkerIntegrationTest extends TestCase {

	@Test
    public void test() throws Exception {

    // 1. Configure FreeMarker
    //
    // You should do this ONLY ONCE, when your application starts,
    // then reuse the same Configuration object elsewhere.

    Configuration cfg = new Configuration();

    // Where do we load the templates from:
    cfg.setClassForTemplateLoading(FreeMarkerConfigurer.class, "/templates");

    // Some other recommended settings:
    cfg.setIncompatibleImprovements(new Version(2, 3, 20));
    cfg.setDefaultEncoding("UTF-8");
    cfg.setLocale(Locale.US);
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    // 2. Process template(s)
    //
    // You will do this for several times in typical applications.

    // 2.1. Prepare the template input:

    Map<String, Object> input = SudokuResponseBuilder.getBuilder().createSudokuUI();

    // 2.2. Get the template

/*
    Template template = cfg.getTemplate("sudoku.ftl");

    // 2.3. Generate the output

    // Write output to the console
    Writer consoleWriter = new OutputStreamWriter(System.out);
    template.process(input, consoleWriter);

    // For the sake of example, also write output into a file:
    Writer fileWriter = new FileWriter(new File("output.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }
*/
    }
}
