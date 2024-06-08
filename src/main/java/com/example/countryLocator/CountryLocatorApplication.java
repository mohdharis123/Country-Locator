package com.example.countryLocator;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
class CounrtyLocatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CounrtyLocatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final CountryLocator countryLocator = new CountryLocator();
		final int requestsPerSecond = 100;
		final int durationSeconds = 10;
		ExecutorService executorService = Executors.newFixedThreadPool(requestsPerSecond);

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < requestsPerSecond * durationSeconds; i++) {
			executorService.submit(() -> {
				countryLocator.getCountryCode(37.7749, -122.4194); // Example coordinates
			});
		}

		executorService.shutdown();
		executorService.awaitTermination(durationSeconds + 1, TimeUnit.SECONDS);
		long endTime = System.currentTimeMillis();

		long totalRequests = requestsPerSecond * durationSeconds;
		long totalTime = endTime - startTime;
		double averageTimePerRequest = (double) totalTime / totalRequests;

		System.out.println("Average execution time per request: " + averageTimePerRequest + " ms");
	}
}

