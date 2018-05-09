package com.muvi.solution.config;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.muvi.solution.endponts.DetailsEndPoint;


@Component
@ApplicationPath("/muvi")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(DetailsEndPoint.class);
	}
}
