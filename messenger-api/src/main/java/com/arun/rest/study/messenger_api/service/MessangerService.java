package com.arun.rest.study.messenger_api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.arun.rest.study.messenger_api.dao.Dao;
import com.arun.rest.study.messenger_api.model.Message;

public class MessangerService {
	
	private Map<Long, Message> messages = Dao.getMessages();
	
	public MessangerService() {
				
		messages.put((long) 1, new Message(1, "message one", "arun"));
		messages.put((long) 2, new Message(2, "message two", "mathew"));
		messages.put((long) 3, new Message(3, "message three", "ancy"));
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());		
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;			
	}
	
	public Message deleteMessage(long id) {		
		return messages.remove(id);
	}
}
