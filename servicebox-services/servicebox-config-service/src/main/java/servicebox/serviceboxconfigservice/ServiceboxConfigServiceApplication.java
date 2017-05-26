package servicebox.serviceboxconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ServiceboxConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceboxConfigServiceApplication.class, args);
	}
}
