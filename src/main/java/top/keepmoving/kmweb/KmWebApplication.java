package top.keepmoving.kmweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import top.keepmoving.kmweb.domain.OrganizationRepository;

@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
//@EntityScan(basePackages = {"top.keepmoving.kmweb.web.quartz.domain"})
public class KmWebApplication {

	private static final Logger log = LoggerFactory.getLogger(KmWebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KmWebApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(OrganizationRepository repository) {
		return (args) -> {
			// fetch all customers
			log.info("Organizations found with findAll():");
			log.info("-------------------------------");
			/*for (Organization organization : repository.findAll()) {
				log.info(organization.toString());
			}*/
			log.info("");
		};
	}

}
