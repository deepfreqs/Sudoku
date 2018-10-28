package org.deepfrequencies.sudoku;

import java.util.Arrays;

import org.deepfrequencies.sudoku.calculators.JustCalculateOptionsStrategy;
import org.deepfrequencies.sudoku.calculators.ObviousSinglesStrategy;
import org.deepfrequencies.sudoku.calculators.HiddenSinglesStrategy;
import org.deepfrequencies.sudoku.ui.SudokuResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			if (logger.isInfoEnabled()) {
				logger.info("See the beans provided by Spring Boot:");
			}
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				logger.info(beanName);
			}

		};
	}

	@Bean(name="responseBuilder")
	SudokuResponseBuilder responseBuilder() {
		return new SudokuResponseBuilder();
	}

	@Bean(name="obviousSinglesStrategy")
	ObviousSinglesStrategy obviousSinglesStrategy() {
		return new ObviousSinglesStrategy();
	}

	@Bean(name="justCalculateOptionsStrategy")
	JustCalculateOptionsStrategy justCalculateOptionsStrategy() {
		return new JustCalculateOptionsStrategy();
	}

	@Bean(name="hiddenSinglesStrategy")
	HiddenSinglesStrategy hiddenSinglesStrategy() {
		return new HiddenSinglesStrategy();
	}
}