package com.aggregator.controller;
	import java.util.Arrays;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpEntity;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpMethod;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aggregator.entity.Provider;
import com.aggregator.service.ProviderService;
import com.aggregator.utils.Response;

	@RestController
	@RequestMapping("/healthInsurancePlan")
	public class ProviderController {

		@Autowired
		private ProviderService providerService;

		@PostMapping(value = "/provider/register")
		public ResponseEntity<Response> registerProviders(@Valid @RequestBody Provider provider) {

			Provider result = providerService.registerProvider(provider);
			if (result != null) {
				return new ResponseEntity<Response>(new Response("Provider Registered Successfully", null),
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Response>(new Response("registration failed......", null),
						HttpStatus.BAD_REQUEST);
			}
		}

			@GetMapping(path = "/provider/getAllPlans/{providerName}")
		public ResponseEntity<Response> getAllPlansOfProvider(@PathVariable("providerName") String providerName) {

			Provider result = providerService.checkProviderExists(providerName);
			if (result != null) {

				final String url = result.getProviderGetPlanUrl();
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

				ResponseEntity<Response> resultObj = restTemplate.exchange(url, HttpMethod.GET, entity, Response.class);
				return resultObj;

			} else {
				return new ResponseEntity<Response>(new Response("No provider found.", null), HttpStatus.BAD_REQUEST);
			}
		}
			
			
	}
