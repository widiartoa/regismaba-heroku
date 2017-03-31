package id.ac.univ.regismaba;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import id.ac.univ.regismaba.storage.StorageProperties;
import id.ac.univ.regismaba.storage.StorageService;

@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication
public class RegismabaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegismabaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            //storageService.deleteAll();
            storageService.init();
		};
	}
	
}
