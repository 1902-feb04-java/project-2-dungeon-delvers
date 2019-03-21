package DD;

import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DD.service.AccountService;

@SpringBootApplication
public class Application {
	
    public static void main(String[] args) {
    	
//		ArtistRepository artistRepository = new ArtistRepository();
//		ArtistService artistService = new ArtistService(artistRepository);
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
//		ApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
        SpringApplication.run(Application.class, args);
//		((AbstractApplicationContext) context).close();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}