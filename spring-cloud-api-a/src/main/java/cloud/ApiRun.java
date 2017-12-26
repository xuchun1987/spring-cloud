package cloud;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class ApiRun extends SpringBootServletInitializer {
	private final static Logger logger = Logger.getLogger(ApiRun.class);
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApiRun.class);
	}

	 public static void main(String[] args) {

		 SpringApplication.run(ApiRun.class, args);

		/* Runtime.getRuntime().addShutdownHook(new Thread(){
			 @Override
			 public void run() {
				 logger.info("Shutting down scloud-pmpf-consumer, unregister from Eureka!");
				 DiscoveryManager.getInstance().shutdownComponent();
			 }
		 });*/

	}

}
