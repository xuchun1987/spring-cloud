package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication //整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
public class GatewayRun extends SpringBootServletInitializer { //implements EmbeddedServletContainerCustomizer

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GatewayRun.class);
	}

	 public static void main(String[] args) {

	        SpringApplication.run(GatewayRun.class, args);
	    }
	 
	/*@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}*/
		
	/*@Override
	public void customize(ConfigurableEmbeddedServletContainer arg0) {
		arg0.setPort(8080);
	}
*/
}
