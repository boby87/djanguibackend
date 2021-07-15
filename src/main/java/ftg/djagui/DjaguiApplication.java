package ftg.djagui;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DjaguiApplication implements CommandLineRunner {
	@Bean
	public BCryptPasswordEncoder getBcp() {
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(DjaguiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
