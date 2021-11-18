package com.example.demo.config;

import org.springdoc.core.OpenAPIService;
import org.springdoc.webflux.api.OpenApiWebfluxResource;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import reactor.blockhound.BlockHound;

@Component
@Log4j2
public class BlockHoundConfig {
	
	@EventListener(ApplicationReadyEvent.class)
	void init() {
		BlockHound.install(
				b -> /* To allow openapi */ b.allowBlockingCallsInside(OpenAPIService.class.getName(), "getApiDefClass"),
				b -> /* To allow openapi */ b.allowBlockingCallsInside(OpenApiWebfluxResource.class.getName(), "openapiJson")
				);
		log.info("Blockhound is installed");
	}
}
