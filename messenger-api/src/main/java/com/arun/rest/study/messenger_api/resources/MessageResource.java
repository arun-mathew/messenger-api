package com.arun.rest.study.messenger_api.resources;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.arun.rest.study.messenger_api.model.Message;
import com.arun.rest.study.messenger_api.service.MessangerService;

@Path("/resources")
public class MessageResource {
	
	MessangerService messangerService = new MessangerService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage()
	{
		return messangerService.getAllMessages();
	}

}
