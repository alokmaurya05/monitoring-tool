package com.cubic.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
//import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication(scanBasePackages = { "com.cubic.monitor.*" })
//Add a Prometheus metrics enpoint to the route `/prometheus`.
//@EnablePrometheusEndpoint
//Pull all metrics from Actuator and expose them as Prometheus metrics.
//@EnableSpringBootMetricsCollector
@EnableAutoConfiguration
public class MonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorApplication.class, args);
	}

	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}

}
