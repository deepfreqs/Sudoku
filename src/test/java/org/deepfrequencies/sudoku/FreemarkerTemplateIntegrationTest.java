package org.deepfrequencies.sudoku;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.deepfrequencies.sudoku.ui.SudokuResponseBuilder;
import org.junit.Test;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;
import freemarker.template.TemplateException;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Application.class)
public class FreemarkerTemplateIntegrationTest {
    FreeMarkerConfigurer freeMarkerConfig;
	
	@Test
	public void testFreemarkerSpel() throws IOException, TemplateException {
	    FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
	    configurer.setTemplateLoaderPaths("classpath:/templates","classpath:org/springframework/web/servlet/view/freemarker");
		Template template = configurer.createConfiguration().getTemplate("sudoku.ftl");
	    

		//Configuration config = freeMarkerConfig.createConfiguration();		
		//Template template = config.getTemplate("sudoku.ftl");
		
	    Map<String, Object> input = SudokuResponseBuilder.getBuilder().createSudokuUI();

	    // Write output to the console
	    Writer consoleWriter = new OutputStreamWriter(System.out);
	    //template.process(input, consoleWriter);
	}

}