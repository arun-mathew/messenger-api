package com.arun.rest.study.messenger_api.controller;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.arun.rest.study.messenger_api.model.Message;
import com.arun.rest.study.messenger_api.service.MessangerService;

@Path("/messages")
public class MessageController {
	
	MessangerService messangerService = new MessangerService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage()
	{
		return messangerService.getAllMessages();
	}
	
	@GET
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMassage(@PathParam("messageId") long id)
	{
		return messangerService.getMessage(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public Message addMessage( Message message) {
		return messangerService.addMessage(message);
	}
}
