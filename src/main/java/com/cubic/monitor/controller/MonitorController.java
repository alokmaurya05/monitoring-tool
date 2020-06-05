package com.cubic.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import io.prometheus.client.Counter;
import io.prometheus.client.Histogram;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

	@Autowired
	private WebClient.Builder webClient;

	// Define a counter metric for /prometheus
	static final Counter requests = Counter.build().name("requests_total").help("Total number of requests.").register();
	// Define a histogram metric for /prometheus
	static final Histogram requestLatency = Histogram.build().name("requests_latency_seconds")
			.help("Request latency in seconds.").register();

	@GetMapping(value = "/{domainName}")
	public Mono<HttpStatus> getData(@PathVariable("domainName") String domainName) {
		// Increase the counter metric
		requests.inc();
		// Start the histogram timer
		domainName = "https://" + domainName;
		Histogram.Timer requestTimer = requestLatency.startTimer();
		try { 
			Mono<HttpStatus> status = webClient.build().get().uri(domainName).exchange()
					.map(response -> response.statusCode());

			return status;
		} finally {
			// Stop the histogram timer
			requestTimer.observeDuration();
		}
	}
}
