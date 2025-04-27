package lt.vilniustech.YHev.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import lt.vilniustech.YHev.first.config.TestConfig;


@SpringBootApplication
@EnableConfigurationProperties(TestConfig.class)
public class FirstSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstSpringApplication.class, args);
	}

}
