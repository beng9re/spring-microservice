package com.study.microservice.api.core.recommendation;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface RecommendationService {

	@GetMapping(
		value    = "/recommendation",
		produces = MediaType.APPLICATION_JSON_VALUE)
	List<Recommendation> getRecommendations(@RequestParam(value = "productId", required = true) int productId);
}
