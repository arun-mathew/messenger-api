package com.arun.rest.study.messenger_api.controller;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/paramAnnotations")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class ParamAnnotations {
	
	@GET
	public String getAnnotations(@MatrixParam("param") String matrixParam,
								 @HeaderParam("hparam") String headerParam)
	{
		return "Matrix param :"+matrixParam + "Header param :"+headerParam;
	}

}
