package com.arun.rest.study.messenger_api.controller;


import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.arun.rest.study.messenger_api.model.Annotation;
import com.arun.rest.study.messenger_api.model.Message;
import com.arun.rest.study.messenger_api.service.MessangerService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageController {
	
	MessangerService messangerService = new MessangerService();
	
	@GET
	public List<Message> getMessages(@BeanParam Annotation annotation){
		
		if(annotation.getYear() > 0) {
			return messangerService.getAllMessagesForYear(annotation.getYear());
		}
		if(annotation.getStart() >= 0 && annotation.getEnd() >= 0) {
			return messangerService.getMessagePaginated(annotation.getStart(), annotation.getEnd());
		}
		return messangerService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMassage(@PathParam("messageId") long id)
	{
		return messangerService.getMessage(id);
	}
	
	@POST
	public Message addMessage(Message message) {
		return messangerService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		message.setId(messageId);
		return messangerService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		return messangerService.deleteMessage(messageId);
	}
	
}
