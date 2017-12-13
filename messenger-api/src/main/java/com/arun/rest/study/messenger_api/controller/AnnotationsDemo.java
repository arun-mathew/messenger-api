package com.arun.rest.study.messenger_api.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/annotations")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class AnnotationsDemo {
	
	@GET
	@Path("/demo")
	public String getAnnotation(@MatrixParam("matParam") String matParam,
			                    @HeaderParam("hParam") String headerParam) {
		return "Matrix param "+matParam+" HeaderParam"+headerParam;
	}
	
	@GET
	@Path("/context")
	public String contextDemo(@Context UriInfo uriInfo,
			                  @Context HttpHeaders header) {
		return "UriInfo "+uriInfo.getAbsolutePath()+" Heder info "+ header.getDate();
	}

}
