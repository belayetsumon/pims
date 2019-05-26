package itgarden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@SpringBootApplication  
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//@EnableJpaRepositories(basePackages ={"itgarden.repository"} )
//@EnableTransactionManagement
//@EnableGlobalMethodSecurity(prePostEnabled = true)
 @EnableGlobalMethodSecurity(securedEnabled = true)
public class ItgardenbaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItgardenbaseApplication.class, args);
	}
}
