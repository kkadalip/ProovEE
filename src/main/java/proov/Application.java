package proov;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// https://spring.io/guides/gs/serving-web-content/
@Configuration // tags the class as a source of bean definitions for the application context.
// https://stackoverflow.com/questions/27381781/java-spring-boot-how-to-map-my-app-root-to-index-html
// //@EnableAutoConfiguration // tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
// @EnableWebMvc // for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
//@ComponentScan // tells Spring to look for other components, configurations, and services in the proov package, allowing it to find the controllers.
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public InternalResourceViewResolver defaultViewResolver() {
//		return new InternalResourceViewResolver();
//	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("forward:/index.html");
//	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			log.info("Lets inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				log.info("beanName: " + beanName);
			}
		};
	}

}