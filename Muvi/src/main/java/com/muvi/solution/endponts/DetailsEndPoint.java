package com.muvi.solution.endponts;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.muvi.solution.service.DetailsService;

@Component
@Path("/details")
public class DetailsEndPoint {
	private static final Logger logger = LoggerFactory.getLogger(DetailsEndPoint.class);
	@Inject
	private DetailsService detailsService;

	@GET
	@Path("/add")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.TEXT_HTML)
	public Response addDetails(@QueryParam(value = "email") String email, @QueryParam(value = "phone") long phone,
			@QueryParam(value = "passport") String passport) {
		
		logger.info("Details to be added with values");
		detailsService.submitData(email, phone, passport);
		return Response.status(Status.OK).build();
	}

}
