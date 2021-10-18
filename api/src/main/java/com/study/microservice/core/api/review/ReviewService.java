package com.study.microservice.core.api.review;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewService {
	@GetMapping(
		value    = "/review",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	List<Review> getReviews(@RequestParam(value = "productId", required = true) int productId);
}
