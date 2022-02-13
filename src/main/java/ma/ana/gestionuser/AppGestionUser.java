package ma.ana.gestionuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"ma.ana.gestionuser"})
public class AppGestionUser {

	public static void main(String[] args) {
		SpringApplication.run(AppGestionUser.class, args);
	}

}
